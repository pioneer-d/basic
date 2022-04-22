package com.snaptag.labcode_china.navigation.list.model;

import com.snaptag.labcode_china.navigation.list.presenter.ListContract;

public class ListModel {

    ListContract.Presenter presenter;

    public ListModel(ListContract.Presenter presenter){
        this.presenter = presenter;
    }

    public boolean getList(){
        boolean list = false;

        // 인증내역 가져오는 부분.

        return list;
    }

}
