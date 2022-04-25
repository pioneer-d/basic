package com.snaptag.labcode_china.navigation.scan.model;


import com.snaptag.labcode_china.navigation.scan.presenter.ScanContract;

public class ScanModel {

    ScanContract.Presenter presenter;

    public ScanModel(ScanContract.Presenter presenter){
        this.presenter = presenter;
    }
}
