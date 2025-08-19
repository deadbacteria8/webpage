package com.infrastructure.Database.repository.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import com.infrastructure.Database.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Repository
public interface JpaUserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsername(String username);
}