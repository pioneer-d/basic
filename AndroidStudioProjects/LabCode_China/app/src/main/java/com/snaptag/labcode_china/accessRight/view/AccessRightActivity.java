package com.snaptag.labcode_china.accessRight.view;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.snaptag.labcode_china.R;
import com.snaptag.labcode_china.accessRight.presenter.AccessRightContract;

public class AccessRightActivity extends AppCompatActivity implements AccessRightContract.View {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_access_right);

    }

    @Override
    public void alertCheckRight() {

    }

    @Override
    public void notAllowed() {

    }

    @Override
    public void goMain() {

    }
}