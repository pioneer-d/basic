package com.example.rest_api_test.LABCODE;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import com.example.rest_api_test.R;

import java.util.HashMap;
import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LabCodeAPIActivity extends AppCompatActivity {

    static String BASEURL = "https://admin.labcode.kr/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.rest_api_test.R.layout.activity_lab_code_apiactivity);

        initUuid();
        Log.d("UUID : ",getUuid());

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);

        HashMap<String, Object> input = new HashMap<>();
        input.put("versionKey",2);
        input.put("countryKey",0);
        input.put("industryKey",0);
        input.put("teamKey",0);
        input.put("mainCategoryKey",0);
        input.put("subCategoryKey",0);
        input.put("projectKey",0);
        input.put("productKey",0);
        input.put("isVariable",false);
        input.put("isAdminOnly",false);
        input.put("isDigital",false);
        input.put("deviceId",getUuid());
        input.put("deviceInfo","");

        retrofitAPI.postData(input).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                Log.d("onResponse 실행","성공");
                if (response.isSuccessful()){
                    Post data = response.body();
                    Log.d("data : ", String.valueOf(response.body()));
                    Log.d("data : ", data.getMessage());
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Log.d("onFailure","onFailure 실행, 실패");
            }
        });

    }

     //UUID 초기화
     private void initUuid() {
         SharedPreferences mPref = getSharedPreferences("KEY_PREF", MODE_PRIVATE);
         String uuid = mPref.getString("KEY_UUID", null);
         if (uuid == null) {
             uuid = UUID.randomUUID().toString();

             mPref.edit().putString("KEY_UUID", uuid).apply();
         }
     }

        //UUID 조회
        private String getUuid() {
            SharedPreferences mPref = getSharedPreferences("KEY_PREF", MODE_PRIVATE);
            return mPref.getString("KEY_UUID", null);
        }


}