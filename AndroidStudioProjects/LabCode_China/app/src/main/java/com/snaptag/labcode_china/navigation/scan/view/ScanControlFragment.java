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
import com.snaptag.labcode_china.navigation.scan.presenter.ScanContract;
import com.snaptag.labcode_china.navigation.scan.presenter.ScanPresenter;

import java.util.Arrays;


public class ScanControlFragment extends Fragment implements ScanContract.View {

    private static String thisName = "ScanControlFragment";

    private static ScanControlFragment instance;
    private ScanControlFragment() {
    }

    private ScanContract.Presenter presenter;

    private View view;
    private TextureView textureView;

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


    public void updatePreview(CameraDevice device, CaptureRequest.Builder builder, CameraCaptureSession captureSession, Handler handler) throws CameraAccessException{
        Log.d(thisName,"updatePreview");
        if (device == null){
            return;
        }
        builder.set(CaptureRequest.CONTROL_MODE, CameraMetadata.CONTROL_MODE_AUTO);
        captureSession.setRepeatingRequest(builder.build(), null, handler);
    }


}