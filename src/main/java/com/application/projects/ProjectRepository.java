package com.application.projects;

import com.domain.models.Project;

public interface ProjectRepository {
    public Long createProject(Project project,Long id);
}
