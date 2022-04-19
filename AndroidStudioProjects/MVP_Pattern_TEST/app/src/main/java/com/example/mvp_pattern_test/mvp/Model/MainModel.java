package com.example.mvp_pattern_test.mvp.Model;

import com.example.mvp_pattern_test.mvp.Presenter.Contract;

public class MainModel {
    Contract.Presenter presenter;
    public MainModel(Contract.Presenter presenter){
        this.presenter = presenter;
    }
}
