package com.snaptag.labcode_china.api;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface SnaptagAPI {

    @FormUrlEncoded
    @POST("adm/v1/products/scan")
    Call<Post> postData(@FieldMap HashMap<String, Object>param);

    @GET("adm/v1/products/scan/{uuid}")
    Call<Get> getData(@Path(value = "uuid", encoded = true) String uuid, @Query("page") int page);



}
