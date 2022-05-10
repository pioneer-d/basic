package com.snaptag.labcode_china.navigation.more.frg;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.snaptag.labcode_china.R;
import com.snaptag.labcode_china.navigation.more.view.MoreControlFragment;


public class FrequentQuestionFragment extends Fragment implements View.OnClickListener {

    ImageButton backButton;
    View view;

    public FrequentQuestionFragment() {
        // Required empty public constructor
    }


    public static FrequentQuestionFragment newInstance(String param1, String param2) {
        FrequentQuestionFragment fragment = new FrequentQuestionFragment();
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
        view = inflater.inflate(R.layout.fragment_frequent_question, container, false);
        backButton = view.findViewById(R.id.backButton);
        backButton.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        int getId = view.getId();
        switch (getId){
            case R.id.backButton : getParentFragmentManager().beginTransaction().remove(FrequentQuestionFragment.this).commit();
            break;

        }
    }
}