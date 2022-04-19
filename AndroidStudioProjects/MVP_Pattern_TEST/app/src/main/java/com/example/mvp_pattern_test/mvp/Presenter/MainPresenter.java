package com.example.mvp_pattern_test.mvp.Presenter;

import android.util.Log;

import com.example.mvp_pattern_test.mvp.Model.MainModel;

public class MainPresenter implements Contract.Presenter{

    static String thisName = "MainPresenter";

    Contract.View view;
    MainModel mainmodel;

    //생성자
    public MainPresenter(Contract.View view){
        Log.d(thisName,"생성자 호출");
        this.view = view;
        mainmodel = new MainModel(this);
    }

    //implement 구현
    @Override
    public void addNum(int num1, int num2) {
        Log.d(thisName,"addNum() 실행");
        view.showResult(num1 + num2);
    }
}
