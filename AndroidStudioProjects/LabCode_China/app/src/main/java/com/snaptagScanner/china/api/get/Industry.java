package com.snaptagScanner.china.api.get;

import com.google.gson.annotations.SerializedName;

public class Industry {

    @SerializedName("title")
    public String title;

    @SerializedName("key")
    public String key;

    public String getTitle() {
        return title;
    }

    public String getKey() {
        return key;
    }
}
