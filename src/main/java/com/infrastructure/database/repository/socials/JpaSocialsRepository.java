package com.infrastructure.database.repository.socials;

import com.infrastructure.database.entities.SocialsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaSocialsRepository extends JpaRepository<SocialsEntity, Long> {
}
