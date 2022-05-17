package com.snaptag.labcode_china.navigation.scan.frg;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.snaptag.labcode_china.R;


public class AlertTimeFragment extends Fragment{

    View view;
    ImageButton imageButton;
    Fragment scanControlFragment;

    public AlertTimeFragment(Fragment fragment) {
        scanControlFragment = fragment;
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
        view = inflater.inflate(R.layout.fragment_alert_time, container, false);
        imageButton = view.findViewById(R.id.backScanButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scanControlFragment.onResume();
                getParentFragmentManager().beginTransaction().remove(AlertTimeFragment.this).commit();

            }
        });
        return view;
    }


}