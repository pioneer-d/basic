package com.snaptag.labcode_china.navigation.more.page;

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

    int indicatorLocation;

    private List<Integer> mGroup = new ArrayList<Integer>();
    private Map<Integer, List<Integer>> mChild = new HashMap<>();

    int use_1 = R.string.txt_use_1;
    int use_2 = R.string.txt_use_2;
    int use_3 = R.string.txt_use_3;
    int tech_1 = R.string.txt_tech_1;
    int tech_2 = R.string.txt_tech_2;



    public FrequentQuestionFragment() {
        // Required empty public constructor
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
        indicatorLocation = view.getWidth()+950;

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

        mGroup.add(use_1);
        mGroup.add(use_2);
        mGroup.add(use_3);
        mGroup.add(tech_1);
        mGroup.add(tech_2);

        List<Integer> list_use1 = new ArrayList<Integer>();
        list_use1.add( R.string.txt_frequent_use1 );
        mChild.put( use_1, list_use1 );

        List<Integer> list_use2 = new ArrayList<Integer>();
        list_use2.add( R.string.txt_frequent_use2 );
        mChild.put( use_2, list_use2 );

        List<Integer> list_use3 = new ArrayList<Integer>();
        list_use3.add( R.string.txt_frequent_use3 );
        mChild.put( use_3, list_use3 );

        List<Integer> list_tech1 = new ArrayList<Integer>();
        list_tech1.add( R.string.txt_frequent_tech1 );
        mChild.put( tech_1, list_tech1 );

        List<Integer> list_tech2 = new ArrayList<Integer>();
        list_tech2.add( R.string.txt_frequent_tech2 );
        mChild.put( tech_2, list_tech2 );

    }

    private void showUse(){

        mGroup.clear();
        mChild.clear();

        mGroup.add(use_1);
        mGroup.add(use_2);
        mGroup.add(use_3);

        List<Integer> list_use1 = new ArrayList<Integer>();
        list_use1.add( R.string.txt_frequent_use1 );
        mChild.put( use_1, list_use1 );

        List<Integer> list_use2 = new ArrayList<Integer>();
        list_use2.add( R.string.txt_frequent_use2 );
        mChild.put( use_2, list_use2 );

        List<Integer> list_use3 = new ArrayList<Integer>();
        list_use3.add( R.string.txt_frequent_use3 );
        mChild.put( use_3, list_use3 );

    }

    private void showTech(){

        mGroup.clear();
        mChild.clear();

        mGroup.add(tech_1);
        mGroup.add(tech_2);

        List<Integer> list_tech1 = new ArrayList<Integer>();
        list_tech1.add( R.string.txt_frequent_tech1 );
        mChild.put( tech_1, list_tech1 );

        List<Integer> list_tech2 = new ArrayList<Integer>();
        list_tech2.add( R.string.txt_frequent_tech2 );
        mChild.put( tech_2, list_tech2 );

    }

    private void initView(){

        ExpandableListAdapter adapter = new FrequentQuestionAdapter(getActivity(),mGroup,mChild);
        expandableListView.setIndicatorBounds(indicatorLocation,view.getWidth());
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