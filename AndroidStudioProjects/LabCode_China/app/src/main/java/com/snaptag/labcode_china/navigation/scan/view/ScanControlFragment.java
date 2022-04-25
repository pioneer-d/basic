package com.snaptag.labcode_china.navigation.scan.view;

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
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import android.util.Size;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.snaptag.labcode_china.R;

import java.util.Arrays;


public class ScanControlFragment extends Fragment {

    private static String thisName = "ScanControlFragment";

    private static ScanControlFragment instance;
    private ScanControlFragment() {
    }

    private static final SparseIntArray ORIENTATIONS = new SparseIntArray();
    static {
        ORIENTATIONS.append(Surface.ROTATION_0, 90);     //정방향
        ORIENTATIONS.append(Surface.ROTATION_90, 0);     //아래로 반시계 방향 각도.
        ORIENTATIONS.append(Surface.ROTATION_180, 270);
        ORIENTATIONS.append(Surface.ROTATION_270, 180);
    }

    private int REQUEST_CODE_PERMISSIONS = 1001;
    private final String[] REQUIRED_PERMISSIONS = new String[]{"android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE"};

    private View view;

    private Size imageDimensions;
    private TextureView textureView;


    private String cameraId;
    private CameraDevice cameraDevice;
    private CameraManager manager;
    private CaptureRequest.Builder captureRequestBuilder;
    private CameraCaptureSession cameraCaptureSession;


    private Handler backgroundHandler;
    private HandlerThread backgroundThread;

    public static ScanControlFragment newInstance() {
        if(instance == null){
            instance = new ScanControlFragment();
        }
        Bundle args = new Bundle();

        instance.setArguments(args);
        return instance;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_control_scan, container, false);
        textureView = view.findViewById(R.id.textureView);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        Log.d(thisName,"onResume()");
        startBackgroundThread();

        if (textureView.isAvailable()){
            try {
                Log.d(thisName,"onResume() -> openCamera()");
                openCamera();
            } catch (CameraAccessException e){
                e.printStackTrace();
            }
        } else {
            Log.d(thisName,"onResume() -> setSurfaceTextureListener()");
            textureView.setSurfaceTextureListener(textureListener);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(thisName,"onPause()");
        try {
            stopBackgroundThread();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void startBackgroundThread(){
        backgroundThread = new HandlerThread("Camera Background");
        backgroundThread.start();
        backgroundHandler = new Handler(backgroundThread.getLooper());
    }


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
        public void onSurfaceTextureSizeChanged(@NonNull SurfaceTexture surfaceTexture, int i, int i1) {

        }

        @Override
        public boolean onSurfaceTextureDestroyed(@NonNull SurfaceTexture surfaceTexture) {
            return false;
        }

        @Override
        public void onSurfaceTextureUpdated(@NonNull SurfaceTexture surfaceTexture) {

        }
    };


        private void openCamera() throws CameraAccessException{
            Log.d(thisName,"openCamera()");
            manager = (CameraManager) getActivity().getSystemService(Context.CAMERA_SERVICE);

            cameraId = manager.getCameraIdList()[0];
            Log.d("cameraId? : ",cameraId);
            CameraCharacteristics characteristics = manager.getCameraCharacteristics(cameraId);
            StreamConfigurationMap map = characteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);

            //이부분으로 해상도 변경
            //imageDimensions = map.getOutputSizes(SurfaceTexture.class)[0];

            if(ActivityCompat.checkSelfPermission(getActivity().getApplicationContext(), Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                manager.openCamera(cameraId, stateCallback, null);
            } else {
                ActivityCompat.requestPermissions(getActivity(), REQUIRED_PERMISSIONS, REQUEST_CODE_PERMISSIONS);
            }

        }

        private final CameraDevice.StateCallback stateCallback = new CameraDevice.StateCallback() {
            @Override
            public void onOpened(@NonNull CameraDevice camera) {
                Log.d(thisName,"onOpened()");
                cameraDevice = camera;
                try {
                    Log.d(thisName,"onOpened() -> createCameraPreview()");
                    createCameraPreview();  //-> 텍스쳐 뷰에 화면 표현.
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

    private void createCameraPreview() throws CameraAccessException{
        Log.d(thisName,"createCameraPreview");
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
                try {
                    Log.d(thisName,"createCameraPreview() -> updatePreview()");
                    updatePreview();
                } catch (CameraAccessException e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onConfigureFailed(@NonNull CameraCaptureSession cameraCaptureSession) {
                Toast.makeText(getActivity().getApplicationContext(), "카메라 장치 구성에 실패하였습니다.", Toast.LENGTH_LONG).show();
            }
        }, null);


    }

    private void updatePreview() throws CameraAccessException{
        Log.d(thisName,"updatePreview");
        if (cameraDevice == null){
            return;
        }
        captureRequestBuilder.set(CaptureRequest.CONTROL_MODE, CameraMetadata.CONTROL_MODE_AUTO);
        cameraCaptureSession.setRepeatingRequest(captureRequestBuilder.build(), null, backgroundHandler);
    }

    protected void stopBackgroundThread() throws InterruptedException {
        backgroundThread.quitSafely();
        backgroundThread.join();
        backgroundThread = null;
        backgroundHandler = null;
    }




    }