package com.snaptag.labcode_china.navigation.list.presenter;

import com.snaptag.labcode_china.navigation.list.model.ListModel;

public class ListPresenter implements ListContract.Presenter{

    ListModel model;
    ListContract.View view;

    public ListPresenter(ListContract.View view){
        this.view = view;
        model = new ListModel(this);
    }

    @Override
    public int getDate() {
        // model로부터 내장 DB에서 인증내역 불러와서 리스트 띄울 건데,
        return 0;
    }

    @Override
    public void controlFragment(int list) {
        int listNum;
        listNum = getDate();
        if(listNum == 0){
            view.showBlank();
        } else {
            view.showList();
        }
    }
}
