package com.snaptag.labcode_china.navigation.more.baseAdapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.snaptag.labcode_china.R;
import com.snaptag.labcode_china.navigation.more.data.QuestionData;

import java.util.ArrayList;

public class FrequentQuestionAdapter extends BaseAdapter {

    static String thisName = "FrequentQuestionAdapter";

    ArrayList<QuestionData> listItem = new ArrayList<QuestionData>();
    Context context;

    ImageView questionImage;
    TextView questionText;
    ImageView arrowImage;

    @Override
    public int getCount() { return listItem.size(); }

    @Override
    public Object getItem(int position) { return listItem.get(position); }

    @Override
    public long getItemId(int position) { return position; }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        context = parent.getContext();
        QuestionData itemData = listItem.get(position);
        Log.d(thisName,"position : "+String.valueOf(position));


        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_more_frequent,parent,false);
        }
        questionImage = convertView.findViewById(R.id.questionImage);
        questionText = convertView.findViewById(R.id.questionText);
        arrowImage = convertView.findViewById(R.id.arrowImage);

//        ViewGroup.LayoutParams layoutParams = convertView.getLayoutParams();
//        layoutParams.height = 200;
//        convertView.setLayoutParams(layoutParams);

        questionImage.setImageResource(itemData.getQuestionImage());
        questionText.setText(itemData.getQuestionText());
        arrowImage.setImageResource(itemData.getArrowImage());


        return convertView;
    }

    public void addItem(QuestionData item){
        listItem.add(item);
    }


    public void clearItem(){
        listItem.clear();
    }
}
