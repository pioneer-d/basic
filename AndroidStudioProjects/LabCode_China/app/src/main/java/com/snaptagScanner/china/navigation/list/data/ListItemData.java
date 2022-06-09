package com.snaptagScanner.china.navigation.list.data;

public class ListItemData {

    private String sourceImage;
    private String productGenre;
    private String productName;
    private String brandName;

    public ListItemData(String image, String genre, String product, String brand){
        this.sourceImage = image;
        this.productGenre = genre;
        this.productName = product;
        this.brandName = brand;
    }

    public String getSourceImage() {
        return sourceImage;
    }

    public void setSourceImage(String sourceImage) {
        this.sourceImage = sourceImage;
    }

    public String getProductGenre() {
        return productGenre;
    }

    public void setProductGenre(String productGenre) {
        this.productGenre = productGenre;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
}
