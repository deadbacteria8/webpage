package com.application.projects;

import com.domain.models.Project;

public interface ProjectRepository {
    public Long createProject(Project project);
    public Project getProjectFromId(Long projectId);
    public void updateProject(Project project, Long projectId);
}
