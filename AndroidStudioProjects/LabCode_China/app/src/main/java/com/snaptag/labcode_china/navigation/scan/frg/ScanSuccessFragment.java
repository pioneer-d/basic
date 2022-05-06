package com.snaptag.labcode_china.navigation.scan.frg;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.snaptag.labcode_china.R;


public class ScanSuccessFragment extends Fragment {

    public ScanSuccessFragment() {
        // Required empty public constructor
    }


    public static ScanSuccessFragment newInstance(String param1, String param2) {
        ScanSuccessFragment fragment = new ScanSuccessFragment();
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
        return inflater.inflate(R.layout.fragment_scan_success, container, false);
    }
}