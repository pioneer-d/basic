package com.snaptagScanner.china.api.post;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.snaptagScanner.china.api.get.Data;

public class Post {
    @SerializedName("message")
    private String message;

    @SerializedName("data")
    @Expose
    public Data data = new Data();

    public Data getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

}
