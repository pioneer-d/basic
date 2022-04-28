package com.example.rest_api_test.Retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {   //api 호출의 시작점으로 활용할 Class. RetrofitAPI Class를 Retrofit Class에 연결시켜주는 역할을 함.

    /* Gradle 추가
    implementation 'com.squareup.retrofit2:retrofit:2.9.0'      //Retrofit - default (retrofit 라이브러리)
    implementation 'com.squareup.retrofit2:converter-gson:2.9.0' //Retrofit - gson (json 형식으로 받아올 데이터 객체로 변환)
    */

    private static final String URL = "https://admin.labcode.kr/";

    private static RetrofitAPI getApiService(){
        return getInstance().create(RetrofitAPI.class);
    }

    private static Retrofit getInstance(){
        Gson gson = new GsonBuilder().setLenient().create();
        return new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

}
