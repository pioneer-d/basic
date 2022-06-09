package com.snaptagScanner.china.main.model;

import com.snaptagScanner.china.main.presenter.MainContract;

public class MainModel {

    MainContract.Presenter presenter;

    public MainModel(MainContract.Presenter presenter){
        this.presenter = presenter;
    }

}
