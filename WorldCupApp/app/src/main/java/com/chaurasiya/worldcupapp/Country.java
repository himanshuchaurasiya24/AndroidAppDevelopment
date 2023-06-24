package com.chaurasiya.worldcupapp;

public class Country {
    private String countryName, cupWinCount ;
    private int flagImage;

    public Country(String countryName, String cupWinCount, int flagImage) {
        this.countryName = countryName;
        this.cupWinCount = cupWinCount;
        this.flagImage = flagImage;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCupWinCount() {
        return cupWinCount;
    }

    public void setCupWinCount(String cupWinCount) {
        this.cupWinCount = cupWinCount;
    }

    public int getFlagImage() {
        return flagImage;
    }

    public void setFlagImage(int flagImage) {
        this.flagImage = flagImage;
    }
}
