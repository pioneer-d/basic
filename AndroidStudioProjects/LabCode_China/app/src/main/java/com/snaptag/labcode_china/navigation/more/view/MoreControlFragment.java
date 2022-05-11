package com.snaptag.labcode_china.navigation.more.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.snaptag.labcode_china.R;
import com.snaptag.labcode_china.navigation.more.baseAdapter.MoreBaseAdapter;
import com.snaptag.labcode_china.navigation.more.data.MoreItemData;
import com.snaptag.labcode_china.navigation.more.frg.FrequentQuestionFragment;
import com.snaptag.labcode_china.navigation.more.frg.TermOfServiceFragment;
import com.snaptag.labcode_china.navigation.more.presenter.MoreContract;
import com.snaptag.labcode_china.navigation.more.presenter.MorePresenter;


public class MoreControlFragment extends Fragment implements MoreContract.View {

    private static String thisName = "MoreControlFragment";
    private MoreContract.Presenter presenter;
    private MoreBaseAdapter adapter;
    View view;

    Fragment frequentQuestionFragment, tosFragment, scanGuideFragment;
    MoreItemData frequentQuestion, termOfService, scanGuide, appVersion;

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

        view = inflater.inflate(R.layout.fragment_control_more, container, false);

        ListView listView = (ListView) view.findViewById(R.id.item_list);
        adapter = new MoreBaseAdapter();

        frequentQuestion = new MoreItemData("자주 묻는 질문",R.drawable.ic_arrow);
        termOfService = new MoreItemData("이용약관",R.drawable.ic_arrow);
        scanGuide = new MoreItemData("스캔가이드",R.drawable.ic_arrow);
        appVersion = new MoreItemData("앱 정보","0.0.0");

        adapter.addItem(frequentQuestion);
        adapter.addItem(termOfService);
        adapter.addItem(scanGuide);
        adapter.addItem(appVersion);   //이부분은 Model에서 뽑아오면 될 듯.

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Object item = adapterView.getItemAtPosition(position);
                Log.d(thisName,"Click Item : "+item);

                if (item == frequentQuestion){
                    Log.d(thisName,"goFrequentQuestion()");
                    goFrequentQuestion();
                } else if (item == termOfService){
                    Log.d(thisName,"goTos()");
                    goTos();
                } else if (item == scanGuide){
                    Log.d(thisName,"goScanGuide()");
                    goScanGuide();
                }


            }
        });

        return view;

    }

    @Override
    public void goFrequentQuestion() {
        frequentQuestionFragment = new FrequentQuestionFragment();
        getChildFragmentManager().beginTransaction().add(R.id.more_child_content,frequentQuestionFragment).commitAllowingStateLoss();


        if (tosFragment != null){ getChildFragmentManager().beginTransaction().hide(tosFragment).commit(); }
    }

    //-> a에서 b를 생성하니까 a Fragment가 눌림! 이부분 해결해야함.
    //hide, show, add, commit 테스트 해보고, 생명주기 로깅.

    @Override
    public void goTos() {
        tosFragment = new TermOfServiceFragment();
        getChildFragmentManager().beginTransaction().add(R.id.more_child_content,tosFragment).commitAllowingStateLoss();

    }

    @Override
    public void goScanGuide() {
        //scanGuide
    }

    public void manageChildFragment(Fragment main, Fragment sub1, Fragment sub2){
        if (main != null) {getChildFragmentManager().beginTransaction().show(main).commit();}
        if (sub1 != null) {getChildFragmentManager().beginTransaction().hide(sub1).commit();}
        if (sub2 != null) {getChildFragmentManager().beginTransaction().hide(sub2).commit();}
    }
}