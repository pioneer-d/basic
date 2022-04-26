package com.snaptag.labcode_china.navigation.scan.view;


import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.location.GnssStatus;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.Toast;

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
    private ImageButton flashButton, flashButton2, zoom, zoom_more, zoom_1_0, zoom_1_5, zoom_2_0;
    private FrameLayout zoomBox;

    private boolean zoomClick = false;

//    //여기부터 GPS
//    private LocationManager locationManager;

    public static ScanControlFragment newInstance() {
        if(instance == null){
            instance = new ScanControlFragment();
        }
        Bundle args = new Bundle();

        instance.setArguments(args);
        return instance;
    }

//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        //  longtitude = 127.12355855, latitude = 37.38772617
//        if (ActivityCompat.checkSelfPermission(getContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
//                && ActivityCompat.checkSelfPermission(getContext(), android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            //권한이 없을 경우 최초 권한 요청 또는 사용자에 의한 재요청 확인
//            if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), android.Manifest.permission.ACCESS_FINE_LOCATION) &&
//                    ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), android.Manifest.permission.ACCESS_COARSE_LOCATION)) {
//                // 권한 재요청
//                ActivityCompat.requestPermissions(getActivity(), new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_COARSE_LOCATION}, 100);
//                return;
//            } else {
//                ActivityCompat.requestPermissions(getActivity(), new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_COARSE_LOCATION}, 100);
//                return;
//            }
//        }
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_control_scan, container, false);
        textureView = view.findViewById(R.id.textureView);

        flashButton = view.findViewById(R.id.flash);
        flashButton2 = view.findViewById(R.id.flash2);
        zoom = view.findViewById(R.id.zoom);
        zoom_more = view.findViewById(R.id.zoom_more);
        zoomBox = view.findViewById(R.id.zoom_box);
        zoom_1_0 = view.findViewById(R.id.zoom_1_0);
        zoom_1_5 = view.findViewById(R.id.zoom_1_5);
        zoom_2_0 = view.findViewById(R.id.zoom_2_0);

        flashButton.setOnClickListener(this);
        flashButton2.setOnClickListener(this);
        zoom.setOnClickListener(this);
        zoom_more.setOnClickListener(this);
        zoom_1_0.setOnClickListener(this);  zoom_1_0.setBackgroundResource(R.drawable.ic_black_box);
        zoom_1_5.setOnClickListener(this);
        zoom_2_0.setOnClickListener(this);

//        //여기부터 GPS
//        //권한 체크
//        if (ActivityCompat.checkSelfPermission(getActivity().getApplicationContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//
//        }
//        locationManager = (LocationManager)getActivity().getSystemService(Context.LOCATION_SERVICE);
//        Location lastKnownLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
//        if (lastKnownLocation != null) {
//            double lng = lastKnownLocation.getLongitude();
//            double lat = lastKnownLocation.getLatitude();
//            Log.d(thisName, "longtitude=" + lng + ", latitude=" + lat);
//
//        }


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
                break;
            case R.id.zoom: case R.id.zoom_more: zoomClick = (zoomClick == true) ? false : true;
                if (zoomClick == true) {
                    zoom.setImageResource(R.drawable.ic_filled_circle);
                    zoomBox.setVisibility(View.VISIBLE);
                } else {
                    zoom.setImageResource(R.drawable.ic_blanked_circle);
                    zoomBox.setVisibility(View.INVISIBLE);
                } break;
            case R.id.zoom_1_0: zoom_1_0.setBackgroundResource(R.drawable.ic_black_box);
                                zoom_1_5.setBackgroundResource(R.drawable.ic_gray_box);
                                zoom_2_0.setBackgroundResource(R.drawable.ic_gray_box);
                                break;
            case R.id.zoom_1_5: zoom_1_5.setBackgroundResource(R.drawable.ic_black_box);
                                zoom_1_0.setBackgroundResource(R.drawable.ic_gray_box);
                                zoom_2_0.setBackgroundResource(R.drawable.ic_gray_box);
                                break;
            case R.id.zoom_2_0: zoom_2_0.setBackgroundResource(R.drawable.ic_black_box);
                                zoom_1_0.setBackgroundResource(R.drawable.ic_gray_box);
                                zoom_1_5.setBackgroundResource(R.drawable.ic_gray_box);
                                break;
        }
        try {
            Log.d(thisName,"onClick 실행");
            presenter.controlSetting(getId); }
        catch (CameraAccessException e) { e.printStackTrace(); }
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
            flashButton.setImageResource(R.drawable.ic_filled_circle);
        } else {
            data.getBuilder().set(CaptureRequest.FLASH_MODE,CameraCharacteristics.FLASH_MODE_OFF);
            flashButton.setImageResource(R.drawable.ic_blanked_circle);
        }

        //CONTROL_ZOOM
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) { //레드 벨벳 케이크 - 30
            data.getBuilder().set(CaptureRequest.CONTROL_ZOOM_RATIO,data.getZoomRate());
        }

        //data.getBuilder().set(CaptureRequest.CONTROL_MODE, CameraMetadata.CONTROL_MODE_AUTO);
        data.getSession().setRepeatingRequest(data.getBuilder().build(), null, data.getHandler());
    }

}