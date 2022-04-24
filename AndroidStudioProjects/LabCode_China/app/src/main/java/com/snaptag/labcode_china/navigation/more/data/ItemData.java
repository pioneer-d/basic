package com.snaptag.labcode_china.navigation.more.data;

import android.widget.ImageView;

public class ItemData {

    private String CategoryName;
    private String version;

    private ImageView imageView;

    public ItemData(String name, String version, ImageView image){
        this.CategoryName = name;
        this.version = version;
        this.imageView = image;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

}
