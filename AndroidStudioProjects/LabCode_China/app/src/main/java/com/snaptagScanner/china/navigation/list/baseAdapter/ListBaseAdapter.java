package com.snaptagScanner.china.navigation.list.baseAdapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.snaptagScanner.china.R;
import com.snaptagScanner.china.navigation.list.data.ListItemData;

import java.util.ArrayList;

public class ListBaseAdapter extends BaseAdapter {

    static String thisName = "ListBaseAdapter";

    ArrayList<ListItemData> listItem = new ArrayList<ListItemData>();
    Context context;

    @Override
    public int getCount() {
        return listItem.size();
    }

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

        Log.d(thisName,String.valueOf(parent.getContext()));

        context = parent.getContext();
        ListItemData itemData = listItem.get(position);

        //if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_list_item,parent,false);
        //}
        ImageView sourceImage = convertView.findViewById(R.id.sourceImage);
        TextView productGenre = convertView.findViewById(R.id.productGenre);
        TextView productName = convertView.findViewById(R.id.productName);
        TextView brandName = convertView.findViewById(R.id.brandName);

        Glide.with(convertView).load(itemData.getSourceImage()).into(sourceImage);
        if (itemData.getSourceImage() == null){
            sourceImage.setImageResource(R.drawable.ic_logo);
        }
        productGenre.setText(itemData.getProductGenre());
        productName.setText(itemData.getProductName());
        brandName.setText(itemData.getBrandName());

        Log.d(thisName,String.valueOf(context));


        return convertView;
    }

    public void addItem(ListItemData item){
        listItem.add(item);

        //어댑터에게 값의 변화를 알리는 메소드
       notifyDataSetChanged();
    }
}
