package com.snaptag.labcode_china.main.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.snaptag.labcode_china.R;
import com.snaptag.labcode_china.navigation.list.ListFragment;
import com.snaptag.labcode_china.navigation.more.MoreFragment;
import com.snaptag.labcode_china.navigation.scan.ScanFragment;

public class MainActivity extends AppCompatActivity {

    private FrameLayout frameLayout;
    private BottomNavigationView bottomNavigationView;
    private Fragment  scanFragment, listFragment, moreFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init(){
        scanFragment = new ScanFragment();
        listFragment = new ListFragment();
        moreFragment = new MoreFragment();

        frameLayout = findViewById(R.id.main_content);
        bottomNavigationView = findViewById(R.id.bottom_nav);

        getSupportFragmentManager().beginTransaction().replace(R.id.main_content, scanFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.page_scan:getSupportFragmentManager().beginTransaction().replace(R.id.main_content, scanFragment).commit();
                        break;
                    case R.id.page_list:getSupportFragmentManager().beginTransaction().replace(R.id.main_content, listFragment).commit();
                        break;
                    case R.id.page_more:getSupportFragmentManager().beginTransaction().replace(R.id.main_content, moreFragment).commit();
                        break;
                }

                return true;
            }
        });
    };
}