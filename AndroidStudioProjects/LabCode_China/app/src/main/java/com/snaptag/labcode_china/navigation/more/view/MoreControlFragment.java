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
import com.snaptag.labcode_china.navigation.more.page.PersonalInfoActivity;
import com.snaptag.labcode_china.navigation.more.page.ScanGuideActivity;
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
    MoreItemData frequentQuestion, termOfService, personalInfo, scanGuide, customerService, appVersion;

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
        personalInfo = new MoreItemData(R.string.txt_personal_info,R.drawable.ic_arrow);
        scanGuide = new MoreItemData(R.string.txt_scanGuide_title,R.drawable.ic_arrow);
        customerService = new MoreItemData(R.string.txt_customer_service,R.drawable.ic_arrow);
        appVersion = new MoreItemData(R.string.txt_app_version_title,thisVersion);


        adapter.addItem(frequentQuestion);
        adapter.addItem(termOfService);
        adapter.addItem(personalInfo);
        adapter.addItem(scanGuide);
        adapter.addItem(customerService);
        adapter.addItem(appVersion);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Object item = adapterView.getItemAtPosition(position);
                Log.d(thisName,"Click Item : "+item);

                if (item == frequentQuestion){ goFrequentQuestion(); }
                else if (item == termOfService){ goTos(); }
                else if (item == personalInfo){ goPersonal(); }
                else if (item == scanGuide){ goScanGuide(); }
                else if (item == customerService){ goCustomer(); }
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
        Intent intent = new Intent(getActivity(), FrequentQuestionActivity.class);
        startActivity(intent);

    }

    @Override
    public void goTos() {
        Intent intent = new Intent(getActivity(), TermOfServiceActivity.class);
        startActivity(intent);
    }

    @Override
    public void goPersonal() {
        Intent intent = new Intent(getActivity(), PersonalInfoActivity.class);
        startActivity(intent);
    }

    @Override
    public void goScanGuide() {
        Intent intent = new Intent(getActivity(), ScanGuideActivity.class);
        startActivity(intent);
    }

    @Override
    public void goCustomer(){

    }


}