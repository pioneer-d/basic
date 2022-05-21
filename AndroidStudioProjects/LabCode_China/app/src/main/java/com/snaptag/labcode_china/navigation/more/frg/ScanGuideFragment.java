package com.snaptag.labcode_china.navigation.more.frg;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.snaptag.labcode_china.R;
import com.snaptag.labcode_china.navigation.more.baseAdapter.ScreeSlidePagerAdapter;
import com.snaptag.labcode_china.navigation.more.view.MoreControlFragment;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

public class ScanGuideFragment extends Fragment {

    static String thisName = "ScanGuideFragment";
    private ViewPager2 pager;
    private FragmentStateAdapter pagerAdapter;
    private ViewGroup viewGroup;
    DotsIndicator dotsIndicator;

    ImageButton backButton;
    Fragment moreControlFragment;

    public ScanGuideFragment() {
        Log.d(thisName, "ScanGuideFragment 생성자 호출");
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(thisName,"onCreateView() 실행");
        viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_scan_guide, container, false);

        pager = (ViewPager2) viewGroup.findViewById(R.id.sliderViewPager);
        //pagerAdapter = new ScreeSlidePagerAdapter(getActivity());
        //pagerAdapter = new ScreeSlidePagerAdapter(getChildFragmentManager(),getLifecycle());
        //pagerAdapter = new ScreeSlidePagerAdapter(getParentFragment());
        pagerAdapter = new ScreeSlidePagerAdapter(this);
        pager.setAdapter(pagerAdapter);
        pager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        pager.setCurrentItem(0);
        dotsIndicator = viewGroup.findViewById(R.id.dotIndicator);
        dotsIndicator.setViewPager2(pager);

        backButton = viewGroup.findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getParentFragmentManager().beginTransaction().remove(ScanGuideFragment.this).commit();
                moreControlFragment = MoreControlFragment.newInstance();
                getParentFragmentManager().beginTransaction().show(moreControlFragment).commit();
            }
        });

        return viewGroup;
    }
}