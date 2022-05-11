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

import java.util.List;

public class MainActivity extends AppCompatActivity {

    LocationManager locationManager;
    Button button;
    TextView text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("this Version :",String.valueOf(Build.VERSION.SDK_INT));  //-> 샤오미 : 30

        button = (Button) findViewById(R.id.button);
        text = (TextView)findViewById(R.id.loadGps);
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ( Build.VERSION.SDK_INT >= 23 && ContextCompat.checkSelfPermission( getApplicationContext(), android.Manifest.permission.ACCESS_FINE_LOCATION ) != PackageManager.PERMISSION_GRANTED ) {
                    ActivityCompat.requestPermissions( MainActivity.this, new String[] { android.Manifest.permission.ACCESS_FINE_LOCATION }, 0 );
                } else {
                    //Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                    //Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                    //Location location = locationManager.getLastKnownLocation(LocationManager.KEY_LOCATIONS);
                    //Location location = locationManager.getLastKnownLocation(LocationManager.FUSED_PROVIDER);
                    //Location location = locationManager.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER);
                    List<String> providers = locationManager.getProviders(false);
                    Location location = null;
                    Log.d("providers.size() : ",String.valueOf(providers.size()));

                    for (int i=0; i<3; i++) {
                        location = locationManager.getLastKnownLocation(providers.get(i));
                        Log.d("qweqwe location : ",String.valueOf(providers.get(i)));
                        if (location != null) break;
                    }

                    String provider = location.getProvider();
                    double longitude = location.getLongitude();
                    double latitude = location.getLatitude();
                    double altitude = location.getAltitude();
                    text.setText("위치정보 : " + provider + "\n" + "위도 : " + longitude + "\n" + "경도 : " + latitude + "\n" + "고도 : " + altitude);

                    //위치정보를 원하는 시간, 거리마다 갱신해줌.
//                    locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 1, gpsLocationListener);
//                    locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1000, 1, gpsLocationListener);
                }
            }

        });

    }


    final LocationListener gpsLocationListener = new LocationListener() {
        public void onLocationChanged(Location location) {
            String provider = location.getProvider();
            double longitude = location.getLongitude();
            double latitude = location.getLatitude();
            double altitude = location.getAltitude();
            text.setText("위치정보 : " + provider + "\n" + "위도 : " + longitude + "\n" + "경도 : " + latitude + "\n" + "고도 : " + altitude);
        }

        public void onStatusChanged(String provider, int status, Bundle extras) {
        }

        public void onProviderEnabled(String provider) {
        }

        public void onProviderDisabled(String provider) {
        }
    };



}