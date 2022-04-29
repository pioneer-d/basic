package com.example.rest_api_test.Retrofit;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RetrofitAPI {

    @GET("/posts")
    Call<List<Post>> getData(@Query("userid") String id);

//    //Body 요청시 사용
//    @POST("adm/v1/products/scan")
//    Call<Post> postData(@Body POST modelCheckAlready);

    //http://jsonplaceholder.typicode.com/posts

    /*
    @FormUrlEncoded
    @POST("adm/v1/products/scan")
    Call<Post> postData(@FieldMap HashMap<String, Object> praeam);

    FieldMap이란 Field 형식으로 넘겨주는 값이 여러개일때 사용.
    Field 형식이란 인자를 form-urlencoded로 보낼때 사용하는데,
    form-urlencoded은 key=value&key=value와 같은 형태로 데이터를 전달하는 것을 말함.

    */
}
