package com.domain.model;

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
