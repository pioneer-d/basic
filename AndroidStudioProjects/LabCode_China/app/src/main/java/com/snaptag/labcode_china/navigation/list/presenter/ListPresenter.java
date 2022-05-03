package com.snaptag.labcode_china.navigation.list.presenter;


import com.snaptag.labcode_china.navigation.list.model.ListModel;

public class ListPresenter implements ListContract.Presenter{

    ListContract.View view;
    ListModel model;

    public ListPresenter(ListContract.View view){
        this.view = view;
        model = new ListModel(this);
    }


    @Override
    public void controlView() {
        model.getList();
    }
    @Override
    public void testView(){
        view.goList();
    }
    @Override
    public void testView2(){
        view.goBlank();
    }



}

