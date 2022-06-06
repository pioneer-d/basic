package com.snaptag.labcode_china.navigation.list.view;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.snaptag.labcode_china.R;
import com.snaptag.labcode_china.navigation.list.page.BlankFragment;
import com.snaptag.labcode_china.navigation.list.page.ListFragment;
import com.snaptag.labcode_china.navigation.list.presenter.ListContract;
import com.snaptag.labcode_china.navigation.list.presenter.ListPresenter;


public class ListControlFragment extends Fragment implements ListContract.View {

    static String thisName = "ListControlFragment";
    ListContract.Presenter presenter;
    View view;

    String image = "test1";
    String genre = "test2";
    String product = "test3";
    String brand = "test4";

    //fragment 종류
    private Fragment blankFragment;
    private Fragment listFragment;

    private static ListControlFragment instance;
    public ListControlFragment() {
        Log.d(thisName,"ListControlFragment() 기본 생성자");
    }

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
            presenter = new ListPresenter(this,this.getActivity());
            init();

        }
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(thisName,"onPause()");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(thisName,"onResume()");
    }

    private void init(){
        presenter.controlView();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_control_list, container, false);
    }

    @Override
    public void goBlank() {
        blankFragment = new BlankFragment();
        getChildFragmentManager().beginTransaction().replace(R.id.list_child_content,blankFragment).commit();
    }

    @Override
    public void goList() {
        listFragment = new ListFragment();

        Bundle bundle = new Bundle();
        listFragment.setArguments(bundle);

        getChildFragmentManager().beginTransaction().replace(R.id.list_child_content, listFragment).commit();

    }

    @Override
    public void goDetail() {
        //웹뷰 처리 해야됨.
    }
}