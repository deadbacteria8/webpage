package com.infrastructure.database.repository.about;

import com.application.About.AboutRepository;
import com.domain.model.About;
import com.application.dto.FullAbout;
import com.infrastructure.database.entities.AboutEntity;
import com.infrastructure.database.entities.UserEntity;
import com.infrastructure.database.repository.user.JpaUserRepository;
import org.springframework.stereotype.Repository;


@Repository
public class AboutRepositoryImpl implements AboutRepository {
    private final JpaAboutRepository jpaAboutRepository;
    private final JpaUserRepository jpaUserRepository;
    public AboutRepositoryImpl(JpaAboutRepository jpaAboutRepository, JpaUserRepository jpaUserRepository) {
        this.jpaAboutRepository = jpaAboutRepository;
        this.jpaUserRepository = jpaUserRepository;
    }

    public void createAbout(About about, Long id) {
        UserEntity user = jpaUserRepository.findById(id).get();
        AboutEntity aboutEntityDbo = new AboutEntity(about, user);
        jpaAboutRepository.save(aboutEntityDbo);
    }

    public FullAbout getFullAboutFromUsername(String username) {
        UserEntity user = jpaUserRepository.findByUsername(username).get();
        return (jpaAboutRepository.findAboutAndSocialsById(user.getId())).mapToDto();
    }

    public About getFirstAbout() {
        AboutEntity aboutEntity = jpaAboutRepository.findFirstByOrderByIdDesc();
        return aboutEntity.mapToDomain();
    }
}
