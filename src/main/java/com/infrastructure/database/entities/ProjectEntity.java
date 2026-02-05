package com.infrastructure.database.entities;
import com.domain.models.About;
import com.domain.models.Project;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.util.Set;

@Entity
public class ProjectEntity extends EntityBase<Project> {

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity owner;
    private String shortIntroduction;
    private String title;
    public ProjectEntity(UserEntity owner, Project project) {
        this.owner= owner;
        this.shortIntroduction = project.getProjectInformation();
        this.title = project.getTitle();
    }

    public ProjectEntity() {
    }

    @Override
    public Project mapToDomain() {
        return new Project(this.shortIntroduction, this.title);
    }
}
