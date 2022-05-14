package com.snaptag.labcode_china.navigation.more.frg;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

import com.snaptag.labcode_china.R;
import com.snaptag.labcode_china.navigation.more.baseAdapter.FrequentQuestionAdapter;
import com.snaptag.labcode_china.navigation.more.baseAdapter.MoreBaseAdapter;
import com.snaptag.labcode_china.navigation.more.data.QuestionData;
import com.snaptag.labcode_china.navigation.more.view.MoreControlFragment;


public class FrequentQuestionFragment extends Fragment implements View.OnClickListener {

    static String thisName = "FrequentQuestionFragment";
    ImageButton backButton, allButton, howToUseButton, techButton;
    View view;
    Fragment moreControlFragment;
    ListView listView;



    private FrequentQuestionAdapter adapter;
    QuestionData howToUse1, howToUse2, howToUse3, tech1, tech2;

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

        listView = (ListView) view.findViewById(R.id.question_list);
        backButton = view.findViewById(R.id.backButton);
        allButton = view.findViewById(R.id.allQuestion);
        howToUseButton = view.findViewById(R.id.howToUseQuestion);
        techButton = view.findViewById(R.id.techQuestion);


        adapter = new FrequentQuestionAdapter();
        howToUse1 = new QuestionData(R.drawable.ic_question_image, "LABCODE 사용법은 어떻게 되나요?", R.drawable.ic_bottomarrow);
        howToUse2 = new QuestionData(R.drawable.ic_question_image, "정품 여부를 어떻게 확인할 수 있나요?", R.drawable.ic_bottomarrow);
        howToUse3 = new QuestionData(R.drawable.ic_question_image, "LABCODE를 적용은 어떻게 하나요?", R.drawable.ic_bottomarrow);
        tech1 = new QuestionData(R.drawable.ic_question_image, "LABCODE는 어떤 서비스인가요?", R.drawable.ic_bottomarrow);
        tech2 = new QuestionData(R.drawable.ic_question_image, "LACODE는 무엇인가요?", R.drawable.ic_bottomarrow);

        adapter.addItem(howToUse1);
        adapter.addItem(howToUse2);
        adapter.addItem(howToUse3);
        adapter.addItem(tech1);
        adapter.addItem(tech2);

        listView.setAdapter(adapter);

        backButton.setOnClickListener(this);
        allButton.setOnClickListener(this);
        howToUseButton.setOnClickListener(this);
        techButton.setOnClickListener(this);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Object item = adapterView.getItemAtPosition(position);
                //howToUse1, howToUse2, howToUse3, tech1, tech2;

                if (item == howToUse1){
                    Log.d(thisName,"onItemClick() 내부 howToUse1 선택");
                    adapter.rotateArrow(howToUse1);
                }
            }
        });

        return view;
    }

    @Override
    public void onClick(View view) {
        int getId = view.getId();
        switch (getId){
            case R.id.backButton : getParentFragmentManager().beginTransaction().remove(FrequentQuestionFragment.this).commit();
                moreControlFragment = MoreControlFragment.newInstance();
                getParentFragmentManager().beginTransaction().show(moreControlFragment).commit();
                break;
            case R.id.allQuestion:
                allButton.setImageResource(R.drawable.ic_more_all_click);
                howToUseButton.setImageResource(R.drawable.ic_more_use_non_click);
                techButton.setImageResource(R.drawable.ic_more_tech_non_click);
                adapter.clearItem();
                adapter.addItem(howToUse1);
                adapter.addItem(howToUse2);
                adapter.addItem(howToUse3);
                adapter.addItem(tech1);
                adapter.addItem(tech2);
                adapter.notifyDataSetChanged();
                listView.setAdapter(adapter);
                break;
            case R.id.howToUseQuestion:
                howToUseButton.setImageResource(R.drawable.ic_more_use_click);
                allButton.setImageResource(R.drawable.ic_more_all_non_click);
                techButton.setImageResource(R.drawable.ic_more_tech_non_click);
                adapter.clearItem();
                adapter.addItem(howToUse1);
                adapter.addItem(howToUse2);
                adapter.addItem(howToUse3);
                adapter.notifyDataSetChanged();
                listView.setAdapter(adapter);
                break;
            case R.id.techQuestion:
                techButton.setImageResource(R.drawable.ic_more_tech_click);
                allButton.setImageResource(R.drawable.ic_more_all_non_click);
                howToUseButton.setImageResource(R.drawable.ic_more_use_non_click);
                adapter.clearItem();
                adapter.addItem(tech1);
                adapter.addItem(tech2);
                adapter.notifyDataSetChanged();
                listView.setAdapter(adapter);
                break;
        }
    }



}