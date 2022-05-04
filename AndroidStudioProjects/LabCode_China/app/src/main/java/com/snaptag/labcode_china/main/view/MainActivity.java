package com.snaptag.labcode_china.main.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.snaptag.labcode_china.R;
import com.snaptag.labcode_china.main.presenter.MainContract;
import com.snaptag.labcode_china.main.presenter.MainPresenter;
import com.snaptag.labcode_china.navigation.more.view.MoreControlFragment;
import com.snaptag.labcode_china.navigation.scan.view.ScanControlFragment;
import com.snaptag.labcode_china.navigation.list.view.ListControlFragment;
import com.snaptag.labcode_china.navigation.scan.view.ScanControlFragment_Test;


public class MainActivity extends AppCompatActivity implements MainContract.View {


    private Fragment scanControlFragment, listControlFragment, moreControlFragment;
    private MainContract.Presenter presenter;

    private FrameLayout frameLayout;
    private BottomNavigationView bottomNavigationView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {

        presenter = new MainPresenter(this);

        //scanControlFragment = ScanControlFragment.newInstance();
        scanControlFragment = ScanControlFragment_Test.newInstance();
        listControlFragment = ListControlFragment.newInstance();
        moreControlFragment = MoreControlFragment.newInstance();

        textView = findViewById(R.id.topTitle);
        frameLayout = findViewById(R.id.main_content);      //fragment 변경될 공간
        bottomNavigationView = findViewById(R.id.bottom_nav);

        getSupportFragmentManager().beginTransaction().replace(R.id.main_content, scanControlFragment).commit();    //최초 fragment

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

    @Override
    public void callScan() {
        getSupportFragmentManager().beginTransaction().replace(R.id.main_content, scanControlFragment).commit();
        textView.setText("");
    }

    @Override
    public void callList() {
        getSupportFragmentManager().beginTransaction().replace(R.id.main_content, listControlFragment).commit();
        textView.setText("인증내역");
    }

    @Override
    public void callMore() {
        getSupportFragmentManager().beginTransaction().replace(R.id.main_content, moreControlFragment).commit();
        textView.setText("더보기");
    }
}