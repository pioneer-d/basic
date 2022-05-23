package com.snaptag.labcode_china.navigation.more.baseAdapter;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.snaptag.labcode_china.navigation.more.page.ScanGuidePage_1;
import com.snaptag.labcode_china.navigation.more.page.ScanGuidePage_2;
import com.snaptag.labcode_china.navigation.more.page.ScanGuidePage_3;

public class ScreeSlidePagerAdapter extends FragmentStateAdapter {

    static String thisName = "ScreeSlidePagerAdapter";
    static int screenPage = 3;

    public ScreeSlidePagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
        Log.d(thisName,"ScreeSlidePagerAdapter() 생성자 호출");
    }

    public ScreeSlidePagerAdapter(@NonNull Fragment fragment) {
        super(fragment);
        Log.d(thisName,"ScreeSlidePagerAdapter() 생성자 호출");
    }

    public ScreeSlidePagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        Log.d(thisName,"ScreeSlidePagerAdapter() 생성자 호출");
    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Log.d(thisName,"createFragment() position : "+String.valueOf(position));

        switch (position){
            default :
            case 0 : return new ScanGuidePage_1();
            case 1 : return new ScanGuidePage_2();
            case 2 : return new ScanGuidePage_3();

        }
    }

    @Override
    public int getItemCount() {
        return screenPage;
    }
}
