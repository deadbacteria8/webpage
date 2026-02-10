package com.controller;
import com.application.projects.ProjectService;
import com.controller.requestData.CreateProjectRequest;
import com.infrastructure.security.userdetails.UserInfoDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectController {
    private final ProjectService projectService;
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }
    @PostMapping("/admin/project/create")
    public String createProject(@RequestBody CreateProjectRequest projectRequest) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserInfoDetails user = (UserInfoDetails) auth.getPrincipal();
        Long userId = user.getId();
        return "Project created with id: " + this.projectService.createProject(projectRequest.projectTitle(), projectRequest.projectInformation(),userId);
    }
}
