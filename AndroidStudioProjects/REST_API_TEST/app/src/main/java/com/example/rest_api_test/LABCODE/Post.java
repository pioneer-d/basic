package com.example.rest_api_test.LABCODE;

import com.google.gson.annotations.SerializedName;

import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public class Post {
    @SerializedName("message")
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
