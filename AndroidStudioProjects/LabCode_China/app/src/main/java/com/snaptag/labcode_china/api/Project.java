package com.snaptag.labcode_china.api;

import com.google.gson.annotations.SerializedName;

public class Project {

    @SerializedName("bannerImage")
    public String bannerImage;

    public String getBannerImage() {
        return bannerImage;
    }

    public void setBannerImage(String bannerImage) {
        this.bannerImage = bannerImage;
    }
}
