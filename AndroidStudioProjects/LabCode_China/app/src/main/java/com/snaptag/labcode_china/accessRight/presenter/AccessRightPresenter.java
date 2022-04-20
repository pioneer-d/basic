package com.snaptag.labcode_china.accessRight.presenter;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;

import androidx.core.content.ContextCompat;

import com.snaptag.labcode_china.accessRight.model.AccessRightModel;

public class AccessRightPresenter implements AccessRightContract.Presenter {

    AccessRightContract.View view;
    AccessRightModel model;
    Context context;

    public AccessRightPresenter(AccessRightContract.View view, Context context){
        this.view = view;
        this.context = context;
        model = new AccessRightModel(this);

    }

    @Override
    public void checkRight() {
        Boolean check = allPermissionsGranted();
        if (check){
            view.goMain();
        } else {
            view.alertCheckRight(); // --> 여기부터 view로 넘어갔다가 다시 presenter로 오는 구조로 이어서 만들기.
        }
    }

    //최초 권한 확인
    private boolean allPermissionsGranted(){
        if(ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            return false;
        }
        return true;
    }
}
