package com.example.rest_api_test.HttpURLConnection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.rest_api_test.R;
import com.example.rest_api_test.Retrofit.Post;
import com.example.rest_api_test.Retrofit.RetrofitAPI;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitActivity extends AppCompatActivity {

    static String BASEURL = "http://jsonplaceholder.typicode.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.rest_api_test.R.layout.activity_retrofit);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);


    retrofitAPI.getData("1").enqueue(new Callback<List<Post>>() {

        @Override
        public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
            Log.d("onResponse 실행 : ","성공");
            if (response.isSuccessful()){
                List<Post> data = response.body();
                Log.d("data : " ,data.get(0).getTitle());
            }
        }

        @Override
        public void onFailure(Call<List<Post>> call, Throwable t) {
            Log.d("onFailure 실행 : ","실패");
            t.printStackTrace();
        }
    });
    }
}