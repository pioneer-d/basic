package com.snaptag.labcode_china.navigation.more.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.snaptag.labcode_china.R;
import com.snaptag.labcode_china.navigation.more.baseAdapter.ListBaseAdapter;
import com.snaptag.labcode_china.navigation.more.data.ItemData;
import com.snaptag.labcode_china.navigation.more.presenter.MoreContract;
import com.snaptag.labcode_china.navigation.more.presenter.MorePresenter;


public class MoreControlFragment extends Fragment implements MoreContract.View {

    private MoreContract.Presenter presenter;
    private ListBaseAdapter adapter;

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
            init();
        }
    }

    private void init(){ presenter.controlView(); }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View thisView = inflater.inflate(R.layout.fragment_control_more, container, false);

        //String[] value = new String[] {"자주 묻는 질문","이용약관","스캔가이드","앱 정보"};
        ListView listView = (ListView) thisView.findViewById(R.id.item_list);
        adapter = new ListBaseAdapter();

        adapter.addItem(new ItemData("자주 묻는 질문",R.drawable.ic_arrow));
        adapter.addItem(new ItemData("이용약관",R.drawable.ic_arrow));
        adapter.addItem(new ItemData("스캔가이드",R.drawable.ic_arrow));
        adapter.addItem(new ItemData("앱 정보","0.0.0"));   //이부분은 Model에서 뽑아오면 될 듯.

        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_expandable_list_item_1, value);
        listView.setAdapter(adapter);

        return thisView;

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