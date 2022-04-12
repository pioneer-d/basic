package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CameraMetadata;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.ImageReader;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Size;
import android.util.SparseIntArray;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.util.Arrays;


public class MainActivity extends AppCompatActivity {

    //임시로
    private int REQUEST_CODE_PERMISSIONS = 1001;
    private final String[] REQUIRED_PERMISSIONS = new String[]{"android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE"};


    private static final SparseIntArray ORIENTATIONS = new SparseIntArray(); //-> SparseIntArray ?

    //카메라 기본 각도 설정 (방향 확인을 위해 장치가 어느 방향으로 회전 되어 있는가를 확인하는 상수 값.)
    //기본 ratation이 세로로 눕혀있음.
    static {
        ORIENTATIONS.append(Surface.ROTATION_0, 90);     //정방향
        ORIENTATIONS.append(Surface.ROTATION_90, 0);     //아래로 반시계 방향 각도.
        ORIENTATIONS.append(Surface.ROTATION_180, 270);
        ORIENTATIONS.append(Surface.ROTATION_270, 180);
    }

    //camera / video 등 Open GL 사용하는 Rendering으로 GPU을 사용하기 때문에 display 하는데 속도가 빠릅니다
    //주로 무거운 또는 화면이 큰 영상을 빠르게 처리할 때 사용하는 view
    private TextureView textureView;
    private Button button;

    //camera2 변수 공간
    private String cameraId;
    private CameraDevice cameraDevice;
    private CameraCaptureSession cameraCaptureSession;
    private CaptureRequest captureRequest;
    private CaptureRequest.Builder captureRequestBuilder;

    //이미지 저장 변수 공간
    private Size imageDimensions;
    private ImageReader imageReader;
    private File file;
    private Handler mBackgroundHandler;
    private HandlerThread mBackgroundThread;

    // 액티비티 생명주기
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textureView = (TextureView) findViewById(R.id.textureView);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 이미지 캡쳐 로직 구현하면 됨.
            }
        });

    }

    //BackGround로 작업을 돌리기 위해 Thread를 start함.
    @Override
    protected void onResume() {
        super.onResume();

        startBackgroundThread();    // -> 비동기적 처리 담당(여러개의 일을 동시에 담당.)

        if (textureView.isAvailable()) {
            try {
                openCamera();
            } catch (CameraAccessException e) {
                e.printStackTrace();
            }
        } else {
            textureView.setSurfaceTextureListener(textureListener);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        try {
            stopBackgroundThread();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    private void startBackgroundThread() {
        mBackgroundThread = new HandlerThread("Camera Background");
        mBackgroundThread.start();
        mBackgroundHandler = new Handler(mBackgroundThread.getLooper());
    }

    private void startCamera() {
        textureView.setSurfaceTextureListener(textureListener);
    }


    private void openCamera() throws CameraAccessException {
        //이외에 setUpCameraOutputs, configureTransform를 통한 카메라 설정 가능.

        //카메라를 다루는 매니저 생성.
        CameraManager manager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);   //-> getSystemService을 통해 camera2에 사용될 매니저 객체 반환.

        //매니저 객체를 통해 카메라 Id List를 얻어오면, 카메라를 얻어올 수 있음.
        //Id 배열로는 0번 후면 카메라, 1번 전면 카메라, 2번 기타 카메
        cameraId = manager.getCameraIdList()[0];

        //얻어온 ID로 카메라 정보를 가지는 CameraCharacteristics 객체를 반환받음.
        CameraCharacteristics characteristics = manager.getCameraCharacteristics(cameraId);

        //카메라의 각종 지원 정보가 포함되어 있는 StreamConfigurationMap 객체를 얻어옴.
        StreamConfigurationMap map = characteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);

        //StreamConfigurationMap의 기능 중 이미지 사이즈 얻어오는 메소드
        imageDimensions = map.getOutputSizes(SurfaceTexture.class)[0];  //-> 0은 포멧에 사용되는 인자값

        //카메라 열때 다시한번 권한 확인 및 열렸을 때 CallBack
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
            manager.openCamera(cameraId, stateCallback, null);
            //콜백은 해당 id의 카메라를 조작할 수 있는 CameraDevice를 반환.
            //종료하는 상황에서 이 객체를 반환하도록 함.
        } else {
            ActivityCompat.requestPermissions(this, REQUIRED_PERMISSIONS, REQUEST_CODE_PERMISSIONS);
        }

    }

    private void createCameraPreview() throws CameraAccessException {
        SurfaceTexture texture = textureView.getSurfaceTexture();
        texture.setDefaultBufferSize(imageDimensions.getWidth(), imageDimensions.getHeight());
        Surface surface = new Surface(texture);

        captureRequestBuilder = cameraDevice.createCaptureRequest(CameraDevice.TEMPLATE_PREVIEW);
        captureRequestBuilder.addTarget(surface);

        cameraDevice.createCaptureSession(Arrays.asList(surface), new CameraCaptureSession.StateCallback() {
            @Override
            public void onConfigured(@NonNull CameraCaptureSession session) {
                if (cameraDevice == null) {
                    return;
                }

                cameraCaptureSession = session;
                try {
                    updatePreview();
                } catch (CameraAccessException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onConfigureFailed(@NonNull CameraCaptureSession session) {
                Toast.makeText(getApplicationContext(), "Configuration Changed", Toast.LENGTH_LONG).show();
            }
        }, null);
    }

    private void updatePreview() throws CameraAccessException {
        if (cameraDevice == null) {
            return;
        }

        captureRequestBuilder.set(CaptureRequest.CONTROL_MODE, CameraMetadata.CONTROL_MODE_AUTO);
        cameraCaptureSession.setRepeatingRequest(captureRequestBuilder.build(), null, mBackgroundHandler);

    }

    protected void stopBackgroundThread() throws InterruptedException {
        mBackgroundThread.quitSafely();
        mBackgroundThread.join();
        mBackgroundThread = null;
        mBackgroundHandler = null;
    }

    // 리스너 콜백 함수
    private TextureView.SurfaceTextureListener textureListener = new TextureView.SurfaceTextureListener() {
        @Override
        public void onSurfaceTextureAvailable(@NonNull SurfaceTexture surface, int width, int height) {
            try {
                openCamera();
            } catch (CameraAccessException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onSurfaceTextureSizeChanged(@NonNull SurfaceTexture surface, int width, int height) {

        }

        @Override
        public boolean onSurfaceTextureDestroyed(@NonNull SurfaceTexture surface) {
            return false;
        }

        @Override
        public void onSurfaceTextureUpdated(@NonNull SurfaceTexture surface) {

        }
    };


    //
    private final CameraDevice.StateCallback stateCallback = new CameraDevice.StateCallback() {
        @Override
        public void onOpened(@NonNull CameraDevice camera) {
            cameraDevice = camera;
            try {
                createCameraPreview();  //-> 텍스쳐 뷰에 화면 표현.
            } catch (CameraAccessException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onDisconnected(@NonNull CameraDevice camera) {
            cameraDevice.close();
        }

        @Override
        public void onError(@NonNull CameraDevice camera, int error) {
            cameraDevice.close();
            cameraDevice = null;
        }
    };

}

