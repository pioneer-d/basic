package com.snaptag.labcode_china.api.get;

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


    //일단 아래로 get에 필요한 데이터


    @SerializedName("product")
    public Product product;

    @SerializedName("project")
    public Project project;

    @SerializedName("industry")
    public Industry industry;

    @SerializedName("team")
    public Team team;


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

    public Product getProduct() {
        return product;
    }

    public Project getProject() {
        return project;
    }

    public Industry getIndustry() {
        return industry;
    }

    public Team getTeam() {
        return team;
    }
}
