package com.snaptag.labcode_china.accessRight.presenter;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.snaptag.labcode_china.accessRight.model.AccessRightModel;

public class AccessRightPresenter implements AccessRightContract.Presenter {

    AccessRightContract.View view;
    AccessRightModel model;
    Context context;
    Activity activity;

    public AccessRightPresenter(AccessRightContract.View view, Context context, Activity activity){
        this.view = view;
        this.context = context;
        this.activity = activity;
        model = new AccessRightModel(this);

    }

    @Override
    public void controlCheck() {
        boolean checkCamera = cameraRightConfirm();
        boolean checkCameraGps = gpsRightConfirm();
        if (checkCamera && checkCameraGps){
            view.goMain();
        } else {
            view.alertCheckRight(checkCamera,checkCameraGps);
        }

    }

    @Override
    public boolean cameraRightConfirm() {     //사전 권한 여부 확인
        if(ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            return false;
        }
        return true;
    }

    @Override
    public boolean gpsRightConfirm() {
        if(ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            return false;
        }
        return true;
//        if(Build.VERSION.SDK_INT >= 23 && ContextCompat.checkSelfPermission(context, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions(activity, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, 0);
//        }
//        return true;
    }


}
