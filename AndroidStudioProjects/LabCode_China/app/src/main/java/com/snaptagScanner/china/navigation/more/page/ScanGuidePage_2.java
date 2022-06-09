package com.snaptagScanner.china.navigation.more.page;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.snaptagScanner.china.R;

public class ScanGuidePage_2 extends Fragment {

    public ScanGuidePage_2() {
        // Required empty public constructor
    }

    public static ScanGuidePage_2 newInstance(String param1, String param2) {
        ScanGuidePage_2 fragment = new ScanGuidePage_2();
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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_scan_guide_page_2, container, false);
    }
}