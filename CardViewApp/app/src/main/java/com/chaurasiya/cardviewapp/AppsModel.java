package com.chaurasiya.cardviewapp;

public class AppsModel {
    //Step 1
    private String name;
    private int numberOfDownload;
    private int thumbnails;
    //Step 2


    public AppsModel(String name, int numberOfDownload, int thumbnails) {
        this.name = name;
        this.numberOfDownload = numberOfDownload;
        this.thumbnails = thumbnails;
    }
    public AppsModel(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfDownload() {
        return numberOfDownload;
    }

    public void setNumberOfDownload(int numberOfDownload) {
        this.numberOfDownload = numberOfDownload;
    }

    public int getThumbnails() {
        return thumbnails;
    }

    public void setThumbnails(int thumbnails) {
        this.thumbnails = thumbnails;
    }

}
