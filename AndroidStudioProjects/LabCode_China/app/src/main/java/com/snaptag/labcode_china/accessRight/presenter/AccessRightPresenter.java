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
    public void controlCheck() {
        Boolean check = rightConfirm();
        if (check){
            view.goMain();
        } else {
            view.alertCheckRight();
        }
    }

    @Override
    public boolean rightConfirm() {
        if(ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            return false;
        }
        return true;
    }


}
