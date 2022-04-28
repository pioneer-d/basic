package com.snaptag.labcode_china.main.presenter;

import android.content.Context;
import com.snaptag.labcode_china.R;
import com.snaptag.labcode_china.main.model.MainModel;
import com.snaptag.labcode_china.network.NetworkConfirm;

public class MainPresenter implements MainContract.Presenter {

    MainModel model;
    MainContract.View view;
    NetworkConfirm confirm = NetworkConfirm.getInstance();

    public MainPresenter(MainContract.View view){
        this.view = view;
        model = new MainModel(this);
    }

    @Override
    public void controlNavigation(int item, Context context) {
        if (confirm.confirmNetwork(context)){
            switch (item){
                case R.id.page_scan : view.callScan(); break;
                case R.id.page_list : view.callList(); break;
                case R.id.page_more : view.callMore(); break;
            }
        } else {
            view.networkError();
        }
    }


}
