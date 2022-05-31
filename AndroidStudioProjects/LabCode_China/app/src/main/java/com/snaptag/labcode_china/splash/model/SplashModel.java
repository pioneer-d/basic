package com.snaptag.labcode_china.splash.model;

import android.app.Activity;
import android.content.SharedPreferences;
import android.util.Log;

import com.snaptag.labcode_china.splash.presenter.SplashContract;

public class SplashModel {

    static String thisName = "SplashModel";

    SplashContract.Presenter presenter;
    Activity activity;

    public SplashModel(SplashContract.Presenter presenter, Activity activity){
        this.presenter = presenter;
        this.activity = activity;
    }

    public String getPersonalAccess(){
        SharedPreferences mPref = activity.getSharedPreferences("PERSONAL_ACCESS_PREF",activity.MODE_PRIVATE);
        String getPersonalAccess = mPref.getString("PERSONAL_ACCESS_PREF",null);
        if (getPersonalAccess == null){
            getPersonalAccess = "false";
        }
        Log.d(thisName,"getPersonalAccess : "+getPersonalAccess);
        return  getPersonalAccess;
    }



}
