package com.snaptag.labcode_china.api.get;

import com.google.gson.annotations.SerializedName;

public class Project {

    @SerializedName("bannerImage")
    public String bannerImage;

    @SerializedName("title")
    public String title;

    public String getBannerImage() {
        return bannerImage;
    }

    public String getTitle() {
        return title;
    }
}
