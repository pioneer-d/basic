package com.snaptagScanner.china.splash.view;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.snaptagScanner.china.R;
import com.snaptagScanner.china.accessRight.view.AccessRightActivity;
import com.snaptagScanner.china.splash.presenter.SplashContract;
import com.snaptagScanner.china.splash.presenter.SplashPresenter;

public class SplashActivity extends AppCompatActivity implements SplashContract.View{

    static String thisName = "SplashActivity";
    SplashContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        presenter = new SplashPresenter(this,this);

        init();
    }

    private void init(){
        presenter.splashHandler(1,SplashActivity.this);
    }

    @Override
    public void goCameraAccessRight() {
        Intent intent = new Intent(getApplicationContext(), AccessRightActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void networkError() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_network_alert);
        dialog.setCancelable(false);

        TextView agree = dialog.findViewById(R.id.alert_tv_button);
        dialog.show();
        agree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                init();
            }
        });

    }

}