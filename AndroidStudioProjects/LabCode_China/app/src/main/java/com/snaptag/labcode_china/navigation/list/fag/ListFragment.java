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

    static String thisName = "ListFragment";

    String image;
    String genre;
    String product;
    String brand;

    static String BASEURL = "https://admin.labcode.kr/";

    private ListBaseAdapter adapter;
    private ListItemData itemData;

    public ListFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        SnaptagAPI retrofitAPI = retrofit.create(SnaptagAPI.class);



        retrofitAPI.getData(1).enqueue(new Callback<Get>() {
            @Override
            public void onResponse(Call<Get> call, Response<Get> response) {
                Log.d(thisName,"onResponse 실행");
                if (response.isSuccessful()){

                    Get data = response.body();


                    itemData = new ListItemData(data.getData().get(0).getProduct().getSourceImage(),
                            data.getData().get(0).getProduct().getTitle(),
                            data.getData().get(0).getProduct().getDescription(),
                            data.getData().get(0).getProduct().getUrlCustom());

                    image = data.getData().get(0).getProduct().getSourceImage();
                    genre = data.getData().get(0).getProduct().getTitle();
                    product = data.getData().get(0).getProduct().getDescription();
                    brand = data.getData().get(0).getProduct().getUrlCustom();

                    adapter.addItem(itemData);

                }
            }

            @Override
            public void onFailure(Call<Get> call, Throwable t) {
                t.printStackTrace();
                t.getCause();
                Log.d("onFailure","onFailure 실행, 실패");
            }
        });
    }

    private void init(){
        Log.d(thisName,"init() 실행");
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(BASEURL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        SnaptagAPI retrofitAPI = retrofit.create(SnaptagAPI.class);
//
//
//        retrofitAPI.getData(1).enqueue(new Callback<Get>() {
//            @Override
//            public void onResponse(Call<Get> call, Response<Get> response) {
//                Log.d(thisName,"onResponse 실행");
//                if (response.isSuccessful()){
//
//                    Get data = response.body();
//                    Log.d("response.body() : ", String.valueOf(response.body()));
//                    Log.d("message : ", data.getMessage());
//                    Log.d("sourceImage : ",String.valueOf(data.getData().get(0).getProduct().getSourceImage()));
//                    Log.d("genre : ",data.getData().get(0).getProduct().getTitle());
//                    Log.d("product : ",data.getData().get(0).getProduct().getDescription());
//                    Log.d("brand : ",data.getData().get(0).getProduct().getUrlCustom());
//
//                    itemData = new ListItemData(data.getData().get(0).getProduct().getSourceImage(),
//                            data.getData().get(0).getProduct().getTitle(),
//                            data.getData().get(0).getProduct().getDescription(),
//                            data.getData().get(0).getProduct().getUrlCustom());
//
//                    image = data.getData().get(0).getProduct().getSourceImage();
//                    genre = data.getData().get(0).getProduct().getTitle();
//                    product = data.getData().get(0).getProduct().getDescription();
//                    brand = data.getData().get(0).getProduct().getUrlCustom();
//
//                    adapter = new ListBaseAdapter();
//                    adapter.addItem(itemData);
//
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Get> call, Throwable t) {
//                t.printStackTrace();
//                t.getCause();
//                Log.d("onFailure","onFailure 실행, 실패");
//            }
//        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        if (image == null) {init();}
        Log.d(thisName,"onCreateView() 실행");
        Log.d(thisName,"\nimage : "+  image + "\ngenre : " + genre + "\nproduct : " + product + "\nbrand : " + brand);

        adapter = new ListBaseAdapter();

        View thisView = inflater.inflate(R.layout.fragment_my_list, container, false);

        ListView listView = (ListView) thisView.findViewById(R.id.item_my_list);
        listView.setAdapter(adapter);

        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_expandable_list_item_1, value);


        return thisView;
    }




}