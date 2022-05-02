package com.snaptag.labcode_china.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Get {

    @SerializedName("message")
    private String message;

    @SerializedName("data")
    @Expose
    public ArrayList<Data> data;

    public ArrayList<Data> getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }
}
