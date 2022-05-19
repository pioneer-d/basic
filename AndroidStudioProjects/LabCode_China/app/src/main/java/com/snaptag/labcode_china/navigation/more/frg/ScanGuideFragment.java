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

public class ScanGuideFragment extends Fragment {

    static String thisName = "ScanGuideFragment";
    private ViewPager2 pager;
    private FragmentStateAdapter pagerAdapter;
    private ViewGroup viewGroup;

    ImageButton backButton;
    Fragment moreControlFragment;

    public ScanGuideFragment() {
        // Required empty public constructor
    }


    public static ScanGuideFragment newInstance(String param1, String param2) {
        ScanGuideFragment fragment = new ScanGuideFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
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

        backButton = viewGroup.findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getParentFragmentManager().beginTransaction().remove(ScanGuideFragment.this).commit();
                moreControlFragment = MoreControlFragment.newInstance();
                getParentFragmentManager().beginTransaction().show(moreControlFragment).commit();
            }
        });

        pager = viewGroup.findViewById(R.id.sliderViewPager);

        pagerAdapter = new ScreeSlidePagerAdapter(getActivity());
        pager.setAdapter(pagerAdapter);
        pager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        pager.setCurrentItem(0);

        return viewGroup;
    }
}