package com.snaptag.labcode_china.navigation.more.baseAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.snaptag.labcode_china.R;
import com.snaptag.labcode_china.navigation.more.data.MoreItemData;

import java.util.ArrayList;

public class MoreBaseAdapter extends BaseAdapter {

    ArrayList<MoreItemData> listItem = new ArrayList<MoreItemData>();
    Context context;

    //리스트 개수
    @Override
    public int getCount() {
        return listItem.size();
    }

    //해당 position의 item
    @Override
    public Object getItem(int position) {
        return listItem.get(position);
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        context = parent.getContext();
        MoreItemData itemData = listItem.get(position);

        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_more_item,parent,false);
        }
        TextView categoryName = convertView.findViewById(R.id.categoryName);
        ImageView image = convertView.findViewById(R.id.image);
        TextView version = convertView.findViewById(R.id.version);

        ViewGroup.LayoutParams layoutParams = convertView.getLayoutParams();
        layoutParams.height = 200;
        convertView.setLayoutParams(layoutParams);

        categoryName.setText(itemData.getCategoryName());
        image.setImageResource(itemData.getImageView());
        version.setText(itemData.getVersion());


        return convertView;
    }

    public void addItem(MoreItemData item){
        listItem.add(item);
    }
}