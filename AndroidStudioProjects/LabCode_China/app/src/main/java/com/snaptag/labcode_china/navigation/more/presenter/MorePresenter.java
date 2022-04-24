package com.snaptag.labcode_china.navigation.more.presenter;

import com.snaptag.labcode_china.navigation.more.model.MoreModel;

public class MorePresenter implements MoreContract.Presenter {

    MoreContract.View view;
    MoreModel model;

    public MorePresenter(MoreContract.View view){
        this.view = view;
        model = new MoreModel(this);

    }
    @Override
    public void controlInfo() {
        //-> 파라미터, 버튼 받아서 fragment이동 하면 될듯
    }
}
