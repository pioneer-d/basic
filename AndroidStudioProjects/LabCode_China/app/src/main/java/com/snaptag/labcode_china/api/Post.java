package com.snaptag.labcode_china.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Post {
    @SerializedName("message")
    private String message;

    @SerializedName("data")
    @Expose
    public Data data = new Data();

    public Data getData() {
        return data;
    }

    /*
    statusCode
Message
array인 data -> product
array인 product -> title, description, sourceImage, urlCustom 이정도만 뽑아보자.


     */

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
