package com.snaptag.labcode_china.navigation.list.fag;

import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.snaptag.labcode_china.R;
import com.snaptag.labcode_china.api.Get;
import com.snaptag.labcode_china.api.Post;
import com.snaptag.labcode_china.api.SnaptagAPI;
import com.snaptag.labcode_china.navigation.list.baseAdapter.ListBaseAdapter;
import com.snaptag.labcode_china.navigation.list.data.ListItemData;
import com.snaptag.labcode_china.navigation.list.view.ListControlFragment;
import com.snaptag.labcode_china.navigation.more.baseAdapter.MoreBaseAdapter;
import com.snaptag.labcode_china.navigation.more.data.MoreItemData;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ListFragment extends Fragment {

    private Fragment listControlFragment;
    static String BASEURL = "https://admin.labcode.kr/";

    String image = null;
    String genre = "";
    String product = "";
    String brand = "";

    private ListBaseAdapter adapter;

    public ListFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            image = getArguments().getString("image");
            genre = getArguments().getString("genre");
            product = getArguments().getString("product");
            brand = getArguments().getString("brand");
        }

    }

    private void init(){
        Log.d("init() 실행","실행");
        listControlFragment = ListControlFragment.newInstance();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("onCreateView 실행","실행");

        View thisView = inflater.inflate(R.layout.fragment_my_list, container, false);

        ListView listView = (ListView) thisView.findViewById(R.id.item_my_list);
        adapter = new ListBaseAdapter();
        Log.d("image test",image);
        Log.d("genre test",genre);
        Log.d("product test",product);
        Log.d("brand test",brand);
        adapter.addItem(new ListItemData(image,genre,product,brand));

        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_expandable_list_item_1, value);
        listView.setAdapter(adapter);

        return thisView;
    }




}