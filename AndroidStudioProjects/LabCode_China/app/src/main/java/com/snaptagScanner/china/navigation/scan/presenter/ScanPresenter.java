package com.snaptagScanner.china.navigation.scan.presenter;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.Surface;
import android.view.TextureView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import com.snaptagScanner.china.R;
import com.snaptagScanner.china.api.post.Post;
import com.snaptagScanner.china.api.SnaptagAPI;
import com.snaptagScanner.china.navigation.scan.model.CameraData;
import com.snaptagScanner.china.navigation.scan.model.ScanModel;

import java.util.Arrays;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ScanPresenter implements ScanContract.Presenter{

    private static String thisName = "ScanPresenter";
    static String BASEURL = "https://admin.labcode.kr/";

    ScanContract.View view;
    ScanModel model;
    CameraData data;

    //권한 관련
    private int REQUEST_CODE_PERMISSIONS = 1001;
    private final String[] REQUIRED_PERMISSIONS = new String[]{"android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE"};

    //카메라 관련 변수
    private static final SparseIntArray ORIENTATIONS = new SparseIntArray();
    static {
        ORIENTATIONS.append(Surface.ROTATION_0, 90);     //정방향
        ORIENTATIONS.append(Surface.ROTATION_90, 0);     //아래로 반시계 방향 각도.
        ORIENTATIONS.append(Surface.ROTATION_180, 270);
        ORIENTATIONS.append(Surface.ROTATION_270, 180);
    }

    private TextureView textureView;
    private FragmentActivity activity;

    private String cameraId;
    private CameraDevice cameraDevice;
    private CameraManager manager;
    private CaptureRequest.Builder captureRequestBuilder;
    private CameraCaptureSession cameraCaptureSession;

    private Handler backgroundHandler;
    private HandlerThread backgroundThread;



    public ScanPresenter(ScanContract.View view, FragmentActivity activity, TextureView textureView){
        this.view = view;
        this.model = new ScanModel(this,activity);
        this.activity = activity;
        this.textureView = textureView;
    }

    @Override
    public void controlSetting(int getId) throws CameraAccessException {
        Log.d(thisName,"controlSetting 실행");
        switch (getId){
            case R.id.flash:
                data.setFlashOnOff((data.isFlashOnOff() == true) ? false : true);
                 view.updatePreview(data); break;
            case R.id.zoom_1_0:
                data.setZoomRate(1.0f);
                view.updatePreview(data); break;
            case R.id.zoom_1_5:
                data.setZoomRate(1.5f);
                view.updatePreview(data); break;
            case R.id.zoom_2_0:
                data.setZoomRate(2.0f);
                view.updatePreview(data); break;
        }
    }

    @Override
    public void testAPI() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        SnaptagAPI retrofitAPI = retrofit.create(SnaptagAPI.class);

        HashMap<String, Object> input = new HashMap<>();
        input.put("versionKey",2);
        input.put("countryKey",0);
        input.put("industryKey",0);
        input.put("teamKey",0);
        input.put("mainCategoryKey",0);
        input.put("subCategoryKey",0);
        input.put("projectKey",0);
        input.put("productKey",0);
        input.put("isVariable",false);
        input.put("isAdminOnly",false);
        input.put("isDigital",false);
        input.put("deviceId", model.getUuid());
        input.put("deviceInfo","");

        Log.d("getUUID : ",model.getUuid());

        retrofitAPI.postData(input).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                Log.d("onResponse 실행","성공");
                if (response.isSuccessful()){
                    Post data = response.body();
                    Log.d("response.body() : ", String.valueOf(response.body()));
                    Log.d("message : ", data.getMessage());

//                    Log.d("getTitle",data.getData().getTitle());
//                    Log.d("getDescription",data.getData().getDescription());
//                    Log.d("getSourceImage",data.getData().getSourceImage());
//                    Log.d("getUrlCustom",data.getData().getUrlCustom());



                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                t.printStackTrace();
                t.getCause();
                Log.d("onFailure","onFailure 실행, 실패");
            }
        });
    }


    @Override
    public void startBackgroundThread() {
        backgroundThread = new HandlerThread("Camera Background");
        backgroundThread.start();
        backgroundHandler = new Handler(backgroundThread.getLooper());
    }

    @Override
    public void stopBackgroundThread() throws InterruptedException {
        backgroundThread.quitSafely();
        backgroundThread.join();
        backgroundThread = null;
        backgroundHandler = null;
    }   //Add 'InterruptedException' to 'Presenter.stopBackgroundThread' throws list

    @Override
    public void openCamera() throws CameraAccessException {
        manager = (CameraManager) activity.getSystemService(Context.CAMERA_SERVICE);

        cameraId = manager.getCameraIdList()[0];
        Log.d("cameraId? : ",cameraId);
        CameraCharacteristics characteristics = manager.getCameraCharacteristics(cameraId);
        StreamConfigurationMap map = characteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);

        if(ActivityCompat.checkSelfPermission(activity.getApplicationContext(), Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
            manager.openCamera(cameraId, stateCallback, null);
        } else {
            ActivityCompat.requestPermissions(activity, REQUIRED_PERMISSIONS, REQUEST_CODE_PERMISSIONS);
        }
    }   //Add 'CameraAccessException' to 'Presenter.openCamera' throws list

    @Override
    public void createCameraPreview() throws CameraAccessException {
        SurfaceTexture texture = textureView.getSurfaceTexture();
        texture.setDefaultBufferSize(1280, 720);

        Surface surface = new Surface(texture);

        captureRequestBuilder = cameraDevice.createCaptureRequest(CameraDevice.TEMPLATE_STILL_CAPTURE);
        captureRequestBuilder.addTarget(surface);

        cameraDevice.createCaptureSession(Arrays.asList(surface), new CameraCaptureSession.StateCallback() {
            @Override
            public void onConfigured(@NonNull CameraCaptureSession session) {
                if (cameraDevice == null){
                    return;
                }
                cameraCaptureSession = session;

                data = CameraData.getInstance();
                data.setDevice(cameraDevice);
                data.setBuilder(captureRequestBuilder);
                data.setSession(cameraCaptureSession);
                data.setHandler(backgroundHandler);

                try {
                    view.updatePreview(data);
                } catch (CameraAccessException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onConfigureFailed(@NonNull CameraCaptureSession cameraCaptureSession) {
                Toast.makeText(activity.getApplicationContext(), "카메라 장치 구성에 실패하였습니다.", Toast.LENGTH_LONG).show();
            }
        }, null);
    }   //Add 'CameraAccessException' to 'Presenter.createCameraPreview' throws list


    @Override
    public void takePicture() {

    }

    private final CameraDevice.StateCallback stateCallback = new CameraDevice.StateCallback() {
        @Override
        public void onOpened(@NonNull CameraDevice camera) {
            cameraDevice = camera;
            try {
                createCameraPreview();
            } catch (CameraAccessException e) {
                e.printStackTrace();
            }
        }


        @Override
        public void onDisconnected(@NonNull CameraDevice cameraDevice) {

        }

        @Override
        public void onError(@NonNull CameraDevice cameraDevice, int i) {

        }
    };




}
