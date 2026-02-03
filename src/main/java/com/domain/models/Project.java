package com.domain.models;

import java.util.Set;

public class Projects {
    private String title;
    private String projectInformation;
    private Set<User> users;
    
    public Projects(Set<User> users, String title, String projectInformation) {
        this.projectInformation = projectInformation;
        this.users = users;
        this.title = title;
    }

    public String getProjectInformation() {
        return projectInformation;
    }

    public Set<User> getUsers() {
        return users;
    }

    public String getTitle() {
        return title;
    }
}
