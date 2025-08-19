package com.domain.model;



public class FullAbout {
    public FullAbout(String name, String githubLink, String shortIntroduction){
        this.githubLink = githubLink;
        this.name = name;
        this.shortIntroduction = shortIntroduction;
    }
    private final String githubLink;
    private final String name;
    private final String shortIntroduction;
}
