package com.snaptag.labcode_china.navigation.more.data;

public class MoreItemData {

    private int CategoryName;
    private String version;
    private int imageView;

    public MoreItemData(int name, String version, int image){
        this.CategoryName = name;
        this.version = version;
        this.imageView = image;
    }

    public MoreItemData(int name, String version){
        this.CategoryName = name;
        this.version = version;
    }

    public MoreItemData(int name, int image){
        this.CategoryName = name;
        this.imageView = image;
    }

    public int getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(int categoryName) {
        CategoryName = categoryName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getImageView() {
        return imageView;
    }

    public void setImageView(int imageView) {
        this.imageView = imageView;
    }

}
