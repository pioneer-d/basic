package com.snaptag.labcode_china.splash.presenter;

import android.content.Context;
import android.os.Handler;
import com.snaptag.labcode_china.network.NetworkConfirm;
import com.snaptag.labcode_china.splash.model.SplashModel;

public class SplashPresenter implements SplashContract.Presenter {

    static String thisName = "SplashPresenter";
    NetworkConfirm confirm = NetworkConfirm.getInstance();

    SplashContract.View view;
    SplashModel model;

    public SplashPresenter(SplashContract.View view){
        this.view = view;
        model = new SplashModel(this);
    }

    @Override
    public void splashHandler(int sec, Context context) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (confirm.confirmNetwork(context)){
                    view.goCameraAccessRight();
                }
                else {
                    view.networkError();
                }
            }
        }, 1000 * sec);
    }



}
