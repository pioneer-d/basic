package com.snaptag.labcode_china.navigation.more.frg;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.snaptag.labcode_china.R;


public class TermOfServiceFragment extends Fragment {

    public TermOfServiceFragment() {
        // Required empty public constructor
    }


    public static TermOfServiceFragment newInstance(String param1, String param2) {
        TermOfServiceFragment fragment = new TermOfServiceFragment();
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

        return inflater.inflate(R.layout.fragment_term_of_service, container, false);
    }
}