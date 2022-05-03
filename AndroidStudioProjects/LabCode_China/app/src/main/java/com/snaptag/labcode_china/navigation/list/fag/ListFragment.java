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
import android.widget.AbsListView;
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

    //page 1당 20개
    int page = 1;

    static String BASEURL = "https://admin.labcode.kr/";

    private ListBaseAdapter adapter;
    private ListItemData itemData;

    public ListFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init(){
        Log.d(thisName,"init() 실행");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        SnaptagAPI retrofitAPI = retrofit.create(SnaptagAPI.class);

        retrofitAPI.getData(page).enqueue(new Callback<Get>() {
            @Override
            public void onResponse(Call<Get> call, Response<Get> response) {
                Log.d(thisName,"onResponse 실행");
                if (response.isSuccessful()){

                    Get data = response.body();

                    if (!data.getData().isEmpty()) {

                        for (int i = 0; i < data.getData().size(); i++) {
                            image = data.getData().get(i).getProduct().getSourceImage();
                            genre = data.getData().get(i).getProduct().getTitle();
                            product = data.getData().get(i).getProduct().getDescription();
                            brand = data.getData().get(i).getProduct().getUrlCustom();

                            itemData = new ListItemData(image, genre, product, brand);

                            adapter.addItem(itemData);
                        }
                    }


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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Log.d(thisName,"onCreateView() 실행");
        Log.d(thisName,"\nimage : "+  image + "\ngenre : " + genre + "\nproduct : " + product + "\nbrand : " + brand);

        adapter = new ListBaseAdapter();

        View thisView = inflater.inflate(R.layout.fragment_my_list, container, false);

        ListView listView = (ListView) thisView.findViewById(R.id.item_my_list);
        listView.setAdapter(adapter);

        //이부분은 스크롤 관리
        listView.setOnScrollListener(new AbsListView.OnScrollListener(){

            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (listView.canScrollVertically(-1)){
                    Log.d(thisName,"스크롤 최하단");
                    //최상단일 경우
               } else if (listView.canScrollVertically(1)){
                    Log.d(thisName,"스크롤 최상단");
                    page++;
                    Log.d(thisName,"page : "+String.valueOf(page));
                    init();
                }
            }

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {

            }
        });



        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_expandable_list_item_1, value);

        return thisView;
    }




}