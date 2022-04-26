package com.snaptag.labcode_china.navigation.scan.presenter;

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
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import com.snaptag.labcode_china.R;
import com.snaptag.labcode_china.navigation.scan.model.CameraData;
import com.snaptag.labcode_china.navigation.scan.model.ScanModel;

import java.util.Arrays;

public class ScanPresenter implements ScanContract.Presenter{

    private static String thisName = "ScanPresenter";

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
        this.model = new ScanModel(this);
        this.activity = activity;
        this.textureView = textureView;
    }

    @Override
    public void controlSetting(int getId) throws CameraAccessException {  //인자값을 받아와.
        Log.d(thisName,"controlSetting 실행");
        switch (getId){
            case R.id.flash: case R.id.flash2:
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
