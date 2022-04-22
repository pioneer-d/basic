package com.snaptag.labcode_china.navigation.scan.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.snaptag.labcode_china.R;


public class ScanControlFragment extends Fragment {

    private static ScanControlFragment instance;
    private ScanControlFragment() {
    }

    public static ScanControlFragment newInstance() {
        if(instance == null){
            instance = new ScanControlFragment();
        }
        Bundle args = new Bundle();

        instance.setArguments(args);
        return instance;
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
        return inflater.inflate(R.layout.fragment_control_scan, container, false);
    }
}