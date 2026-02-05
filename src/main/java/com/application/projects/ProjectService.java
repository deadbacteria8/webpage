package com.application.projects;

import com.domain.models.Project;
import org.springframework.stereotype.Service;


@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }
    public Long createProject(String title, String projectInformation, Long id) {
        Project project = new Project(title, projectInformation);
        return projectRepository.createProject(project, id);
    }
}
