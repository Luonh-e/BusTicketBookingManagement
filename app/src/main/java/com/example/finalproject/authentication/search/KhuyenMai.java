package com.example.finalproject.authentication.search;

public class KhuyenMai {
    private int resourceImg;
    private String title;

    public KhuyenMai(int resourceImg, String title) {
        this.resourceImg = resourceImg;
        this.title = title;
    }

    public int getResourceImg() {
        return resourceImg;
    }

    public void setResourceImg(int resourceImg) {
        this.resourceImg = resourceImg;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
