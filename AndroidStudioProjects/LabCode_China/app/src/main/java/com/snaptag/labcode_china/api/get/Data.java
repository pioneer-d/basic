package com.snaptag.labcode_china.api.get;

import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("url")
    public String url;

    @SerializedName("title")
    public String title;

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }
    //위로 Post



    //아래로 Gep

    @SerializedName("product")
    public Product product;

    @SerializedName("project")
    public Project project;

    @SerializedName("industry")
    public Industry industry;

    @SerializedName("team")
    public Team team;


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
