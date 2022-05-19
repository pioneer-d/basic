package com.snaptag.labcode_china.navigation.more.baseAdapter;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.snaptag.labcode_china.navigation.more.frg.ScanGuidePage_1;
import com.snaptag.labcode_china.navigation.more.frg.ScanGuidePage_2;
import com.snaptag.labcode_china.navigation.more.frg.ScanGuidePage_3;

public class ScreeSlidePagerAdapter extends FragmentStateAdapter {

    static String thisName = "ScreeSlidePagerAdapter";

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
        if (position == 0) {
            Log.d(thisName,"position == 0인 경우");
            return new ScanGuidePage_1();}
        else if (position == 1) {return new ScanGuidePage_2();}
        else return new ScanGuidePage_3();
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
