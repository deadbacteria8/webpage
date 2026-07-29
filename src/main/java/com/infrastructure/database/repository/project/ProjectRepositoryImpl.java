package com.infrastructure.database.repository.project;
import com.application.projects.ProjectRepository;
import com.domain.models.Project;
import com.infrastructure.database.entities.ProjectEntity;
import com.infrastructure.database.entities.UserEntity;
import com.infrastructure.database.repository.user.JpaUserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Repository;


@Repository
public class ProjectRepositoryImpl implements ProjectRepository {
    private final JpaUserRepository jpaUserRepository;
    private final JpaProjectRepository jpaProjectRepository;
    public ProjectRepositoryImpl(JpaUserRepository jpaUserRepository, JpaProjectRepository jpaProjectRepository) {
        this.jpaUserRepository = jpaUserRepository;
        this.jpaProjectRepository = jpaProjectRepository;
    }
    @Override
    public Long createProject(Project project) {
        UserEntity user = jpaUserRepository.findById(project.getUserOwningProject())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        ProjectEntity projectEntity = new ProjectEntity(user, project);
        jpaProjectRepository.save(projectEntity);
        return projectEntity.getId();
    }

    public void updateProject(Project project, Long projectId) {
        ProjectEntity projectEntity = jpaProjectRepository.findById(projectId)
                .orElseThrow(() -> new EntityNotFoundException("Project not found"));
        projectEntity.setProjectAttributes(project);
    }

    public Project getProjectFromId(Long projectId) {
        return jpaProjectRepository.findById(projectId).map(ProjectEntity::mapToDomain)
                .orElseThrow(() -> new EntityNotFoundException("Project not found"));
    }
}
