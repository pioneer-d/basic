package com.snaptag.labcode_china.main.view;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.snaptag.labcode_china.R;
import com.snaptag.labcode_china.main.presenter.MainContract;
import com.snaptag.labcode_china.main.presenter.MainPresenter;
import com.snaptag.labcode_china.navigation.more.view.MoreControlFragment;
import com.snaptag.labcode_china.navigation.list.view.ListControlFragment;
import com.snaptag.labcode_china.navigation.scan.page.ScanSuccessActivity;
import com.snaptag.labcode_china.navigation.scan.view.ScanControlFragment;


public class MainActivity extends AppCompatActivity implements MainContract.View {

    static String thisName = "MainActivity";

    private Fragment scanControlFragment, listControlFragment, moreControlFragment;
    private MainContract.Presenter presenter;
    private ScanSuccessActivity scanSuccessActivity;

    private FrameLayout frameLayout;
    private BottomNavigationView bottomNavigationView;
    private TextView textView;

    private String fragmentFlag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(thisName,"onCreate() 실행");

        Intent intent = getIntent(); //이 액티비티를 부른 인텐트를 받는다.
        fragmentFlag = intent.getStringExtra("FRAGMENT_FLAG");
        if (fragmentFlag == null){
            fragmentFlag = "callScan";
        }

        init();
    }

    private void init() {

        Log.d(thisName,"init() 실행");

        presenter = new MainPresenter(this);

        scanControlFragment = ScanControlFragment.newInstance();
        listControlFragment = ListControlFragment.newInstance();
        moreControlFragment = MoreControlFragment.newInstance();

        textView = findViewById(R.id.topTitle);
        frameLayout = findViewById(R.id.main_content);      //fragment 변경될 공간
        bottomNavigationView = findViewById(R.id.bottom_nav);

        if (fragmentFlag.equals("callScan")){
            Log.d(thisName,"init() 내부 fragmentFlag가 scan일 경우");
            callScan();
        } else if (fragmentFlag.equals("callList")){
            callList();
        }else if (fragmentFlag.equals("callMore")){
            callMore();
        }

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                presenter.controlNavigation(item.getItemId(),MainActivity.this);
                return true;
            }
        });
    }

    @Override
    public void networkError() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.txt_network_error);
        builder.setMessage(R.string.txt_network_try_again);
        builder.setPositiveButton(R.string.txt_agree, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public void callScan() {
        getSupportFragmentManager().beginTransaction().replace(R.id.main_content, scanControlFragment).commit();
        textView.setText("");
    }

    @Override
    public void callList() {
        getSupportFragmentManager().beginTransaction().replace(R.id.main_content, listControlFragment).commit();
        textView.setText(R.string.txt_list);
    }

    @Override
    public void callMore() {
        getSupportFragmentManager().beginTransaction().replace(R.id.main_content, moreControlFragment).commit();
        textView.setText(R.string.txt_more);
    }

//    public void goScanSuccess(String image, String genre, String product, String brand, String url){
//        Intent intent = new Intent(getApplicationContext(), ScanSuccessActivity.class);
//        startActivity(intent);
//    }


}