package com.snaptagScanner.china.main.presenter;

import android.content.Context;
import com.snaptagScanner.china.R;
import com.snaptagScanner.china.main.model.MainModel;
import com.snaptagScanner.china.network.NetworkConfirm;

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
        //여기서 ScanControlFragment에서 했던 setLocation 코루틴 활용해야 할 듯.
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
