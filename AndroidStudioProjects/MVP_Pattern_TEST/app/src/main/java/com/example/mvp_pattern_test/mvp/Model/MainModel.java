package com.example.mvp_pattern_test.mvp.Model;

import android.util.Log;

import com.example.mvp_pattern_test.mvp.Presenter.Contract;

public class MainModel {

    static String thisName = "MainModel";
    Contract.Presenter presenter;

    public MainModel(Contract.Presenter presenter){
        Log.d(thisName,"생성자 호출");
        this.presenter = presenter;
    }
}
