package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Camera;
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
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.provider.MediaStore;
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
    static {    //why
        ORIENTATIONS.append(Surface.ROTATION_0, 90);     //정방향
        ORIENTATIONS.append(Surface.ROTATION_90, 0);     //아래로 반시계 방향 각도.
        ORIENTATIONS.append(Surface.ROTATION_180, 270);
        ORIENTATIONS.append(Surface.ROTATION_270, 180);
    }

    //camera / video 등 Open GL 사용하는 Rendering으로 GPU을 사용하기 때문에 display 하는데 속도가 빠르다고 함.
    //주로 무거운 또는 화면이 큰 영상을 빠르게 처리할 때 사용하는 view
    private TextureView textureView;
    private Button button;
    private Button flash;

    private Button zoom1;
    private Button zoom2;
    private Button zoom3;

    private Button effect;
    private Button lens_filter;


    //camera2 변수 공간
    private String cameraId;
    private CameraDevice cameraDevice;
    private CameraCaptureSession cameraCaptureSession;
    private CameraManager manager;
    //private CaptureRequest captureRequest;
    private CaptureRequest.Builder captureRequestBuilder;

    //이미지 저장 변수 공간
    private Size imageDimensions;
    private ImageReader imageReader;
    public File file;
    private String ts = "";

    //Handler관련 변수
    private Handler mBackgroundHandler;
    private HandlerThread mBackgroundThread;

    //Flash, Zoom 관련 변수
    private Boolean flashOnOff = false;
    private Float zoomNum = 1.0f;

    //test관련 변수
    private int effectInt = 0;
    private float lens_filterF = 0;

    // 액티비티 생명주기
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(activityName,"onCreate 실행");

        textureView = (TextureView) findViewById(R.id.textureView);
        button = (Button) findViewById(R.id.button);

        flash = (Button) findViewById(R.id.flash);

        zoom1 = (Button) findViewById(R.id.zoom1);
        zoom2 = (Button) findViewById(R.id.zoom2);
        zoom3 = (Button) findViewById(R.id.zoom3);

        effect = (Button) findViewById(R.id.effect);
        lens_filter = (Button) findViewById(R.id.lens_filter);


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


        flash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(activityName,"Flash On or Off");
                flashOnOff = (flashOnOff == true) ? false : true;
                try {
                    updatePreview();
                } catch (CameraAccessException e) {
                    e.printStackTrace();
                }

            }
        });


        zoom1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(activityName,"Zoom Default");
                zoomNum = 1.0f;
                try {
                    updatePreview();
                } catch (CameraAccessException e) {
                    e.printStackTrace();
                }
            }
        });

        //Zoom 변경 Listener
        zoom2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(activityName,"Zoom rate 1.5");
                zoomNum = 1.5f;
                try {
                    updatePreview();
                } catch (CameraAccessException e) {
                    e.printStackTrace();
                }
            }
        });

        zoom3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(activityName,"Zoom rate 2.0");
                zoomNum = 2f;
                try {
                    updatePreview();
                } catch (CameraAccessException e) {
                    e.printStackTrace();
                }
            }
        });

        //effect 클릭
        effect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(activityName,"effect click");
                effectInt++;
                if(effectInt == 9) {effectInt = 0;}
                try {
                    updatePreview();
                } catch (CameraAccessException e) {
                    e.printStackTrace();
                }
            }
        });

        //aperture 클릭
        lens_filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(activityName,"aperture click");
                lens_filterF++;
                if(lens_filterF == 11) {lens_filterF = 0;}
                try {
                    updatePreview();
                } catch (CameraAccessException e) {
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
        startBackgroundThread();    //why

        if (textureView.isAvailable()) {    //잠시 비활성 된 경우 등(activity처음 시작이 아닌 경우)
            try {
                Log.d(activityName,"onResume 내부 openCamera 실행");
                openCamera();   //why
            } catch (CameraAccessException e) {
                e.printStackTrace();
            }
        } else {    //activity 처음 시작 경우 textureView 초기화
            Log.d(activityName,"onResume 내부 activity 처음 시작으로 인한 textureView 초기화");
            textureView.setSurfaceTextureListener(textureListener);

            /*
            TextureView.setSurfaceTextureListener -> TextureView에서 Surface를 가져옴.
            TextureView.isAvailable -> TextureView와 연결된 SurfaceTexture가 렌더링 가능하면 true 반환
             */
        }
    }

    //카메라 장치는 싱글톤 인스턴스이기에, 사용후 시스템에 반환.
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(activityName,"onPause 실행");
        try {
            stopBackgroundThread(); //why
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


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

    private void takePicture() throws CameraAccessException {
        Log.d(activityName,"takePicture 메소드 실행");
        if (cameraDevice == null){ return; }

        //manager = (CameraManager)getSystemService(Context.CAMERA_SERVICE);
        CameraCharacteristics characteristics = manager.getCameraCharacteristics(cameraDevice.getId());
        Size[] jpegSizes = null;

        jpegSizes = characteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP).getOutputSizes(ImageFormat.JPEG);

        int width = 640;
        int height = 480;

        if(jpegSizes != null && jpegSizes.length>0) {
            width = jpegSizes[0].getWidth();
            height = jpegSizes[0].getHeight();
        }

        /*
        CameraCharacteristics.get : 카메라 특성 정보 값을 가져옴.
        CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP : 해당 카메라가 지원, 사용 가능한 스트림 구성(형식, 크기, 조합 등에 대한 프레임 지속시간 , stall 지속시간 등.)
         */

        imageReader = ImageReader.newInstance(width, height, ImageFormat.JPEG, 1);
        List<Surface> outputSurfaces = new ArrayList<>(2);
        outputSurfaces.add(imageReader.getSurface());

        outputSurfaces.add(new Surface(textureView.getSurfaceTexture()));


        captureRequestBuilder = cameraDevice.createCaptureRequest(CameraDevice.TEMPLATE_STILL_CAPTURE);
        captureRequestBuilder.addTarget(imageReader.getSurface());

        //FLASH
        if (flashOnOff == true){
            captureRequestBuilder.set(CaptureRequest.FLASH_MODE, CameraMetadata.CONTROL_MODE_AUTO);
        } else {
            captureRequestBuilder.set(CaptureRequest.CONTROL_MODE, CameraMetadata.CONTROL_MODE_AUTO);
        }

        //CONTROL_ZOOM
        if(zoomNum != 1.0f){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                captureRequestBuilder.set(CaptureRequest.CONTROL_ZOOM_RATIO, zoomNum);
            }
        }

        //CONTROL_EFFECT
        Log.d(activityName,"testInt : "+Integer.toString(effectInt));
        switch (effectInt){
            case 0 : captureRequestBuilder.set(CaptureRequest.CONTROL_EFFECT_MODE, 0);   //OFF
                break;
            case 1 : captureRequestBuilder.set(CaptureRequest.CONTROL_EFFECT_MODE, 1);   //MONO
                break;
            case 2 : captureRequestBuilder.set(CaptureRequest.CONTROL_EFFECT_MODE, 2);   //NEGATIVE
                break;
            case 3 : captureRequestBuilder.set(CaptureRequest.CONTROL_EFFECT_MODE, 3);   //SOLARIZE
                break;
            case 4 : captureRequestBuilder.set(CaptureRequest.CONTROL_EFFECT_MODE, 4);   //SEPIA
                break;
            case 5 : captureRequestBuilder.set(CaptureRequest.CONTROL_EFFECT_MODE, 5);   //POSTERIZE
                break;
            case 6 : captureRequestBuilder.set(CaptureRequest.CONTROL_EFFECT_MODE, 6);   //WHITEBOARD
                break;
            case 7 : captureRequestBuilder.set(CaptureRequest.CONTROL_EFFECT_MODE, 7);   //BLACKBOARD
                break;
            case 8 : captureRequestBuilder.set(CaptureRequest.CONTROL_EFFECT_MODE, 8);   //AQUA
                break;
        }

        Log.d(activityName,"Flash is : "+flashOnOff);
        Log.d(activityName,"Zoom rate is : "+zoomNum);

        int rotation = getWindowManager().getDefaultDisplay().getRotation();
        captureRequestBuilder.set(CaptureRequest.JPEG_ORIENTATION,ORIENTATIONS.get(rotation));
//        captureBuilder.set(CaptureRequest.JPEG_ORIENTATION, ORIENTATIONS.get(rotation));

        /*
        ImageReader : 렌더링된 이미지 데이터에 접근하는 클래스 (Image 객체에 캡슐화 됨.)
        ImageReader.newInstance : 원하는 크기, 형식, 동시에 획득할 수 있는 Image객체 수 설정.
        ImageReader.getSurface : 이미지를 생성하는데 사용될 수 있는 Surface를 얻어옴.

        CaptureRequest.Builder : 캡쳐 요청 빌더 / CameraDevice의 템플릿 중 하나로 초기화함
            -> createCameraPreview에서 초기화 했는데 다시 선언. 요청하는 Template 목적이 다름.
            -> createCameraPreview => CameraDevice.TEMPLATE_PREVIEW : 카메라 미리보기에 적합한 템플릿.
            -> takePicture => CameraDevice.TEMPLATE_STILL_CAPTURE : 정지 이미지 캡처에 적합한 요청 템플릿. 프레임 속도보다                                                                                        이미지의 품질 우선.
        getWindowManager().getDefaultDisplay().getRotation() : 화면의 크기, 방향을 얻어오는 메소드 - Activity를 상속받으면 사용할 수 있음.
         */

        //파일 이름에 고유 속성 부여
        Long tsLong = System.currentTimeMillis()/1000;
        ts = tsLong.toString();

        file = new File(Environment.getExternalStorageDirectory()+"/DCIM/Camera", ts+".jpg");

        ImageReader.OnImageAvailableListener rederListener = new ImageReader.OnImageAvailableListener() {
            @Override
            public void onImageAvailable(ImageReader imageReader) {
                Log.d(activityName,"onImageAvailable 실행");
                Image image = null;

                image = imageReader.acquireLatestImage();   //이 부분이 회사에서 사용되고 있는 메소드!
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

        /*
        ImageReader.OnImageAvailableListener : 새 이미지를 사용할 수 있다는 알림을 위한 CallBack 인터페이스
        ImageReader.acquireLatestImage() : ImageReader의 대기열에서 가장 최신의 이미지를 획득하고, 이전 이미지를 삭제함. (실시간 처리에 적합함.)
        ImageReader.setOnImageAvailableListener() : 새 이미지를 사용할 수 있을때 호출할 Listener 등록.
         */

        final CameraCaptureSession.CaptureCallback captureListener = new CameraCaptureSession.CaptureCallback() {
            @Override
            public void onCaptureCompleted(@NonNull CameraCaptureSession session, @NonNull CaptureRequest request, @NonNull TotalCaptureResult result) {
                super.onCaptureCompleted(session, request, result);
                Log.d(activityName,"onCaptureCompleted 실행");
                try {
                    Log.d(activityName,"onCaptureCompleted 내부 createCameraPreview 실행");
                    createCameraPreview();
                } catch (CameraAccessException e) {
                    e.printStackTrace();
                }
            }
        };

        /*
        CameraCaptureSession.CaptureCallback : 카메라 장치에 제출된 캡쳐 요청의 진행률을 추적하는 CallBack 객체. 캡쳐 시작 및 완료될 때 호출됨.
                                                이때 createCameraPreview를 호출하여 계속 카메라가 띄워지도록 함.
         */

        cameraDevice.createCaptureSession(outputSurfaces, new CameraCaptureSession.StateCallback() {
            @Override
            public void onConfigured(@NonNull CameraCaptureSession cameraCaptureSession) {
                Log.d(activityName,"takePicture 내부 onConfigured 실행");
                try {
                    cameraCaptureSession.capture(captureRequestBuilder.build(), captureListener, mBackgroundHandler);
                } catch (CameraAccessException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onConfigureFailed(@NonNull CameraCaptureSession cameraCaptureSession) {

            }
        }, mBackgroundHandler);

        /*
        createCameraPreview의 createCaptureSession : 반복적 캡쳐를 통한 Preview 제공.
        takePicture의 createCaptureSession : 단일 이미지 캡쳐.
         */

    }



    private void openCamera() throws CameraAccessException {

        //CameraManager manager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        manager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);

        cameraId = manager.getCameraIdList()[0];
        CameraCharacteristics characteristics = manager.getCameraCharacteristics(cameraId);
        StreamConfigurationMap map = characteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);

        imageDimensions = map.getOutputSizes(SurfaceTexture.class)[0];  //-> 0은 포멧에 사용되는 인자값

        /*
        CameraManager : 카메라 장치를 감지, 연결, 특성화 하기 위한 클래스
        getSystemService : 매개변수에 대응되는 안드로이드 시스템을 Manager 객체로 반환.
        getCameraIdList : 연결된 카메라 장치 목록 반환
        CameraId : 카메라 종류 정보 배열 (0 : 후면 / 1 : 전면 / 2 : 기타)

        CameraCharacteristics : 해당 카메라 장치의 속성. CameraManager에 의해 쿼리(?)될 수 있음.
        CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP : 해당 카메 장치가 지원하는 스트림 구성.

        StreamConfigurationMap : 캡쳐 세션을 만들기 위한 Surface를 설정하는 클래스
        StreamConfigurationMap.getOutputSizes : 출력물로 사용될 클래스와 호환되는 크기 목록을 가져옴
         */

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
            manager.openCamera(cameraId, stateCallback, null);
            /*
            CameraManager.openCamera :  지정된 Id로 카메라 연결.
                                        카메라가 성공적으로 열리면 onOpened 호출
                                        카메라 장치를 연결하기 위해 콜백 인스턴스를 꼭 제공해야 함.
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
        textureView.getSurfaceTexture() : 현재 View에 사용되고 있는 SurfaceTexture를 불러옴.
        texture.setDefaultBufferSize() : 이미지 버퍼의 기본 크기 설정

        CameraDevice.createCaptureRequest() : 해당 장치에 대한 템플릿 정의를 하고, 캡쳐 요청을 만듬. / CaptureRequest.Builder를 리턴
        CameraDevice.TEMPLATE_PREVIEW : 카메라 미리보기에 적합한 템플릿.

        CaptureRequest.Builder : 캡쳐 요청 빌더 (..!)
        CaptureRequest.Builder.addTarget() : 캡쳐 대상(surface) 추가
         */

        cameraDevice.createCaptureSession(Arrays.asList(surface), new CameraCaptureSession.StateCallback() {
            //카메라 실행 준비가 되면 실행.
            @Override
            public void onConfigured(@NonNull CameraCaptureSession session) {
                Log.d(activityName,"createCameraPreview 내부 onConfigured 실행");
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

            @Override
            public void onConfigureFailed(@NonNull CameraCaptureSession session) {
                Toast.makeText(getApplicationContext(), "카메라 장치 구성에 실패하였습니다.", Toast.LENGTH_LONG).show();
            }
        }, null);

            /*
            CameraDevice.createCaptureSession : 캡쳐할 surface와 callback, handler를 제공하면, 카메라 세션을 생성함.
                -> (이미지 대상, 카메라 세션 호출 CallBack, 핸들러)
            CameraCaptureSession.StateCallback() : 카메라 장치에 대해 구성된 캡처 세션. 캡쳐하는데 사용됨.
                -> 이때 Session은 만들고 구성하는데 메모리 소요가 많기 때문에, 비동기로 수행됨.

            onConfigured : 카메라 장치의 구성을 마치고, 세션이 캡쳐 요청 처리를 시작할 수 있을때 호출 됨.
                -> 이때 setRepeatingRequest 메소드를 설정하여 미리보기를 제공함.
            onConfigureFailed : 카메라 장치 구성에 실패할 경우 실행.
             */
    }

    //캡쳐 빌드의 필드를 세팅하고, 실제 미리보기를 제공하는 메소드.
    private void updatePreview() throws CameraAccessException {
        Log.d(activityName,"updatePreview 실행");
        if (cameraDevice == null) {
            return;
        }

        //FLASH
        if(flashOnOff == true){
            //captureRequestBuilder.set(CaptureRequest.FLASH_MODE,CaptureRequest.FLASH_MODE_TORCH);
            captureRequestBuilder.set(CaptureRequest.FLASH_MODE,CameraCharacteristics.FLASH_MODE_TORCH);
            // 여기부터 매개변수 확인하고, 기능 확인 해보고, 뭐가 다른건지 CaptureRequest <-> CameraCharacteristic
        } else {
            //captureRequestBuilder.set(CaptureRequest.FLASH_MODE,CaptureRequest.FLASH_MODE_OFF);
            captureRequestBuilder.set(CaptureRequest.FLASH_MODE,CameraCharacteristics.FLASH_MODE_OFF);
        }

        //CONTROL_ZOOM
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) { //레드 벨벳 케이크 - 30
            captureRequestBuilder.set(CaptureRequest.CONTROL_ZOOM_RATIO,zoomNum);
        }

        //CONTROL_EFFECT
        Log.d(activityName,"testInt : "+Integer.toString(effectInt));
        switch (effectInt){
            case 0 : captureRequestBuilder.set(CaptureRequest.CONTROL_EFFECT_MODE, 0);   //OFF
                break;
            case 1 : captureRequestBuilder.set(CaptureRequest.CONTROL_EFFECT_MODE, 1);   //MONO
                break;
            case 2 : captureRequestBuilder.set(CaptureRequest.CONTROL_EFFECT_MODE, 2);   //NEGATIVE
                break;
            case 3 : captureRequestBuilder.set(CaptureRequest.CONTROL_EFFECT_MODE, 3);   //SOLARIZE
                break;
            case 4 : captureRequestBuilder.set(CaptureRequest.CONTROL_EFFECT_MODE, 4);   //SEPIA
                break;
            case 5 : captureRequestBuilder.set(CaptureRequest.CONTROL_EFFECT_MODE, 5);   //POSTERIZE
                break;
            case 6 : captureRequestBuilder.set(CaptureRequest.CONTROL_EFFECT_MODE, 6);   //WHITEBOARD
                break;
            case 7 : captureRequestBuilder.set(CaptureRequest.CONTROL_EFFECT_MODE, 7);   //BLACKBOARD
                break;
            case 8 : captureRequestBuilder.set(CaptureRequest.CONTROL_EFFECT_MODE, 8);   //AQUA
                break;
        }

        //LENS_FILTER_DENSITY   --> 여기부터 이것저것 테스트 하면 됨.
        Log.d(activityName,"apertureF : "+Float.toString(lens_filterF));
        captureRequestBuilder.set(CaptureRequest.LENS_FILTER_DENSITY,lens_filterF);

        //captureRequestBuilder.set(CaptureRequest.CONTROL_MODE, CameraMetadata.CONTROL_MODE_AUTO);
        cameraCaptureSession.setRepeatingRequest(captureRequestBuilder.build(), null, mBackgroundHandler);

        /*
        CaptureRequestBuilder.set : 캡쳐 빌드의 필드 값 세팅(key, value)
            -> 이를 통해 CameraMetadata의 필드 값을 설정하여 카메라 컨트롤을 함.
        CaptureRequest <-> CameraCharacteristic 둘다 CameraMetadata를 갖고있음.

        CameraCaptureSession.setRepeatingRequest : 계속 반복되는 이미지 캡쳐를 요청하는 메소드. 최대 속도로 지속적으로 캡쳐함.
            -> 연속적인 프레임 스트림을 유지 (여기서 BackgroundHandler가 사용됨!)
         */

    }

    protected void stopBackgroundThread() throws InterruptedException {
        Log.d(activityName,"stopBackgroundThread 실행");



        mBackgroundThread.quitSafely();
        mBackgroundThread.join();
        mBackgroundThread = null;
        mBackgroundHandler = null;
    }

    // TextureView 사용할 준비 완료 전달
    private TextureView.SurfaceTextureListener textureListener = new TextureView.SurfaceTextureListener() {
        @Override
        public void onSurfaceTextureAvailable(@NonNull SurfaceTexture surface, int width, int height) {
            //TextureView의 SurfaceTexture가 사용 가능하면 호출되는 메소드.
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
            카메라 장치를 열려면 CameraDevice.StateCallback 인스턴스를 제공헤야함. (manager.openCamera의 매개변수로 작동)
            현재 열린 카메라 장치를 CameraDevice에 입력.
            카메라 장치 시작, 완료, 연결해제 등의 알림 콜백.
            이때부터 CameraDevice/createCaptureSession을 호출하여 캡쳐 세션을 설정할 수 있음.

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
        goPictureImageView();


    }

    //=============================================================================================================================================

    //이미지 파일 경로를 포함한 Intent 이동 method.
    private void goPictureImageView(){
        Log.d(activityName,"ImageViewActivity로 이동.");
        Intent imageViewActivity = new Intent(MainActivity.this, ImageViewActivity.class);
        imageViewActivity.putExtra("fileURI",Environment.getExternalStorageDirectory()+"/DCIM/Camera/"+ts+".jpg");
        startActivity(imageViewActivity);
    }

}










