package com.snaptag.labcode_china.navigation.list.page;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import com.snaptag.labcode_china.R;
import com.snaptag.labcode_china.api.get.Get;
import com.snaptag.labcode_china.api.SnaptagAPI;
import com.snaptag.labcode_china.navigation.list.baseAdapter.ListBaseAdapter;
import com.snaptag.labcode_china.navigation.list.data.ListItemData;

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
    HashMap<Integer,String> urlManager = new HashMap<Integer,String>();
    int positionKey;
    String url;

    private int firstItemNum_before = 0;
    private int firstItemNum_after = 1;

    //page 1당 20개
    int page = 1;
    private boolean lastItemFlag = false;

    static String BASEURL = "https://admin.labcode.kr/";

    private ListView listView;
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

            Log.d(thisName, "getUuid() : " + getUuid());

            retrofitAPI.getData(getUuid(), page).enqueue(new Callback<Get>() {
                @Override
                public void onResponse(Call<Get> call, Response<Get> response) {
                    Log.d(thisName, "onResponse 실행");
                    if (response.isSuccessful()) {

                        Get data = response.body();

                        if (!data.getData().isEmpty()) {

                            for (int i = 0; i < data.getData().size(); i++) {

                                image = data.getData().get(i).getProject().getBannerImage();
                                if (image == null) {
                                    image = data.getData().get(i).getProduct().getBannerImageUrl();
                                    if (image == null){
                                        image = data.getData().get(i).getProduct().getSourceImage();
                                    }
                                }
                                Log.d(thisName,"image : "+image);

                                //data.project.bannerImage -> data.product.bannerImageUrl -> data.product.sourceImage -> app logo
                                genre = data.getData().get(i).getIndustry().getTitle();
                                if (genre == null){
                                    genre = "Test";
                                }
                                Log.d(thisName,"genre : "+genre);

                                //data.industry.title -> Test
                                product = data.getData().get(i).getProduct().getTitle();
                                if (product == null){
                                    product = "SnapTag";
                                }
                                Log.d(thisName,"product : "+product);

                                //data.project.title -> SnapTag
                                brand = data.getData().get(i).getTeam().getTitle();
                                if (brand == null){
                                    brand = "SnapTag";
                                }
                                Log.d(thisName,"brand : "+brand);

                                //data.team.title -> SnapTag
                                positionKey = i;
                                if (page>1){
                                    positionKey = ((page-1)*20) + i;
                                }
                                Log.d(thisName,"positionKey : "+String.valueOf(positionKey));

                                url = data.getData().get(i).getProduct().getUrl();
                                if (!URLUtil.isValidUrl(url)){
                                    url = "http://snaptag.com.cn";
                                }
                                Log.d(thisName,"url : "+url);
                                //http://snaptag.com.cn/
                                urlManager.put(positionKey,url);
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
                    Log.d("onFailure", "onFailure 실행, 실패");
                }
            });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Log.d(thisName,"onCreateView() 실행");

        adapter = new ListBaseAdapter();

        View thisView = inflater.inflate(R.layout.fragment_my_list, container, false);

        listView = (ListView) thisView.findViewById(R.id.item_my_list);
        listView.setAdapter(adapter);

        //이부분은 스크롤 관리
        listView.setOnScrollListener(new AbsListView.OnScrollListener(){

            @Override
            public void onScrollStateChanged(AbsListView absListView, int scrollState) {
//                if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE && lastItemFlag){
//                    Log.d(thisName,"스크롤 최하단");
//                    page++;
//                    Log.d(thisName,"page : "+String.valueOf(page));
//                    init();
//                }
            }

            @Override
            public void onScroll(AbsListView absListView, int firstItemNum, int visibleItemCount, int totalItemCount) {
                //lastItemFlag = (totalItemCount > 0) && (firstItemNum + visibleItemCount >= totalItemCount);
                if ((firstItemNum % 12 == 0) && (firstItemNum != 0)) {
                    // 다시한번 검토 해보자.
                    firstItemNum_after = firstItemNum;
                    Log.d(thisName,"firstItemNum % 12 == 0인 경우");
                    if (firstItemNum_before < firstItemNum_after) {
                        Log.d(thisName, "after가 더 클때");
                        Log.d(thisName,"firstItemNum_before : "+String.valueOf(firstItemNum_before));
                        page++;
                        firstItemNum_before = firstItemNum_after;
                        init();
                    }
                }
                Log.d(thisName,"리스트 첫번째 아이템 position : "+String.valueOf(firstItemNum));

            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Object item = adapterView.getItemAtPosition(position);
                String testUrl = urlManager.get(position);

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(testUrl));
                getActivity().startActivity(intent);

            }
        });

        return thisView;
    }


//    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//        @Override
//        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
//            Object item = adapterView.getItemAtPosition(position);
//            Log.d(thisName,"Click Item : "+item);
//
//            if (item == frequentQuestion){
//                Log.d(thisName,"goFrequentQuestion()");
//                goFrequentQuestion();
//            } else if (item == termOfService){
//                Log.d(thisName,"goTos()");
//                goTos();
//            } else if (item == scanGuide){
//                Log.d(thisName,"goScanGuide()");
//                goScanGuide();
//            }
//
//
//        }
//    });

    public String getUuid() {
        SharedPreferences mPref = getActivity().getSharedPreferences("KEY_PREF", getActivity().MODE_PRIVATE);
        return mPref.getString("KEY_UUID", null);
    }


}