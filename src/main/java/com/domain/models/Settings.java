package com.domain.models;

public class Settings {

    private String githubLink;
    private String name;
    private final User user;

    public Settings(String name, String githubUsername, User user){
        this.githubLink = getGithubLinkFromUsername(githubUsername);
        this.name = name;
        this.user = user;
    }

    private String getGithubLinkFromUsername(String githubUsername) {
        return "www.github.com/" + githubUsername;
    }
}
