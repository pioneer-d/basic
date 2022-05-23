package com.snaptag.labcode_china.navigation.more.page;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.snaptag.labcode_china.R;


public class ScanGuidePage_1 extends Fragment {

    static String thisName = "ScanGuidePage_1";
    TextView test;
    View view;

    public ScanGuidePage_1() {
        Log.d(thisName,"ScanGuidePage_1 생성자 호출 ");
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
        view = inflater.inflate(R.layout.fragment_scan_guide_page_1, container, false);
        test = view.findViewById(R.id.testText);
        test.setText("test");

        return view;
    }
}