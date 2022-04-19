package com.example.mvp_pattern_test.mvp.Presenter;

import com.example.mvp_pattern_test.mvp.Model.MainModel;

public class MainPresenter implements Contract.Presenter{

    Contract.View view;
    MainModel mainmodel;

    //생성자
    public MainPresenter(Contract.View view){
        this.view = view;
        mainmodel = new MainModel(this);
    }

    //implement 구현
    @Override
    public void addNum(int num1, int num2) {
        view.showResult(num1 + num2);
    }
}
