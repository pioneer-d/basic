package com.snaptag.labcode_china.navigation.list.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.snaptag.labcode_china.R;
import com.snaptag.labcode_china.navigation.list.presenter.ListContract;


public class ListFragment extends Fragment implements ListContract.View {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";



    public ListFragment() {
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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void showList() {
        // -> Menu 생성
    }

    @Override
    public void showBlank() {
        // -> 제품 없음
    }

    @Override
    public void showDetail() {
        // -> Menu 생성 및 item ClickListener
    }
}