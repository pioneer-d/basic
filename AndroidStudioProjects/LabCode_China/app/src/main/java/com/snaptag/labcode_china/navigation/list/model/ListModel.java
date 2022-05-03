package com.snaptag.labcode_china.navigation.list.model;

import android.util.Log;

import com.snaptag.labcode_china.api.Get;
import com.snaptag.labcode_china.api.SnaptagAPI;
import com.snaptag.labcode_china.navigation.list.data.ListItemData;
import com.snaptag.labcode_china.navigation.list.presenter.ListContract;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListModel {

    ListContract.Presenter presenter;
    static String BASEURL = "https://admin.labcode.kr/";
    private ListItemData itemData;

    String image;
    String genre;
    String product;
    String brand;

    public ListModel(ListContract.Presenter presenter){
        this.presenter = presenter;
    }

    //-> 이걸 여기서 받으니까 자꾸 못받아옴. 다른 방법 생각하거나, ListFragment나 ControlFragment에서 받아와야 할 것 같음..!


    //실제 적용시 JSON이나 Map으로 반환하고, Presenter에서 null로 체크해야할 듯.
    public boolean getList(){
//      public ListItemData getList(){
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
//                Log.d("onResponse 실행","성공");
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
//                    image = data.getData().get(0).getProduct().getSourceImage();
//                    genre = data.getData().get(0).getProduct().getTitle();
//                    product = data.getData().get(0).getProduct().getDescription();
//                    brand = data.getData().get(0).getProduct().getUrlCustom();
//                    itemData = new ListItemData(image,genre,product,brand);
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

        return true;
    }

}
