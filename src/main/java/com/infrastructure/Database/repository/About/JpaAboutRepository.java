package com.infrastructure.Database.repository.About;

import com.infrastructure.Database.model.AboutEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaAboutRepository extends JpaRepository<AboutEntity, Long> {
}


