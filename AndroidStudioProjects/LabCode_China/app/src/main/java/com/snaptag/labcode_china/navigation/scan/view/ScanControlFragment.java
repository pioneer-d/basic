package com.snaptag.labcode_china.navigation.scan.view;


import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraMetadata;
import android.hardware.camera2.CaptureRequest;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.snaptag.labcode_china.R;
import com.snaptag.labcode_china.navigation.scan.model.CameraData;
import com.snaptag.labcode_china.navigation.scan.presenter.ScanContract;
import com.snaptag.labcode_china.navigation.scan.presenter.ScanPresenter;


public class ScanControlFragment extends Fragment implements ScanContract.View, View.OnClickListener {

    private static String thisName = "ScanControlFragment";

    private static ScanControlFragment instance;
    private ScanControlFragment() {
    }

    private ScanContract.Presenter presenter;
    CameraData data;

    private View view;
    private TextureView textureView;
    private ImageButton flashButton;
    private ImageButton flashButton2;
    private ImageButton zoom;

    public static ScanControlFragment newInstance() {
        if(instance == null){
            instance = new ScanControlFragment();
        }
        Bundle args = new Bundle();

        instance.setArguments(args);
        return instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_control_scan, container, false);
        textureView = view.findViewById(R.id.textureView);
        flashButton = view.findViewById(R.id.flash);
        flashButton2 = view.findViewById(R.id.flash2);
        zoom = view.findViewById(R.id.zoom);

        flashButton.setOnClickListener(this);
        flashButton2.setOnClickListener(this);
        zoom.setOnClickListener(this);

        data = CameraData.getInstance();
        presenter = new ScanPresenter(this,getActivity(),textureView);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        Log.d(thisName,"onResume()");
        presenter.startBackgroundThread();

        if (textureView.isAvailable()){
            try {
                Log.d(thisName,"onResume() -> openCamera()");
                presenter.openCamera();
            } catch (CameraAccessException e){
                e.printStackTrace();
            }
        } else {
            Log.d(thisName,"onResume() -> setSurfaceTextureListener()");
            textureView.setSurfaceTextureListener(textureListener);
        }
    }

    @Override
    public void onClick(View view) {
        int getId = view.getId();
        switch (getId){
            case R.id.flash : case R.id.flash2 :
                try {
                    Log.d(thisName,"onClick 실행");
                    presenter.controlSetting(getId); }
                catch (CameraAccessException e) { e.printStackTrace(); } break;
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(thisName,"onPause()");
        try {
            presenter.stopBackgroundThread();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }




    private TextureView.SurfaceTextureListener textureListener = new TextureView.SurfaceTextureListener() {
        @Override
        public void onSurfaceTextureAvailable(@NonNull SurfaceTexture surface, int width, int height) {
            try {
                presenter.openCamera();
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


    public void updatePreview(CameraData data) throws CameraAccessException{

        if (data.getDevice() == null){
            return;
        }

        Log.d(thisName, "flashOnOff : "+Boolean.toString(data.isFlashOnOff()));
        Log.d(thisName,"zoomRate : "+Float.toString(data.getZoomRate()));

        //FLASH
        if(data.isFlashOnOff()){
            data.getBuilder().set(CaptureRequest.FLASH_MODE, CameraCharacteristics.FLASH_MODE_TORCH);
            flashButton.setImageResource(R.drawable.ic_flash_on);
        } else {
            data.getBuilder().set(CaptureRequest.FLASH_MODE,CameraCharacteristics.FLASH_MODE_OFF);
            flashButton.setImageResource(R.drawable.ic_flash_off);
        }

        //CONTROL_ZOOM
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) { //레드 벨벳 케이크 - 30
            data.getBuilder().set(CaptureRequest.CONTROL_ZOOM_RATIO,data.getZoomRate());
        }

        //data.getBuilder().set(CaptureRequest.CONTROL_MODE, CameraMetadata.CONTROL_MODE_AUTO);
        data.getSession().setRepeatingRequest(data.getBuilder().build(), null, data.getHandler());
    }

}