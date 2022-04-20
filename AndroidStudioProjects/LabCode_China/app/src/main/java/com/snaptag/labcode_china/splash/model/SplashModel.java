package com.snaptag.labcode_china.splash.model;

import com.snaptag.labcode_china.splash.presenter.SplashContract;

public class SplashModel {

    SplashContract.Presenter presenter;

    public SplashModel(SplashContract.Presenter presenter){
        this.presenter = presenter;
    }
}
