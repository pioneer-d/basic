package com.snaptag.labcode_china.navigation.more.view;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
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
import com.snaptag.labcode_china.navigation.more.page.FrequentQuestionActivity;
import com.snaptag.labcode_china.navigation.more.page.ScanGuideActivity;
import com.snaptag.labcode_china.navigation.more.page.ScanGuideFragment;
import com.snaptag.labcode_china.navigation.more.page.TermOfServiceActivity;
import com.snaptag.labcode_china.navigation.more.presenter.MoreContract;
import com.snaptag.labcode_china.navigation.more.presenter.MorePresenter;
import com.snaptag.labcode_china.navigation.scan.page.ScanSuccessActivity;


public class MoreControlFragment extends Fragment implements MoreContract.View {

    private static String thisName = "MoreControlFragment";
    private MoreContract.Presenter presenter;
    private MoreBaseAdapter adapter;
    View view;

    //app version
    String thisVersion;
    String latestVersion;

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

        getVersionInfo();

        view = inflater.inflate(R.layout.fragment_control_more, container, false);

        ListView listView = (ListView) view.findViewById(R.id.item_list);
        adapter = new MoreBaseAdapter();

        frequentQuestion = new MoreItemData(R.string.txt_frequent_quest_title,R.drawable.ic_arrow);
        termOfService = new MoreItemData(R.string.txt_tos_title,R.drawable.ic_arrow);
        scanGuide = new MoreItemData(R.string.txt_scanGuide_title,R.drawable.ic_arrow);
        appVersion = new MoreItemData(R.string.txt_app_version_title,thisVersion);

        adapter.addItem(frequentQuestion);
        adapter.addItem(termOfService);
        adapter.addItem(scanGuide);
        adapter.addItem(appVersion);

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

    public void getVersionInfo(){
        try {
            PackageInfo packageInfo = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 0);
            thisVersion = packageInfo.versionName + "";
        } catch(PackageManager.NameNotFoundException e) { }

    }

    @Override
    public void goFrequentQuestion() {
//        frequentQuestionFragment = new FrequentQuestionFragment();
//        manageChildFragment(frequentQuestionFragment,this);

        Intent intent = new Intent(getActivity(), FrequentQuestionActivity.class);
        startActivity(intent);

    }

    @Override
    public void goTos() {
//        tosFragment = new TermOfServiceFragment();
//        manageChildFragment(tosFragment,this);
        Intent intent = new Intent(getActivity(), TermOfServiceActivity.class);
        startActivity(intent);
    }

    @Override
    public void goScanGuide() {
//        scanGuideFragment = new ScanGuideFragment();
//        manageChildFragment(scanGuideFragment,this);
        Intent intent = new Intent(getActivity(), ScanGuideActivity.class);
        startActivity(intent);
    }

    public void manageChildFragment(Fragment main, Fragment sub){
        //getChildFragmentManager().beginTransaction().replace(R.id.main_content,main).addToBackStack(null).commit();
        if (main != null) {getParentFragmentManager().beginTransaction().add(R.id.main_content,main).show(main).commit();}
        if (sub != null) {
            getParentFragmentManager().beginTransaction().hide(sub).commit();
        }
    }


}