package com.snaptag.labcode_china.navigation.list.presenter;


import android.app.Activity;

import com.snaptag.labcode_china.navigation.list.model.ListModel;

public class ListPresenter implements ListContract.Presenter{

    ListContract.View view;
    ListModel model;
    Activity activity;

    public ListPresenter(ListContract.View view, Activity activity){
        this.view = view;
        this.activity = activity;
        model = new ListModel(this,activity);
    }


    @Override
    public void controlView() {
        model.getList();
    }
    @Override
    public void exist(){
        view.goList();
    }
    @Override
    public void notExist(){
        view.goBlank();
    }



}

