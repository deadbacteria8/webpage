package com.infrastructure.Database.repository.About;

import com.application.about.AboutRepository;
import com.infrastructure.Database.model.AboutEntity;
import com.infrastructure.Database.model.UserEntity;
import com.infrastructure.Database.repository.User.JpaUserRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Repository
public class AboutRepositoryImpl implements AboutRepository {
    private JpaAboutRepository jpaAboutRepository;
    private JpaUserRepository jpaUserRepository;
    public AboutRepositoryImpl(JpaAboutRepository jpaAboutRepository, JpaUserRepository jpaUserRepository) {
        this.jpaAboutRepository = jpaAboutRepository;
        this.jpaUserRepository = jpaUserRepository;
    }

    @Override
    public void createAbout(com.domain.model.About about, String username) {
        UserEntity user = jpaUserRepository.findByUsername(username).get();
        AboutEntity aboutEntityDbo = new AboutEntity(about, user);
        jpaAboutRepository.save(aboutEntityDbo);
    }
}
