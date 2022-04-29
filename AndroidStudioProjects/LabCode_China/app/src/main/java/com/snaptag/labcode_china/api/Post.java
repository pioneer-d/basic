package com.snaptag.labcode_china.api;

import com.google.gson.annotations.SerializedName;

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
