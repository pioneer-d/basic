package com.snaptag.labcode_china.navigation.list.view;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;



import com.snaptag.labcode_china.R;

import com.snaptag.labcode_china.navigation.list.fag.BlankFragment;
import com.snaptag.labcode_china.navigation.list.presenter.ListContract;
import com.snaptag.labcode_china.navigation.list.presenter.ListPresenter;


public class ListControlFragment extends Fragment implements ListContract.View {

    ListContract.Presenter presenter;

    //fragment 종류
    private Fragment blankFragment;

    private static ListControlFragment instance;
    private ListControlFragment() { }

    public static ListControlFragment newInstance(){
        if(instance == null){
            instance = new ListControlFragment();
        }
        Bundle args = new Bundle();

        instance.setArguments(args);
        return instance;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            presenter = new ListPresenter(this);
            init();

        }
    }


    private void init(){
        presenter.checkListData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_control_list, container, false);
    }

    @Override
    public void goBlank() {
        blankFragment = new BlankFragment();
        getChildFragmentManager().beginTransaction().replace(R.id.child_content,blankFragment).commit();
        //addToBackStack 고려해야함.
    }

    @Override
    public void goList() {
        //Bundle 통해서 값 넘겨주면 될듯.
    }

    @Override
    public void goDetail() {
        //Bundle 통해서 값 넘겨주면 될듯.
    }
}