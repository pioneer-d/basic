package com.snaptag.labcode_china.navigation.more.frg;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageButton;

import com.snaptag.labcode_china.R;
import com.snaptag.labcode_china.navigation.more.baseAdapter.FrequentQuestionAdapter;
import com.snaptag.labcode_china.navigation.more.view.MoreControlFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FrequentQuestionFragment extends Fragment implements View.OnClickListener {

    static String thisName = "FrequentQuestionFragment";
    ImageButton backButton, allButton, howToUseButton, techButton;
    View view;
    Fragment moreControlFragment;
    ExpandableListView expandableListView;

    Animation rotate_button;
    Animation slide_down;

    private FrequentQuestionAdapter adapter;


    private List<String> mGroup = new ArrayList<String>();
    private Map<String, List<Integer>> mChild = new HashMap<>();



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

        expandableListView = (ExpandableListView) view.findViewById(R.id.question_list);
        backButton = view.findViewById(R.id.backButton);
        allButton = view.findViewById(R.id.allQuestion);
        howToUseButton = view.findViewById(R.id.howToUseQuestion);
        techButton = view.findViewById(R.id.techQuestion);
        rotate_button = AnimationUtils.loadAnimation(getContext(),R.anim.rotation_arrow);
        slide_down = AnimationUtils.loadAnimation(getContext(),R.anim.slide_down);

        init();
        initView();

        backButton.setOnClickListener(this);
        allButton.setOnClickListener(this);
        howToUseButton.setOnClickListener(this);
        techButton.setOnClickListener(this);

        return view;
    }

    private void init(){

        mGroup.clear();
        mChild.clear();

        mGroup.add( "LABCODE 사용법은 어떻게 되나요?" );
        mGroup.add( "정품 여부를 어떻게 확인할 수 있나요?" );
        mGroup.add( "LABCODE를 적용은 어떻게 하나요?" );
        mGroup.add( "LABCODE는 어떤 서비스인가요?" );
        mGroup.add( "LACODE는 무엇인가요?" );

        List<Integer> use1 = new ArrayList<Integer>();
        use1.add( R.string.txt_frequent_use1 );
        mChild.put( "LABCODE 사용법은 어떻게 되나요?", use1 );

        List<Integer> use2 = new ArrayList<Integer>();
        use2.add( R.string.txt_frequent_use2 );
        mChild.put( "정품 여부를 어떻게 확인할 수 있나요?", use2 );

        List<Integer> use3 = new ArrayList<Integer>();
        use3.add( R.string.txt_frequent_use3 );
        mChild.put( "LABCODE를 적용은 어떻게 하나요?", use3 );

        List<Integer> tech1 = new ArrayList<Integer>();
        tech1.add( R.string.txt_frequent_tech1 );
        mChild.put( "LABCODE는 어떤 서비스인가요?", tech1 );

        List<Integer> tech2 = new ArrayList<Integer>();
        tech2.add( R.string.txt_frequent_tech2 );
        mChild.put( "LACODE는 무엇인가요?", tech2 );

    }

    private void showUse(){

        mGroup.clear();
        mChild.clear();

        mGroup.add( "LABCODE 사용법은 어떻게 되나요?" );
        mGroup.add( "정품 여부를 어떻게 확인할 수 있나요?" );
        mGroup.add( "LABCODE를 적용은 어떻게 하나요?" );

        List<Integer> use1 = new ArrayList<Integer>();
        use1.add( R.string.txt_frequent_use1 );
        mChild.put( "LABCODE 사용법은 어떻게 되나요?", use1 );

        List<Integer> use2 = new ArrayList<Integer>();
        use2.add( R.string.txt_frequent_use2 );
        mChild.put( "정품 여부를 어떻게 확인할 수 있나요?", use2 );

        List<Integer> use3 = new ArrayList<Integer>();
        use3.add( R.string.txt_frequent_use3 );
        mChild.put( "LABCODE를 적용은 어떻게 하나요?", use3 );

    }

    private void showTech(){

        mGroup.clear();
        mChild.clear();

        mGroup.add( "LABCODE는 어떤 서비스인가요?" );
        mGroup.add( "LACODE는 무엇인가요?" );

        List<Integer> tech1 = new ArrayList<Integer>();
        tech1.add( R.string.txt_frequent_tech1 );
        mChild.put( "LABCODE는 어떤 서비스인가요?", tech1 );

        List<Integer> tech2 = new ArrayList<Integer>();
        tech2.add( R.string.txt_frequent_tech2 );
        mChild.put( "LACODE는 무엇인가요?", tech2 );

    }

    private void initView(){

        ExpandableListAdapter adapter = new FrequentQuestionAdapter(getActivity(),mGroup,mChild);
        expandableListView.setIndicatorBounds(view.getWidth()+950,view.getWidth());
        expandableListView.setAdapter( adapter );
        expandableListView.setOnChildClickListener( new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                return false;
            }
        });

        expandableListView.setOnGroupClickListener( new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                return false;
            }
        });

        expandableListView.setOnGroupExpandListener( new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
            }
        });

        expandableListView.setOnGroupCollapseListener( new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
            }
        });
    }


    @Override
    public void onClick(View view) {
        int getId = view.getId();
        switch (getId){
            case R.id.backButton : getParentFragmentManager().beginTransaction().remove(FrequentQuestionFragment.this).commit();
                moreControlFragment = MoreControlFragment.newInstance();
                //remove 해야됨.
                getParentFragmentManager().beginTransaction().show(moreControlFragment).commit();
                break;
            case R.id.allQuestion:
                allButton.setImageResource(R.drawable.ic_more_all_click);
                howToUseButton.setImageResource(R.drawable.ic_more_use_non_click);
                techButton.setImageResource(R.drawable.ic_more_tech_non_click);
                init();
                initView();
                break;
            case R.id.howToUseQuestion:
                howToUseButton.setImageResource(R.drawable.ic_more_use_click);
                allButton.setImageResource(R.drawable.ic_more_all_non_click);
                techButton.setImageResource(R.drawable.ic_more_tech_non_click);
                showUse();
                initView();
                break;
            case R.id.techQuestion:
                techButton.setImageResource(R.drawable.ic_more_tech_click);
                allButton.setImageResource(R.drawable.ic_more_all_non_click);
                howToUseButton.setImageResource(R.drawable.ic_more_use_non_click);
                showTech();
                initView();
                break;
        }
    }



}