package com.snaptag.beidou_test_project;

import android.app.Activity;
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
import android.widget.TextView;

import com.snaptag.beidou_test_project.R;
import com.snaptag.beidou_test_project.Location_Manager;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class LocationManager_Sample_Activity extends Activity implements View.OnClickListener,
        Location_Manager.ILocationListener, Location_Manager.INmeaListener, Location_Manager.ISatelliteListener {

    private static final String LOG_TAG = LocationManager_Sample_Activity.class.getSimpleName();

    private static final int LOG_TYPE_VERBOSE = 0;
    private static final int LOG_TYPE_DEBUG = 1;
    private static final int LOG_TYPE_INFO = 2;
    private static final int LOG_TYPE_WARNING = 3;
    private static final int LOG_TYPE_ERROR = 4;

    private static final int PERMISSION_REQUEST_CODE = 0;

    private Location_Manager mLocationManager;

    private Button btn_start;
    private Button btn_stop;
    private Button btn_uselog;
    private ScrollView sv_log;
    private TextView tv_log;
    private Button btn_clearlog;
    private TextView tv_location;
    private TextView tv_nmea;
    private TextView tv_satellite;

    private boolean mIsUseLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locationmanager);

        initValue();
        initLayout();
        initGps();

    }

    ///////////////////
    // 초기화 메서드 //
    ///////////////////
    /**
     * 초기 값 설정.
     */
    private void initValue() {

        mIsUseLog = false;

    }

    /**
     * 초기 레이아웃 설정.
     */
    private void initLayout() {

        btn_start = (Button) findViewById(R.id.location_btn_start);
        btn_stop = (Button) findViewById(R.id.location_btn_stop);
        btn_uselog = (Button) findViewById(R.id.location_btn_uselog);
        sv_log = (ScrollView) findViewById(R.id.location_sv_log);
        tv_log = (TextView) findViewById(R.id.location_tv_log);
        btn_clearlog = (Button) findViewById(R.id.location_btn_clearlog);
        tv_location = (TextView) findViewById(R.id.location_tv_location);
        tv_nmea = (TextView) findViewById(R.id.location_tv_nmea);
        tv_satellite = (TextView) findViewById(R.id.location_tv_satellite);

        btn_start.setOnClickListener(this);
        btn_stop.setOnClickListener(this);
        btn_uselog.setOnClickListener(this);
        btn_clearlog.setOnClickListener(this);

    }

    /**
     * 초기 GPS 설정.
     */
    private void initGps() {

        mLocationManager = new Location_Manager(this);
//    mLocationManager.setUsingAPI(Location_Manager.API_NOUGAT);
        mLocationManager.addLocationListener(this);
        mLocationManager.addSatelliteListener(this);
        mLocationManager.addNmeaListener(this);
//        mLocationManager.setUseLog(true);

    }

    //////////////////////////
    // View.OnClickListener //
    //////////////////////////
    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.location_btn_start:

                if (!mLocationManager.isLocationSettingOn(this)) {
                    setLog(LOG_TYPE_ERROR, "GPS를 사용하기 위해 설정에서 GPS를 켜주시기 바랍니다.");
                    mLocationManager.showLocationSetting(this);
                    return;
                }

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

                    if (!mLocationManager.isGrantedPermission(this)) {
                        setLog(LOG_TYPE_WARNING, "GPS를 사용하기 위해 권한을 허용해 주시기 바랍니다.");
                        mLocationManager.requestPermission(this, PERMISSION_REQUEST_CODE);
                        return;
                    }

                }

                btn_start.setEnabled(false);
                btn_stop.setEnabled(true);
                setLog(LOG_TYPE_INFO, "GPS 시작.");
                mLocationManager.start();

                break;
            case R.id.location_btn_stop:

                btn_start.setEnabled(true);
                btn_stop.setEnabled(false);
                setLog(LOG_TYPE_INFO, "GPS 중지.");
                mLocationManager.stop();

                break;
            case R.id.location_btn_uselog:

                mLocationManager.setUseLog(!mIsUseLog);
                mIsUseLog = !mIsUseLog;
                setLog(LOG_TYPE_INFO, "GPS 로그 사용 " + (mIsUseLog ? "함." : "안함."));

                break;
            case R.id.location_btn_clearlog:

                tv_log.setText("");

                break;
        }

    }

    ////////////////////////////////////////
    // Location_Manager.ILocationListener //
    ////////////////////////////////////////
    @Override
    public void onLocation(int provider, Location location) {

        tv_location.setText("onLocation" + (location.isFromMockProvider() ? "[mock]" : "[" + location.getProvider()) + "]\n");
        try{
            tv_location.append(location.toString());
            location.getLatitude();
            location.getLongitude();
            Log.d("위도 경도 : ",location.getLatitude() +","+ String.valueOf(location.getLongitude()));
            Log.d("qqqqq","test");
            Log.d("qweqwe Location : ",location.toString());
        }catch (Exception e){
            Log.e("Location : ","지금");
            e.printStackTrace();
            e.getMessage();
        }
//        tv_location.append(location.toString());
//        Log.d("qweqwe Location : ",location.toString());

    }

    ////////////////////////////////////
    // Location_Manager.INmeaListener //
    ////////////////////////////////////
    @Override
    public void onNmea(String nmea) {

        tv_nmea.setText("onNmea\n");
        tv_nmea.append(nmea);

    }

    /////////////////////////////////////////
    // Location_Manager.ISatelliteListener //
    /////////////////////////////////////////
    @Override
    public void onSatellite(int findSatellite, ArrayList<Location_Manager.Satellite> arrayGnss) {

        tv_satellite.setText("onSatellite\n");
        for (int i = 0; i < arrayGnss.size(); i++) {
            tv_satellite.append(arrayGnss.get(i).toString() + "\n");
            Log.d("qweqwe arrayGnss : ",arrayGnss.get(i).toString() + "\n");
        }

    }

    /////////////////
    // 일반 메서드 //
    /////////////////
    private void setLog(int type, String msg) {

        String time = new SimpleDateFormat("HH:mm:ss").format(System.currentTimeMillis());
        String logMsg = "\n" + time + " : " + msg;

        SpannableStringBuilder builder = new SpannableStringBuilder(logMsg);
        int msgColor = Color.parseColor("#000000");
        if (type == LOG_TYPE_DEBUG) {
            msgColor = Color.parseColor("#0100FF");
        } else if (type == LOG_TYPE_INFO) {
            msgColor = Color.parseColor("#00BB58");
        } else if (type == LOG_TYPE_WARNING) {
            msgColor = Color.parseColor("#FFBB00");
        } else if (type == LOG_TYPE_ERROR) {
            msgColor = Color.parseColor("#FF0000");
        }
        builder.setSpan(new ForegroundColorSpan(msgColor), 0, logMsg.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        tv_log.append(builder);
        sv_log.fullScroll(ScrollView.FOCUS_DOWN);

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
                    setLog(LOG_TYPE_ERROR, "권한을 허용하지 않아 GPS를 사용 할 수 없습니다.");
                    return;
                }

            }

            setLog(LOG_TYPE_INFO, "GPS 시작.");
            mLocationManager.start();

        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (mLocationManager != null) {
            mLocationManager.stop();
        }

    }

}
