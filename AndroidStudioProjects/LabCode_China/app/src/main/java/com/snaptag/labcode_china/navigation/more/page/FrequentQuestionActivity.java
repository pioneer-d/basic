package com.snaptag.labcode_china.navigation.more.page;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.TextView;

import com.snaptag.labcode_china.R;
import com.snaptag.labcode_china.navigation.more.baseAdapter.FrequentQuestionAdapter;
import com.snaptag.labcode_china.navigation.more.view.MoreControlFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequentQuestionActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton backButton, allButton, howToUseButton, techButton;
    TextView allText,useText, techText;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = getLayoutInflater().from(this).inflate(R.layout.activity_frequent_question,null);

        setContentView(view);

        indicatorLocation = view.getWidth()+950;

        expandableListView = (ExpandableListView) findViewById(R.id.question_list);
        expandableListView.setIndicatorBounds(indicatorLocation,view.getWidth());

        backButton = findViewById(R.id.backButton);

        allButton = findViewById(R.id.allQuestion);
        allText = findViewById(R.id.allQuestion_text);

        howToUseButton = findViewById(R.id.howToUseQuestion);
        useText = findViewById(R.id.howToUseQuestion_text);

        techButton = findViewById(R.id.techQuestion);
        techText = findViewById(R.id.techQuestion_text);
        rotate_button = AnimationUtils.loadAnimation(this,R.anim.rotation_arrow);

        init();
        initView();

        backButton.setOnClickListener(this);
        allButton.setOnClickListener(this);
        howToUseButton.setOnClickListener(this);
        techButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int getId = view.getId();
        switch (getId){
            case R.id.backButton : onBackPressed();
                break;
            case R.id.allQuestion:
                allButton.setImageResource(R.drawable.ic_mini_selected_button);
                allText.setText(R.string.txt_frequent_all_selected);

                howToUseButton.setImageResource(R.drawable.ic_big_basic_button);
                useText.setText(R.string.txt_frequent_use_basic);

                techButton.setImageResource(R.drawable.ic_mini_basic_button);
                techText.setText(R.string.txt_frequent_tech_basic);
                init();
                initView();
                break;
            case R.id.howToUseQuestion:
                allButton.setImageResource(R.drawable.ic_mini_basic_button);
                allText.setText(R.string.txt_frequent_all_basic);

                howToUseButton.setImageResource(R.drawable.ic_big_selected_button);
                useText.setText(R.string.txt_frequent_use_selected);

                techButton.setImageResource(R.drawable.ic_mini_basic_button);
                techText.setText(R.string.txt_frequent_tech_basic);
                showUse();
                initView();
                break;
            case R.id.techQuestion:
                allButton.setImageResource(R.drawable.ic_mini_basic_button);
                allText.setText(R.string.txt_frequent_all_basic);

                howToUseButton.setImageResource(R.drawable.ic_big_basic_button);
                useText.setText(R.string.txt_frequent_use_basic);

                techButton.setImageResource(R.drawable.ic_mini_selected_button);
                techText.setText(R.string.txt_frequent_tech_selected);
                showTech();
                initView();
                break;
        }
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

        ExpandableListAdapter adapter = new FrequentQuestionAdapter(this,mGroup,mChild);
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
}