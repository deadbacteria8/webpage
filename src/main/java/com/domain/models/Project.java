package com.domain.models;

import java.util.Set;

public class Project {
    private String title;
    private String projectInformation;

    public Project(String title, String projectInformation) {
        this.projectInformation = projectInformation;
        this.title = title;
    }

    public String getProjectInformation() {
        return projectInformation;
    }


    public String getTitle() {
        return title;
    }
}
