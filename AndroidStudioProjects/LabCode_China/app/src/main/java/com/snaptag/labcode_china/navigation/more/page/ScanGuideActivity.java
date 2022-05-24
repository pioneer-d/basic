package com.snaptag.labcode_china.navigation.more.page;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.snaptag.labcode_china.R;
import com.snaptag.labcode_china.navigation.more.baseAdapter.ScreeSlidePagerAdapter;
import com.snaptag.labcode_china.navigation.more.view.MoreControlFragment;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

public class ScanGuideActivity extends AppCompatActivity {

    static String thisName = "ScanGuideFragment";
    private ViewPager2 pager;
    private FragmentStateAdapter pagerAdapter;
    private View view;
    DotsIndicator dotsIndicator;

    ImageButton backButton;
    Fragment moreControlFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = getLayoutInflater().from(this).inflate(R.layout.activity_scan_guide,null);
        setContentView(view);

        pager = (ViewPager2) view.findViewById(R.id.sliderViewPager);

        pagerAdapter = new ScreeSlidePagerAdapter(this);
        pager.setAdapter(pagerAdapter);
        pager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        pager.setCurrentItem(0);
        dotsIndicator = view.findViewById(R.id.dotIndicator);
        dotsIndicator.setViewPager2(pager);

        backButton = view.findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}