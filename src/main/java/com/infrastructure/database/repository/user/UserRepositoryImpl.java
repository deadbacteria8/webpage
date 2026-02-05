package com.infrastructure.database.repository.user;

import com.application.user.UserRepository;
import com.domain.models.User;
import com.infrastructure.database.entities.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public class UserRepositoryImpl implements UserRepository {
    private final JpaUserRepository jpaUserRepository;
    public UserRepositoryImpl(JpaUserRepository jpaUserRepository) {
        this.jpaUserRepository = jpaUserRepository;
    }

    public Optional<User> findUser(String username) {
        return jpaUserRepository.findByUsername(username).map(UserEntity::mapToDomain);
    }

    public Long createUser(User user) {
        UserEntity dbo = new UserEntity(user);
        jpaUserRepository.save(dbo);
        return dbo.getId();
    }

    public void updateUser(User user) {
        UserEntity userEntity = jpaUserRepository.findByUsername(user.getUsername()).get();
        userEntity.mapToOrm(user);
    }

}
