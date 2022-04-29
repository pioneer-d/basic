package com.example.rest_api_test.Retrofit;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {   //api 호출의 시작점으로 활용할 Class. RetrofitAPI Class를 Retrofit Class에 연결시켜주는 역할을 함.

    /* Gradle 추가
    implementation 'com.squareup.retrofit2:retrofit:2.9.0'      //Retrofit - default (retrofit 라이브러리)
    implementation 'com.squareup.retrofit2:converter-gson:2.9.0' //Retrofit - gson (json 형식으로 받아올 데이터 객체로 변환)
    */

    private static final String BASEURL = "http://jsonplaceholder.typicode.com/";

            //https://admin.labcode.kr/";

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASEURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);
    Call<List<Post>> call = retrofitAPI.getData("1");
//    call.e

//    retrofitAPI.getData("1").enqueue(new Callback<List<Post>>() {
//        @Override
//        public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
//            if (response.isSuccessful()){
//                List<Post> data = response.body();
//                Log.d("data : " ,data.get(0).getTitle());
//            }
//        }
//
//        @Override
//        public void onFailure(Call<List<Post>> call, Throwable t) {
//            t.printStackTrace();
//        }
//    });

}
