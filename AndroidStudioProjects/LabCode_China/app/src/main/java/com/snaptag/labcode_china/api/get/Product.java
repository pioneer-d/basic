package com.snaptag.labcode_china.api.get;

import com.google.gson.annotations.SerializedName;

public class Product {

    @SerializedName("title")
    public String title;

    @SerializedName("bannerImageUrl")
    public String bannerImageUrl;

    @SerializedName("sourceImage")
    public String sourceImage;

    @SerializedName("url")
    public String url;

    public String getTitle() {
        return title;
    }

    public String getBannerImageUrl() {
        return bannerImageUrl;
    }

    public String getSourceImage() {
        return sourceImage;
    }

    public String getUrl() {
        return url;
    }
}
