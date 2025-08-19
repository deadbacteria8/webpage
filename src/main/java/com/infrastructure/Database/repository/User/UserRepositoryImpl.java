package com.infrastructure.Database.repository.User;

import com.application.user.UserRepository;
import com.domain.model.User;
import com.infrastructure.Database.model.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.NoSuchElementException;
import java.util.Optional;


@Repository
public class UserRepositoryImpl implements UserRepository {
    private JpaUserRepository jpaUserRepository;
    public UserRepositoryImpl(JpaUserRepository jpaUserRepository) {
        this.jpaUserRepository = jpaUserRepository;
    }

    public Optional<User> findUser(String username) {
        return jpaUserRepository.findByUsername(username).map(UserEntity::mapToDomain);
    }

    public void createUser(User user) {
        UserEntity dbo = new UserEntity(user);
        jpaUserRepository.save(dbo);
    }

    public void updateUser(User user) {
        UserEntity userEntity = jpaUserRepository.findByUsername(user.getUsername()).get();
        userEntity.mapToOrm(user);
    }

}
