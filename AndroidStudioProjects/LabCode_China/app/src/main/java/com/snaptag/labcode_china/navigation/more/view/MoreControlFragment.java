package com.snaptag.labcode_china.navigation.more.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.snaptag.labcode_china.R;


public class MoreControlFragment extends Fragment {

    private static MoreControlFragment instance;
    private MoreControlFragment() {}

//    public static MoreFragment getInstance(){
//        return LazyHolder.INSTANCE;
//    }
//
//    private static class LazyHolder{
//        private static final MoreFragment INSTANCE = new MoreFragment();
//    }

    public static MoreControlFragment newInstance() {
        if(instance == null){
            instance = new MoreControlFragment();
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
        return inflater.inflate(R.layout.fragment_control_more, container, false);
    }
}