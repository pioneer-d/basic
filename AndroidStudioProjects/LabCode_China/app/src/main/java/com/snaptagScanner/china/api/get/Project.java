package com.snaptagScanner.china.api.get;

import com.google.gson.annotations.SerializedName;

public class Project {

    @SerializedName("bannerImage")
    public String bannerImage;

    @SerializedName("title")
    public String title;

    @SerializedName("industry")
    public Industry industry;

    @SerializedName("team")
    public Team team;

    public String getBannerImage() {
        return bannerImage;
    }

    public String getTitle() {
        return title;
    }

    public Industry getIndustry() {
        return industry;
    }

    public Team getTeam() {
        return team;
    }
}
