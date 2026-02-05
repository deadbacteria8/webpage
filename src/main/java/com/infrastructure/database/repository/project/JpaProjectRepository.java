package com.infrastructure.database.repository.project;


import com.infrastructure.database.entities.ProjectEntity;
import com.infrastructure.database.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaProjectRepository extends JpaRepository<ProjectEntity, Long> {
}