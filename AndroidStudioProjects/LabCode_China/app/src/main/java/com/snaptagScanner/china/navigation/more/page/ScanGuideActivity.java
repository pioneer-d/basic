package com.snaptagScanner.china.navigation.more.page;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.snaptagScanner.china.R;
import com.snaptagScanner.china.navigation.more.baseAdapter.ScreeSlidePagerAdapter;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

public class ScanGuideActivity extends AppCompatActivity {

    static String thisName = "ScanGuideFragment";
    private ViewPager2 pager;
    private FragmentStateAdapter pagerAdapter;
    private View view;
    private ImageButton scanGuideNext;
    private TextView scanGuideNextText;
    DotsIndicator dotsIndicator;

    ImageButton backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = getLayoutInflater().from(this).inflate(R.layout.activity_scan_guide,null);
        setContentView(view);

        pager = (ViewPager2) view.findViewById(R.id.sliderViewPager);
        scanGuideNext = view.findViewById(R.id.scan_guide_next);
        scanGuideNextText = view.findViewById(R.id.scan_guide_next_text);

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

        scanGuideNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int current = pager.getCurrentItem();
                if (current == 0) { pager.setCurrentItem(1,true); }
                else if (current == 1) { pager.setCurrentItem(2,true); }
                else if (current == 2) { onBackPressed(); }
            }
        });

        pager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                Log.d(thisName,"onPageSelected() 실행");
                if (position == 0) {scanGuideNextText.setText(R.string.txt_scan_guide_next_button);}
                else if (position == 1) {scanGuideNextText.setText(R.string.txt_scan_guide_next_button);}
                else if (position == 2) {scanGuideNextText.setText(R.string.txt_scan_guide_finish_button);}
            }
        });

    }

}