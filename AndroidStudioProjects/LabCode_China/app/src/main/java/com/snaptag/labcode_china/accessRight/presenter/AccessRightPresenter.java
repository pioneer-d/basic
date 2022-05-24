package com.snaptag.labcode_china.accessRight.presenter;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.snaptag.labcode_china.accessRight.model.AccessRightModel;

import java.util.ArrayList;
import java.util.List;

public class AccessRightPresenter implements AccessRightContract.Presenter {

    static String thisName = "AccessRightPresenter";

    AccessRightContract.View view;
    AccessRightModel model;
    Context context;
    Activity activity;

    //리뉴얼
    private String[] permissions = {
      Manifest.permission.CAMERA,
      Manifest.permission.ACCESS_FINE_LOCATION
    };

    private List permissionList;
    private final int MULTIPLE_PERMISSIONS = 1001;

    public AccessRightPresenter(AccessRightContract.View view, Context context, Activity activity) {
        this.view = view;
        this.context = context;
        this.activity = activity;
        model = new AccessRightModel(this);

    }

    //리뉴얼

    //사전 권한 검사
    @Override
    public boolean checkPermission(){
        int result;
        permissionList = new ArrayList<>();

        for (String pm : permissions){
            result = ContextCompat.checkSelfPermission(context,pm);
            if (result != PackageManager.PERMISSION_GRANTED){
                Log.d(thisName,"허용 안한 것"+pm);
                permissionList.add(pm);
            }
        }

        if (!permissionList.isEmpty()){
            return false;
        }
        return true;
    }

    //권한 허용 요청
    @Override
    public void requestPermission(){
        Log.d(thisName,"requestPermission() 실행");
        ActivityCompat.requestPermissions(activity, (String[]) permissionList.toArray(new String[permissionList.size()]), MULTIPLE_PERMISSIONS);
    }


}
