package com.snaptag.labcode_china.navigation.scan.model;


import android.app.Activity;
import android.content.SharedPreferences;

import com.snaptag.labcode_china.navigation.scan.presenter.ScanContract;

import java.util.UUID;

public class ScanModel {

    ScanContract.Presenter presenter;
    static Activity activity;

    public ScanModel(ScanContract.Presenter presenter, Activity activity){
        this.presenter = presenter;
        this.activity = activity;

        initUuid();

    }

    //UUID 초기화
    private void initUuid() {
        SharedPreferences mPref = activity.getSharedPreferences("KEY_PREF", activity.MODE_PRIVATE);
        String uuid = mPref.getString("KEY_UUID", null);
        if (uuid == null) {
            uuid = UUID.randomUUID().toString();

            mPref.edit().putString("KEY_UUID", uuid + "5").apply();
        }
    }

    //UUID 조회
    public static String getUuid() {
        SharedPreferences mPref = activity.getSharedPreferences("KEY_PREF", activity.MODE_PRIVATE);
        return mPref.getString("KEY_UUID", null);
    }


}
