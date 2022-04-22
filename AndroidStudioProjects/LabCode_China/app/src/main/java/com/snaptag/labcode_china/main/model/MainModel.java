package com.snaptag.labcode_china.main.model;

import com.snaptag.labcode_china.main.presenter.MainContract;

public class MainModel {

    MainContract.Presenter presenter;

    public MainModel(MainContract.Presenter presenter){
        this.presenter = presenter;
    }

}
