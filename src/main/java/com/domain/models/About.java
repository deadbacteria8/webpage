package com.domain.models;

public class About {
    private String shortIntroduction;
    public About(String shortIntroduction) {
        this.shortIntroduction = shortIntroduction;
    }

    public String getShortIntroduction() {
        return this.shortIntroduction;
    }
    public void setShortIntroduction(String shortIntroduction) {
        this.shortIntroduction = shortIntroduction;
    }
}
