package com.snaptag.labcode_china.api;

import com.google.gson.annotations.SerializedName;

public class Data {


    @SerializedName("title")
    public String title;

    @SerializedName("description")
    public String description;

    @SerializedName("sourceImage")
    public String sourceImage;

    @SerializedName("urlCustom")
    public String urlCustom;



    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getSourceImage() {
        return sourceImage;
    }

    public String getUrlCustom() {
        return urlCustom;
    }
}
