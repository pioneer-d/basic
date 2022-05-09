package com.snaptag.labcode_china.beidou;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;

import com.snaptag.labcode_china.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class LocationManager_Sample_Activity extends AppCompatActivity implements View.OnClickListener,
        Location_Manager.ILocationListener, Location_Manager.INmeaListener, Location_Manager.ISatelliteListener {

    private static String thisName = "LocationManager_Sample_Activity";

    private static final int LOG_TYPE_VERBOSE = 0;
    private static final int LOG_TYPE_DEBUG = 1;
    private static final int LOG_TYPE_INFO = 2;
    private static final int LOG_TYPE_WARNING = 3;
    private static final int LOG_TYPE_ERROR = 4;

    private static final int PERMISSION_REQUEST_CODE = 0;

    private Button btn_start;
    private Location_Manager mLocationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locationmanager);
        btn_start = (Button) findViewById(R.id.location_btn_start);
        btn_start.setOnClickListener(this);

        initGPS();
    }


    public void initGPS(){
        mLocationManager = new Location_Manager(this);
//    mLocationManager.setUsingAPI(Location_Manager.API_NOUGAT);
        mLocationManager.addLocationListener(this);
        mLocationManager.addSatelliteListener(this);
        mLocationManager.addNmeaListener(this);
    }

    @Override
    public void onLocation(int provider, Location location) {
        Log.d(thisName,"onLocation() 실행");
        Log.d(thisName,"location.toString() : "+location.toString());
    }

    @Override
    public void onSatellite(int findSatellite, ArrayList<Location_Manager.Satellite> arrayGnss) {
        Log.d(thisName,"onSatellite() 실행");
        for (int i = 0; i < arrayGnss.size(); i++) {
           Log.d(thisName,arrayGnss.get(i).toString() + "\n");
        }
    }

    @Override
    public void onNmea(String nmea) {
        Log.d(thisName,"onNmea() 실행");
        Log.d(thisName,"nmea : "+nmea);

    }



    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.location_btn_start:

                if (!mLocationManager.isLocationSettingOn(this)) {
                    return;
                }

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

                    if (!mLocationManager.isGrantedPermission(this)) {

                        mLocationManager.requestPermission(this, PERMISSION_REQUEST_CODE);
                        return;
                    }

                }

                mLocationManager.start();

                break;
        }
    }



    ////////////////////
    // 권한 요청 결과 //
    ////////////////////
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == PERMISSION_REQUEST_CODE) {

            for (int i = 0; i < permissions.length; i++) {

                if (grantResults[i] == PackageManager.PERMISSION_DENIED) {
                    return;
                }

            }

            mLocationManager.start();

        }

    }
}