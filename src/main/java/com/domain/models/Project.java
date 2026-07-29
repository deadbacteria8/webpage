package com.domain.models;

import java.util.Set;

public class Project {
    private String title;
    private String projectInformation;
    private final Long userOwningProject;
    public Project(String title, String projectInformation, Long userOwningProject) {
        this.projectInformation = projectInformation;
        this.title = title;
        this.userOwningProject = userOwningProject;
    }

    public String getProjectInformation() {
        return projectInformation;
    }

    public Long getUserOwningProject() {
        return userOwningProject;
    }

    public String getTitle() {
        return title;
    }
}
