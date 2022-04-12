package com.example.myapplication;

import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class LaunchActivity extends AppCompatActivity {

    private int REQUEST_CODE_PERMISSIONS = 1001;
    private final String[] REQUIRE_PERMISSIONS = new String[]{"android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE"};
    private static String activityName = "LaunchActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        if(allPermissionsGranted()) { //권한 존재하면 Main으로 이동
            Log.d(activityName," onCreate 권한 허용으로 인한 실행");
        //if(true) { //권한 존재하면 Main으로 이동 test
            Log.d(activityName," onCreate 권한 허용으로 인한 실행");
            Intent mainIntent = new Intent(LaunchActivity.this, StartButtonActivity.class);
            startActivity(mainIntent);
            finish();
        } else {
            Log.d(activityName,"onCreate 권한 미허용으로 인한 종료");
            ActivityCompat.requestPermissions(this,REQUIRE_PERMISSIONS,REQUEST_CODE_PERMISSIONS);
        }
    }

    // 앱을 설치했을때 권한을 묻는 시점에 실행할 메소드.
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
            if (allPermissionsGranted()) { //권한 허용시 Main으로 이동
                Log.d(activityName,"최초 권한 미허용으로 인한 실행");
                Intent mainIntent = new Intent(LaunchActivity.this, StartButtonActivity.class);
                startActivity(mainIntent);
            } else {
                Toast.makeText(this, "카메라 권한이 필요합니다.", Toast.LENGTH_SHORT).show();
                Log.d(activityName,"최초 권한 미허용으로 인한 종료");
                this.finish();
            }

    }

    // 이미 앱에 권한을 부여한 경우 확인.
    // checkSelfPermission의 반환값이 PERMISSION_GRANTED or PERMISSION_DENIED
    private boolean allPermissionsGranted(){
            if(ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
                return false;
            }
        return true;
    }


}