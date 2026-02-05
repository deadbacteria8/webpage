package com.infrastructure.database.repository.socials;

import com.application.socials.SocialMediaRepository;
import com.domain.models.Socials;
import com.infrastructure.database.entities.SocialsEntity;
import com.infrastructure.database.entities.UserEntity;
import com.infrastructure.database.repository.user.JpaUserRepository;
import org.springframework.stereotype.Repository;

@Repository
public class SocialMediaRepositoryImpl implements SocialMediaRepository {
    private final JpaSocialsRepository jpaSocialsRepository;
    private final JpaUserRepository jpaUserRepository;

    public SocialMediaRepositoryImpl(JpaSocialsRepository jpaSocialsRepository, JpaUserRepository jpaUserRepository) {
        this.jpaSocialsRepository = jpaSocialsRepository;
        this.jpaUserRepository = jpaUserRepository;
    }

    public Long createSocials(Socials socials, Long id) {
        UserEntity userEntity = jpaUserRepository.findById(id).get();
        SocialsEntity socialsEntity = new SocialsEntity(socials, userEntity);
        jpaSocialsRepository.save(socialsEntity);
        return socialsEntity.getId();
    }
}
