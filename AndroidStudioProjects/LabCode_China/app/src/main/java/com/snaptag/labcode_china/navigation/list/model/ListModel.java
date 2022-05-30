package com.snaptag.labcode_china.navigation.list.model;

import android.app.Activity;
import android.content.SharedPreferences;
import android.util.Log;

import com.snaptag.labcode_china.api.get.Get;
import com.snaptag.labcode_china.api.SnaptagAPI;
import com.snaptag.labcode_china.navigation.list.presenter.ListContract;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListModel {

    static String thisName = "ListModel";

    ListContract.Presenter presenter;
    static String BASEURL = "http://106.15.201.243/";
    Activity activity;


    public ListModel(ListContract.Presenter presenter, Activity activity){
        this.presenter = presenter;
        this.activity = activity;
    }

    //실제 적용시 JSON이나 Map으로 반환하고, Presenter에서 null로 체크해야할 듯.
    public void getList(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        SnaptagAPI retrofitAPI = retrofit.create(SnaptagAPI.class);

        retrofitAPI.getData(getUuid(),1).enqueue(new Callback<Get>() {
            @Override
            public void onResponse(Call<Get> call, Response<Get> response) {
                Log.d("onResponse 실행","성공");
                if (response.isSuccessful()){

                    Get data = response.body();
                    Log.d("response.body() : ", String.valueOf(response.body()));
                    Log.d("message : ", data.getMessage());


                    Log.d(thisName,"data.getData().size() : "+data.getData().size());
                    if(data.getData().size() == 0){
                        presenter.notExist();
                    } else{
                        presenter.exist();
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
    public String getUuid() {
        SharedPreferences mPref = activity.getSharedPreferences("KEY_PREF", activity.MODE_PRIVATE);
        return mPref.getString("KEY_UUID", null);
    }

}
