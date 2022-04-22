package com.snaptag.labcode_china.splash.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.snaptag.labcode_china.R;
import com.snaptag.labcode_china.accessRight.view.AccessRightActivity;
import com.snaptag.labcode_china.splash.presenter.SplashContract;
import com.snaptag.labcode_china.splash.presenter.SplashPresenter;

public class SplashActivity extends AppCompatActivity implements SplashContract.View{

    SplashContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        presenter = new SplashPresenter(this);
        init();
    }

    private void init(){
        presenter.splashHandler(1,SplashActivity.this);
    }

    @Override
    public void checkCameraRight() {
        Intent intent = new Intent(getApplicationContext(), AccessRightActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void networkError() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("네트워크 연결 오류");
        builder.setMessage("네트워크 연결이 원활하지 않습니다. \n 연결상태를 확인하고 다시 시도해주세요");
        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
                //onDestroy();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}