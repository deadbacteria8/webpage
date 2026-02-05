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
    public ProjectRepositoryImpl(JpaUserRepository jpaUserRepository) {
        this.jpaUserRepository = jpaUserRepository;
    }
    @Override
    public Long createProject(Project project, Long id) {
        UserEntity user = jpaUserRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        ProjectEntity projectEntity = new ProjectEntity(user, project);
        return projectEntity.getId();
    }
}
