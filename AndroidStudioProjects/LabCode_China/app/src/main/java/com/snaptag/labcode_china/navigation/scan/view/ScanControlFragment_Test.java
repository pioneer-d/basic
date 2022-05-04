package com.snaptag.labcode_china.navigation.scan.view;

import android.hardware.camera2.CameraAccessException;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;

import com.google.gson.JsonObject;
import com.snaptag.cameramodule.STCameraView;
import com.snaptag.cameramodule.model.DetectResult;
import com.snaptag.labcode_china.R;
import com.snaptag.labcode_china.navigation.scan.model.CameraData;
import com.snaptag.labcode_china.navigation.scan.presenter.ScanContract;
import com.snaptag.labcode_china.navigation.scan.presenter.ScanPresenter;

import java.util.Timer;
import java.util.TimerTask;


public class ScanControlFragment_Test extends Fragment implements View.OnClickListener, STCameraView.OnDetectResultListener {

    private static ScanControlFragment_Test instance;
    private ScanControlFragment_Test() { }

    private View view;
    private STCameraView stCameraView = null;
    private ImageButton flashButton, flashButton2, zoom, zoom_more, zoom_1_0, zoom_1_5, zoom_2_0;

    //Timer 관련
    private Timer timer = null;
    private boolean isCancel = false;


    //API 관련
    private Button testButton;
    private FrameLayout zoomBox;

    private boolean zoomClick = false;

    private ScanContract.Presenter presenter;
    CameraData data;

    public static ScanControlFragment_Test newInstance() {
        if(instance == null){
            instance = new ScanControlFragment_Test();
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
        view = inflater.inflate(R.layout.fragment_scan_control__test, container, false);

        stCameraView = (STCameraView) view.findViewById(R.id.st_camera);

        flashButton = view.findViewById(R.id.flash);
        flashButton2 = view.findViewById(R.id.flash2);
        zoom = view.findViewById(R.id.zoom);
        zoom_more = view.findViewById(R.id.zoom_more);
        zoomBox = view.findViewById(R.id.zoom_box);
        zoom_1_0 = view.findViewById(R.id.zoom_1_0);
        zoom_1_5 = view.findViewById(R.id.zoom_1_5);
        zoom_2_0 = view.findViewById(R.id.zoom_2_0);

        //API 관련
        testButton = view.findViewById(R.id.testButton);

        flashButton.setOnClickListener(this);
        flashButton2.setOnClickListener(this);
        zoom.setOnClickListener(this);
        zoom_more.setOnClickListener(this);
        zoom_1_0.setOnClickListener(this);
        zoom_1_0.setBackgroundResource(R.drawable.ic_black_box);
        zoom_1_5.setOnClickListener(this);
        zoom_2_0.setOnClickListener(this);
        testButton.setOnClickListener(this);

        data = CameraData.getInstance();
        //presenter = new ScanPresenter(this,getActivity(),textureView);
        initCameraModule();
        return view;
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
                    stCameraView.setFlash(true);
                } else {
                    zoom.setImageResource(R.drawable.ic_blanked_circle);
                    zoomBox.setVisibility(View.INVISIBLE);
                    stCameraView.setFlash(false);
                } break;
            case R.id.zoom_1_0: zoom_1_0.setBackgroundResource(R.drawable.ic_black_box);
                zoom_1_5.setBackgroundResource(R.drawable.ic_gray_box);
                zoom_2_0.setBackgroundResource(R.drawable.ic_gray_box);
                data.setZoomRate(1.0f);
                stCameraView.setZoom(data.getZoomRate());
                break;
            case R.id.zoom_1_5: zoom_1_5.setBackgroundResource(R.drawable.ic_black_box);
                zoom_1_0.setBackgroundResource(R.drawable.ic_gray_box);
                zoom_2_0.setBackgroundResource(R.drawable.ic_gray_box);
                data.setZoomRate(1.5f);
                stCameraView.setZoom(data.getZoomRate());
                break;
            case R.id.zoom_2_0: zoom_2_0.setBackgroundResource(R.drawable.ic_black_box);
                zoom_1_0.setBackgroundResource(R.drawable.ic_gray_box);
                zoom_1_5.setBackgroundResource(R.drawable.ic_gray_box);
                data.setZoomRate(2.0f);
                stCameraView.setZoom(data.getZoomRate());
                break;
        }


    }

    private void initCameraModule(){
        stCameraView.setDetectListener(this);
    }


    @Override
    public void onResume() {
        super.onResume();

        if (stCameraView != null){
            stCameraView.setStartZoom(data.getZoomRate());
            stCameraView.setFlash(false);
            stCameraView.stDetectStart();
        }
        //stratTimer();
    }

    @Override
    public void getDetectResult(JsonObject jsonObject) {

    }

    @Override
    public void getDetectResult(DetectResult detectResult) {

    }


}






























