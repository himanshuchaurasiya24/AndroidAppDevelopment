package com.chaurasiya.topgames;

public class ModelClass {
    private String gameName;
    private int gameImage;

    public ModelClass(String gameName, int gameImage) {
        this.gameName = gameName;
        this.gameImage = gameImage;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public int getGameImage() {
        return gameImage;
    }

    public void setGameImage(int gameImage) {
        this.gameImage = gameImage;
    }
}
