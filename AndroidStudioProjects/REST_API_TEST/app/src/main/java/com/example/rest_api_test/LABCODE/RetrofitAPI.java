package com.example.rest_api_test.LABCODE;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RetrofitAPI {
    @FormUrlEncoded
    @POST("adm/v1/products/scan")
    Call<Post> postData(@FieldMap HashMap<String, Object>param);
}
