package com.snaptag.labcode_china.navigation.more.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.snaptag.labcode_china.R;
import com.snaptag.labcode_china.navigation.more.presenter.MoreContract;
import com.snaptag.labcode_china.navigation.more.presenter.MorePresenter;


public class MoreControlFragment extends Fragment implements MoreContract.View {

    private MoreContract.Presenter presenter;

    private static MoreControlFragment instance;
    private MoreControlFragment() {}

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
            presenter = new MorePresenter(this);
            presenter.controlInfo();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View thisView = inflater.inflate(R.layout.fragment_control_more, container, false);

        String[] value = new String[] {"자주 묻는 질문","이용약관","스캔가이드","앱 정보"};
        ListView listView = (ListView) thisView.findViewById(R.id.item_list);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_expandable_list_item_1, value);
        listView.setAdapter(adapter);

        return thisView;



        // -> list만들고, go method처리 하면 될듯
    }

    @Override
    public void goFrequentQuestion() {

    }

    @Override
    public void goTos() {

    }

    @Override
    public void goScanGuide() {

    }
}