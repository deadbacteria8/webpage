package com.domain.model;

public class Socials {
    private String githubAcc;
    private String linkedInAcc;

    public Socials(String githubAcc, String linkedInAcc) {
        this.githubAcc = githubAcc;
        this.linkedInAcc = linkedInAcc;
    }

    public String getGithubAccLink() {
        return "https://github.com/" + githubAcc;
    }

    public String getLinkedInAccLink() {
        return "https://www.linkedin.com/in/" + linkedInAcc;
    }

    public String getGithubAcc() {
        return githubAcc;
    }

    public String getLinkedInAcc() {
        return linkedInAcc;
    }
}
