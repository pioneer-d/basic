package com.snaptag.labcode_china.api;

import android.content.SharedPreferences;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface SnaptagAPI {

    @FormUrlEncoded
    @POST("adm/v1/products/scan")
    Call<Post> postData(@FieldMap HashMap<String, Object>param);

    @GET("adm/v1/products/scan/6f223174-10df-4227-addf-bb68de568e55")   //일단 하드코딩
    Call<Get> getData(@Query("page") int page);


}
