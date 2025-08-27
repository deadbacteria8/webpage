package com.infrastructure.database.repository.about;

import com.infrastructure.database.entities.AboutEntity;
import com.infrastructure.database.projection.AboutAndSocials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaAboutRepository extends JpaRepository<AboutEntity, Long> {
    AboutEntity findFirstByOrderByIdDesc();

    @Query("""
    SELECT a, s
    FROM AboutEntity a
    JOIN a.userEntity u
    JOIN SocialsEntity s ON s.userEntity = a.userEntity
    WHERE u.id = :id
    """)
    AboutAndSocials findAboutAndSocialsById(Long id);
}


