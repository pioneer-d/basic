package com.snaptag.labcode_china.navigation.more.baseAdapter;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.snaptag.labcode_china.R;
import java.util.List;
import java.util.Map;

public class FrequentQuestionAdapter extends BaseExpandableListAdapter {

    static String thisName = "FrequentQuestionAdapter_Test";
    Activity activity;
    private List<String> mGroup;
    private Map<String, List<Integer>> mChild;

    TextView childText;

    Animation slide_down;

    public FrequentQuestionAdapter(Activity activity, List<String> mGroup, Map<String, List<Integer>> mChild){
        this.activity = activity;
        this.mGroup = mGroup;
        this.mChild = mChild;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return mChild.get( mGroup.get( groupPosition ) ).get( childPosition );
    }


    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        if ( convertView == null )

            convertView = LayoutInflater.from( activity ).inflate( R.layout.listview_more_frequent_child, null );

        childText = (TextView)convertView.findViewById( R.id.child_text );
        childText.setText(mChild.get( mGroup.get( groupPosition ) ).get( childPosition ) );
        slide_down = AnimationUtils.loadAnimation(activity,R.anim.slide_down);

        return convertView;

    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return mChild.get( mGroup.get( groupPosition ) ).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return mGroup.get( groupPosition );
    }

    @Override
    public int getGroupCount() {
        return mGroup.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        if ( convertView == null )

            convertView = LayoutInflater.from( activity ).inflate( R.layout.listview_more_frequent_parent, null );

        ((TextView)convertView.findViewById( R.id.questionText )).setText( mGroup.get(groupPosition));
        //((ImageView)convertView.findViewById( R.id.questionImage )).setImageResource(R.drawable.ic_question_image);
        //((ImageView)convertView.findViewById( R.id.arrowImage )).setImageResource(R.drawable.ic_bottomarrow);

        return convertView;

    }



    @Override
    public boolean hasStableIds() {
        return false;
    }



    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

}





