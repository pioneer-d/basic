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

    @SerializedName("product")
    public Product product;

    @SerializedName("project")
    public Project project;

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Product getProduct() {
        return product;
    }

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
