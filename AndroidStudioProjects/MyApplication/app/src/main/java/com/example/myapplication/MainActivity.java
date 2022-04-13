package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.ImageFormat;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CameraMetadata;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.Image;
import android.media.ImageReader;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import android.util.Size;
import android.util.SparseIntArray;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private static String activityName = "MainActivity";

    //권한 관련 변수
    private int REQUEST_CODE_PERMISSIONS = 1001;
    private final String[] REQUIRED_PERMISSIONS = new String[]{"android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE"};

    private static final SparseIntArray ORIENTATIONS = new SparseIntArray(); //-> 굳이 SparseIntArray?

    //카메라 기본 각도 설정 (방향 확인을 위해 장치가 어느 방향으로 회전 되어 있는가를 확인하는 상수 값.)
    //기본 ratation이 세로로 눕혀있음.
    static {
        ORIENTATIONS.append(Surface.ROTATION_0, 90);     //정방향
        ORIENTATIONS.append(Surface.ROTATION_90, 0);     //아래로 반시계 방향 각도.
        ORIENTATIONS.append(Surface.ROTATION_180, 270);
        ORIENTATIONS.append(Surface.ROTATION_270, 180);
    }

    //camera / video 등 Open GL 사용하는 Rendering으로 GPU을 사용하기 때문에 display 하는데 속도가 빠르다고 함.
    //주로 무거운 또는 화면이 큰 영상을 빠르게 처리할 때 사용하는 view
    private TextureView textureView;
    private Button button;

    //camera2 변수 공간
    private String cameraId;
    private CameraDevice cameraDevice;
    private CameraCaptureSession cameraCaptureSession;
    //private CaptureRequest captureRequest;
    private CaptureRequest.Builder captureRequestBuilder;

    //이미지 저장 변수 공간
    private Size imageDimensions;
    private ImageReader imageReader;
    public File file;

    //Handler관련 변수
    private Handler mBackgroundHandler;
    private HandlerThread mBackgroundThread;

    // 액티비티 생명주기
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(activityName,"onCreate 실행");

        textureView = (TextureView) findViewById(R.id.textureView);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(activityName,"onCreate 내부 캡쳐 버튼 클릭");
                try {
                    takePicture();
                }catch(CameraAccessException e){
                    e.printStackTrace();
                }
            }
        });

    }

    //BackGround로 작업을 돌리기 위해 Thread를 start함.
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(activityName,"onResume 실행");

        //카메라 관련 작업이 UI를 그리는 메인 쓰레드를 방해하지 않기 위해 새로운 Thread와 핸들러 생성.
        startBackgroundThread();

        if (textureView.isAvailable()) {    //잠시 비활성 된 경우 등(activity처음 시작이 아닌 경우)
            try {
                Log.d(activityName,"onResume 내부 openCamera 실행");
                openCamera();
            } catch (CameraAccessException e) {
                e.printStackTrace();
            }
        } else {    //activity 처음 시작 경우 textureView 초기화
            Log.d(activityName,"onResume 내부 activity 처음 시작으로 인한 textureView 초기화");
            textureView.setSurfaceTextureListener(textureListener);
        }
    }

    //카메라 장치는 싱글톤 인스턴스이기에, 사용후 시스템에 반환.
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(activityName,"onPause 실행");
        try {
            stopBackgroundThread();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //
    private void startBackgroundThread() {
        Log.d(activityName,"onResume 내부 startBackgroundThread 실행");
        mBackgroundThread = new HandlerThread("Camera Background");
        mBackgroundThread.start();
        mBackgroundHandler = new Handler(mBackgroundThread.getLooper());

        /*
        HandlerThread 객체를 생성하고 start를 하면 Looper를 생성함.
        HanderThread에서 Looper를 가져와 Handler를 실행.

         */
    }

//    //이미지 캡쳐 메소드
//    private void startCamera() {
//        textureView.setSurfaceTextureListener(textureListener);
//
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                try {
//                    takePicture();
//                }catch(CameraAccessException e){
//                    e.printStackTrace();
//                }
//            }
//        });
//    }

    private void takePicture() throws CameraAccessException {
        Log.d(activityName,"takePicture 메소드 실행");
        if (cameraDevice == null){ return; }

        CameraManager manager = (CameraManager)getSystemService(Context.CAMERA_SERVICE);

        CameraCharacteristics characteristics = manager.getCameraCharacteristics(cameraDevice.getId());
        Size[] jpegSizes = null;

        jpegSizes = characteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP).getOutputSizes(ImageFormat.JPEG);

        int width = 640;
        int height = 480;

        if(jpegSizes != null && jpegSizes.length>0) {
            width = jpegSizes[0].getWidth();
            height = jpegSizes[0].getHeight();
        }

        imageReader = ImageReader.newInstance(width, height, ImageFormat.JPEG, 1);
        List<Surface> outputSurfaces = new ArrayList<>(2);
        outputSurfaces.add(imageReader.getSurface());

        outputSurfaces.add(new Surface(textureView.getSurfaceTexture()));

        final CaptureRequest.Builder captureBuilder = cameraDevice.createCaptureRequest(CameraDevice.TEMPLATE_STILL_CAPTURE);
        captureBuilder.addTarget(imageReader.getSurface());
        captureBuilder.set(CaptureRequest.CONTROL_MODE, CameraMetadata.CONTROL_MODE_AUTO);

        int rotation = getWindowManager().getDefaultDisplay().getRotation();
        captureBuilder.set(CaptureRequest.JPEG_ORIENTATION, ORIENTATIONS.get(rotation));

        Long tsLong = System.currentTimeMillis()/1000;
        String ts = tsLong.toString();
//
//        //Environment.getExternalStorageDirectory() 대체한 getFilesDir
//        file = new File(getFilesDir () + "/"+ts+".jpg");
//        Log.d("파일 경로 : ",getFilesDir () + "/"+ts+".jpg");
//        //  -> data/user/0/com.example.myapplication/files/...jpg

        file = new File(Environment.getExternalStorageDirectory()+"/DCIM/Camera", ts+".jpg");

        ImageReader.OnImageAvailableListener rederListener = new ImageReader.OnImageAvailableListener() {
            @Override
            public void onImageAvailable(ImageReader imageReader) {
                Log.d(activityName,"onImageAvailable 내부 이미지 가공");
                Image image = null;

                image = imageReader.acquireLatestImage();
                ByteBuffer buffer = image.getPlanes()[0].getBuffer();
                byte[] bytes = new byte[buffer.capacity()];
                buffer.get(bytes);
                try {
                    save(bytes);
                }catch (IOException e){
                    e.printStackTrace();
                }finally {
                    if (image != null){
                        image.close();
                        imageReader.close();
                    }
                }
            }
        };

        imageReader.setOnImageAvailableListener(rederListener, mBackgroundHandler);

        final CameraCaptureSession.CaptureCallback captureListener = new CameraCaptureSession.CaptureCallback() {
            @Override
            public void onCaptureCompleted(@NonNull CameraCaptureSession session, @NonNull CaptureRequest request, @NonNull TotalCaptureResult result) {
                super.onCaptureCompleted(session, request, result);
                Log.d(activityName,"onCaptureCompleted 실행");
                try {
                    Log.d(activityName,"onCaptureCompleted 내부 onCaptureCompleted 실행");
                    createCameraPreview();
                } catch (CameraAccessException e) {
                    e.printStackTrace();
                }
            }
        };

        cameraDevice.createCaptureSession(outputSurfaces, new CameraCaptureSession.StateCallback() {
            @Override
            public void onConfigured(@NonNull CameraCaptureSession cameraCaptureSession) {
                try {
                    cameraCaptureSession.capture(captureBuilder.build(), captureListener, mBackgroundHandler);
                } catch (CameraAccessException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onConfigureFailed(@NonNull CameraCaptureSession cameraCaptureSession) {

            }
        }, mBackgroundHandler);

    }


    private void openCamera() throws CameraAccessException {

        CameraManager manager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);

        cameraId = manager.getCameraIdList()[0];
        CameraCharacteristics characteristics = manager.getCameraCharacteristics(cameraId);
        StreamConfigurationMap map = characteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);

        //StreamConfigurationMap의 기능 중 이미지 사이즈 얻어오는 메소드
        imageDimensions = map.getOutputSizes(SurfaceTexture.class)[0];  //-> 0은 포멧에 사용되는 인자값

        /*
        CameraManager : 카메라 장치 감지 및 서비스 관리
        CameraId : 카메라 종류 정보 배열 (0 : 후면 / 1 : 전면 / 2 : 기타)
        StreamConfigurationMap : 캡쳐 세션을 만들기 위한 Surface를 설정하는 클래스
        CameraCharacteristics : 카메라의 각종 기능이 포함되어 있는 객체 (Id로부터 얻어옴.)
         */

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
            manager.openCamera(cameraId, stateCallback, null);
            /*
            CameraManager.openCamera :  지정된 Id로 카메라 연결.
                                        카메라가 성공적으로 열리면 onOpened 호출
            */
        } else {
            ActivityCompat.requestPermissions(this, REQUIRED_PERMISSIONS, REQUEST_CODE_PERMISSIONS);
        }

    }

    private void createCameraPreview() throws CameraAccessException {
        Log.d(activityName,"createCameraPreview 실행");
        SurfaceTexture texture = textureView.getSurfaceTexture();
        texture.setDefaultBufferSize(imageDimensions.getWidth(), imageDimensions.getHeight());
        //Surface 객체 만들기
        Surface surface = new Surface(texture);

        captureRequestBuilder = cameraDevice.createCaptureRequest(CameraDevice.TEMPLATE_PREVIEW);
        captureRequestBuilder.addTarget(surface);

        /*
        textureView.getSurfaceTexture() : 이를 통해 camera2의 출력물로 사용될 수 있음.
        texture.setDefaultBufferSize() : 이미지 사이즈 설정
        CaptureRequest.Builder(captureRequestBuilder) : 캡쳐 관련 빌더
        captureRequestBuilder.addTarget() : 얻어온 surface를 추가.
         */

        cameraDevice.createCaptureSession(Arrays.asList(surface), new CameraCaptureSession.StateCallback() {
            //카메라 실행 준비가 되면 실행.
            @Override
            public void onConfigured(@NonNull CameraCaptureSession session) {
                Log.d(activityName,"onConfigured 실행");
                if (cameraDevice == null) {
                    return;
                }
                //생성된 세션을 멤버변수로 올려줌. 이 세션으로 카메라를 다루는 것.
                cameraCaptureSession = session;
                try {
                    updatePreview();
                } catch (CameraAccessException e) {
                    e.printStackTrace();
                }
            }

            /*
            CameraDevice.createCaptureSession : 캡쳐할 surface와 callback, handler를 제공하면, 카메라 세션을 생성함.
            비동기로 작동되는 카메라 Thread에서 이미지를 받아오는데, 그러한 흐름에서 사용되는 Session.
            --> 여기부터 다시 분석. 주석하면서 분석 다시 하고 다시 흐름 정리해보기.
             */

            @Override
            public void onConfigureFailed(@NonNull CameraCaptureSession session) {
                Toast.makeText(getApplicationContext(), "Configuration Changed", Toast.LENGTH_LONG).show();
            }
        }, null);
    }

    //여기서 카메라 화면을 surface에 띄우고, 세션이 생성되는 시점에 생성되도록 함.
    private void updatePreview() throws CameraAccessException {
        Log.d(activityName,"updatePreview 실행");
        if (cameraDevice == null) {
            return;
        }

        //request세팅
        captureRequestBuilder.set(CaptureRequest.CONTROL_MODE, CameraMetadata.CONTROL_MODE_AUTO);
        //반복적으로 이미지 버퍼를 얻기 위해 호출. -> 이로써 TextureView에 카메라 영상이 나옴.
        cameraCaptureSession.setRepeatingRequest(captureRequestBuilder.build(), null, mBackgroundHandler);

    }

    protected void stopBackgroundThread() throws InterruptedException {
        Log.d(activityName,"onPause 내부 stopBackgroundThread 실행");
        mBackgroundThread.quitSafely();
        mBackgroundThread.join();
        mBackgroundThread = null;
        mBackgroundHandler = null;
    }

    // TextureView 사용할 준비 완료 전달
    private TextureView.SurfaceTextureListener textureListener = new TextureView.SurfaceTextureListener() {
        @Override
        public void onSurfaceTextureAvailable(@NonNull SurfaceTexture surface, int width, int height) {
            Log.d(activityName, "onSurfaceTextureAvailable 실행");
            try {
                Log.d(activityName,"onSurfaceTextureAvailable 내부 openCamera 실행");
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


    private final CameraDevice.StateCallback stateCallback = new CameraDevice.StateCallback() {
        @Override
        public void onOpened(@NonNull CameraDevice camera) {
            Log.d(activityName,"onOpened 실행");
            cameraDevice = camera;
            try {
                Log.d(activityName,"onOpened 내부 createCameraPreview 실행");
                createCameraPreview();  //-> 텍스쳐 뷰에 화면 표현.
            } catch (CameraAccessException e) {
                e.printStackTrace();
            }
            /*
            카메라 장치를 열려면 CameraDevice.StateCallback 인스턴스를 제공헤야함.
            카메라 장치 시작, 완료, 연결해제 등의 알림 콜백.
             */
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


    //위로 이미지 preview관련
    //=============================================================================================================================================
    //아래로 이미지 저장 관련


    private void save(byte[] bytes) throws IOException{
        Log.d(activityName,"save 실행");
        OutputStream outputStream = null;
        outputStream = new FileOutputStream(file);
        outputStream.write(bytes);
        outputStream.close();
    }





}










