package com.application.user;

import com.domain.model.User;

import java.util.Optional;

public interface UserRepository {
    public Optional<User> findUser(String username);
    public void updateUser(User user);
    public Long createUser(User user);
}
