package com.snaptag.labcode_china.network;



import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.util.Log;

import androidx.core.app.ActivityCompat;

public class GetLocation {

    static String thisName = "GetLocation";
    Activity activity;

    LocationManager locationManager;

    public GetLocation(Activity activity){
        Log.d(thisName,"GetLocation 생성자 호출");
        this.activity = activity;
        locationManager = (LocationManager) this.activity.getSystemService(Context.LOCATION_SERVICE);
        callLocation();
    }

    public void callLocation(){
        //1분, 1km 마다 update
        try{
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, // 등록할 위치제공자
                    3000, // 통지사이의 최소 시간간격 (miliSecond)
                    100, // 통지사이의 최소 변경거리 (m)
                    gpsLocationListener);
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, // 등록할 위치제공자
                    3000, // 통지사이의 최소 시간간격 (miliSecond)
                    100, // 통지사이의 최소 변경거리 (m)
                    gpsLocationListener);
        }catch (Exception e){
            e.getMessage();
        }

    }

    final LocationListener gpsLocationListener = new LocationListener() {
        public void onLocationChanged(Location location) {
            Log.d(thisName, "onLocationChanged() 실행");
            String provider = location.getProvider();
            double longitude = location.getLongitude();
            double latitude = location.getLatitude();
            double altitude = location.getAltitude();
            double accuracy = location.getAccuracy();
            Log.d(thisName,"위치정보 : " + provider + "\n" + "위도 : " + longitude + "\n" + "경도 : " + latitude + "\n" + "고도 : " + altitude + "\n" + "정확도 : " + accuracy);

            SharedPreferences mPref = activity.getSharedPreferences("LOCATION_PREF", activity.MODE_PRIVATE);
            String locationData = String.valueOf(longitude)+","+String.valueOf(latitude);
            mPref.edit().putString("LOCATION_PREF", locationData).apply();

        }
    };

    /*
        private void initUuid() {
        Log.d(thisName,"initUuid() 실행");
        SharedPreferences mPref = getActivity().getSharedPreferences("KEY_PREF", getActivity().MODE_PRIVATE);
        String uuid = mPref.getString("KEY_UUID", null);
        if (uuid == null) {
            uuid = UUID.randomUUID().toString();

            mPref.edit().putString("KEY_UUID", uuid + "5").apply();
        }
    }
     */





}