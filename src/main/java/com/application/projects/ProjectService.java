package com.application.projects;

import com.domain.models.Project;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Service
public class ProjectService {
    private final ProjectRepository projectRepository;
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }
    public Long createProject(String title, String projectInformation, Long id) {
        Project project = new Project(title, projectInformation,id);
        return projectRepository.createProject(project);
    }

    public void updateProject(String title, String projectInformation, Long userId, Long projectId) {
        Project project = projectRepository.getProjectFromId(projectId);
        if(!Objects.equals(project.getUserOwningProject(), userId)) {
            throw new IllegalStateException("User does not own this project");
        }
    }
}
