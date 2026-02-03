package com.application.projects;

import com.domain.models.Project;
import org.springframework.stereotype.Service;


@Service
public class ProjectsService {

    private final ProjectRepository projectRepository;

    public ProjectsService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }
    public Long createProject(String title, String projectInformation, Long id) {
        Project project = new Project(title, projectInformation);
        return projectRepository.createProject(project, id);
    }
}
