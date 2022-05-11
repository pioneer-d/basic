package com.snaptag.beidou_test_project2;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    static String thisName = "MainActivity";

    LocationManager locationManager;
    Button button;
    TextView text;
    Location location;
    ToggleButton tb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(thisName,"onCreate() 실행");
        setContentView(R.layout.activity_main);
        Log.d(thisName,"this Version :" +String.valueOf(Build.VERSION.SDK_INT));  //-> 샤오미 : 30

        button = (Button) findViewById(R.id.button);
        text = (TextView) findViewById(R.id.loadGps);
        tb = (ToggleButton) findViewById(R.id.toggle1);
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Log.d(thisName,"locationManager : "+ String.valueOf(locationManager));

//        if ( Build.VERSION.SDK_INT >= 23 && ContextCompat.checkSelfPermission( getApplicationContext(), android.Manifest.permission.ACCESS_FINE_LOCATION ) != PackageManager.PERMISSION_GRANTED ) {
//            ActivityCompat.requestPermissions( MainActivity.this, new String[] { android.Manifest.permission.ACCESS_FINE_LOCATION }, 0 );
//        } else {
//            location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
//            if(location == null) {
//                location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
//            }
//        }

        tb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (Build.VERSION.SDK_INT >= 23 && ContextCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(MainActivity.this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, 0);
                    } else {
                        if (tb.isChecked()) {
                            text.setText("수신중..");
                            // GPS 제공자의 정보가 바뀌면 콜백하도록 리스너 등록하기~!!!
                            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, // 등록할 위치제공자
                                    100, // 통지사이의 최소 시간간격 (miliSecond)
                                    1, // 통지사이의 최소 변경거리 (m)
                                    gpsLocationListener);
                            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, // 등록할 위치제공자
                                    100, // 통지사이의 최소 시간간격 (miliSecond)
                                    1, // 통지사이의 최소 변경거리 (m)
                                    gpsLocationListener);
                            locationManager.requestLocationUpdates(LocationManager.PASSIVE_PROVIDER, // 등록할 위치제공자
                                    100, // 통지사이의 최소 시간간격 (miliSecond)
                                    1, // 통지사이의 최소 변경거리 (m)
                                    gpsLocationListener);
                        } else {
                            text.setText("위치정보 미수신중");
                            locationManager.removeUpdates(gpsLocationListener);  //  미수신할때는 반드시 자원해체를 해주어야 한다.
                        }
                    }
                } catch (SecurityException e) {
                    e.printStackTrace();
                    e.getMessage();
                }
            }


        });

    }

    final LocationListener gpsLocationListener = new LocationListener() {
        public void onLocationChanged(Location location) {
            Log.d(thisName,"onLocationChanged(  ) 실행");
            String provider = location.getProvider();
            double longitude = location.getLongitude();
            double latitude = location.getLatitude();
            double altitude = location.getAltitude();
            double accuracy = location.getAccuracy();
            text.setText("위치정보 : " + provider + "\n" + "위도 : " + longitude + "\n" + "경도 : " + latitude + "\n" + "고도 : " + altitude + "\n" + "정확도 : " +accuracy);
        }

        public void onStatusChanged(String provider, int status, Bundle extras) {
        }

        public void onProviderEnabled(String provider) {
        }

        public void onProviderDisabled(String provider) {
        }
    };
}