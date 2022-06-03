package com.snaptag.labcode_china.splash.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.snaptag.labcode_china.R;
import com.snaptag.labcode_china.accessRight.view.AccessRightActivity;
import com.snaptag.labcode_china.main.view.MainActivity;
import com.snaptag.labcode_china.network.GetLocation;
import com.snaptag.labcode_china.splash.presenter.SplashContract;
import com.snaptag.labcode_china.splash.presenter.SplashPresenter;

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