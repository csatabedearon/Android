package com.example.lab4;

public class Currency {
    private String code;
    private String name;
    private int flagImage;
    private String buyRate;
    private String sellRate;

    public Currency(String code, String name, int flagImage, String buyRate, String sellRate) {
        this.code = code;
        this.name = name;
        this.flagImage = flagImage;
        this.buyRate = buyRate;
        this.sellRate = sellRate;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getFlagImage() {
        return flagImage;
    }

    public String getBuyRate() {
        return buyRate;
    }

    public String getSellRate() {
        return sellRate;
    }
}
