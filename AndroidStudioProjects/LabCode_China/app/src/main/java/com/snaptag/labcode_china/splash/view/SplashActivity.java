package com.snaptag.labcode_china.splash.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

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
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.txt_network_error);
        builder.setMessage(R.string.txt_network_try_again);
        builder.setCancelable(false);
        builder.setPositiveButton(R.string.txt_agree, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                init();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

}