package com.snaptag.labcode_china.navigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.snaptag.labcode_china.R;
import com.snaptag.labcode_china.navigation.list.presenter.ListContract;
import com.snaptag.labcode_china.navigation.list.view.ListBlankFragment;
import com.snaptag.labcode_china.navigation.more.presenter.MoreContract;
import com.snaptag.labcode_china.navigation.more.view.MoreFragment;
import com.snaptag.labcode_china.navigation.scan.presenter.ScanContract;
import com.snaptag.labcode_china.navigation.scan.view.ScanFragment;


public class MainActivity extends AppCompatActivity implements ScanContract.View, ListContract.View, MoreContract.View {

    ScanContract.Presenter scanPresenter;
    ListContract.Presenter listPresenter;
    MoreContract.Presenter morePresenter;

    private FrameLayout frameLayout;
    private BottomNavigationView bottomNavigationView;
    private Fragment  scanFragment, listBlankFragment, moreFragment;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init(){
        /*
        this.scanPresenter = new ScanPresenter(this);
        this.listPresenter = new ListPresenter(this);
        this.morePresenter = new MorePresenter(this);
         */

        //-> 이건 예시로 해놓은 것. 이것들 각각 MVP로 넘기고 Presenter간의 통신으로 만들기.
        // -> 여기부터 나머지 설계 어떻게 할건지 구상해보기.
        scanFragment = new ScanFragment();
        listBlankFragment = new ListBlankFragment();
        moreFragment = new MoreFragment();

        textView = (TextView) findViewById(R.id.topTitle);
        frameLayout = findViewById(R.id.main_content);
        bottomNavigationView = findViewById(R.id.bottom_nav);

        getSupportFragmentManager().beginTransaction().replace(R.id.main_content, scanFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @SuppressLint("ResourceType")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.page_scan:getSupportFragmentManager().beginTransaction().replace(R.id.main_content, scanFragment).commit();
                                        textView.setText("");
                                        break;
                    case R.id.page_list:getSupportFragmentManager().beginTransaction().replace(R.id.main_content, listBlankFragment).commit();
                                        textView.setText("인증내역");
                                        break;
                    case R.id.page_more:getSupportFragmentManager().beginTransaction().replace(R.id.main_content, moreFragment).commit();
                                        textView.setText("더보기");
                                        break;
                }

                return true;
            }
        });
    };
}