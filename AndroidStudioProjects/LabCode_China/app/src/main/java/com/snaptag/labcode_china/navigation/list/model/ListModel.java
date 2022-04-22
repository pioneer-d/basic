package com.snaptag.labcode_china.navigation.list.model;

import com.snaptag.labcode_china.navigation.list.presenter.ListContract;

public class ListModel {

    ListContract.Presenter presenter;

    public ListModel(ListContract.Presenter presenter){
        this.presenter = presenter;
    }


    //실제 적용시 JSON이나 Map으로 반환하고, Presenter에서 null로 체크해야할 듯.
    public boolean getList(){
        boolean list = false;

        // 인증내역 가져오는 부분.

        return list;
    }

}
