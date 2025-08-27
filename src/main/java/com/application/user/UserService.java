package com.application.user;

import com.domain.model.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    public Long createUser(String username, String password) {
        if((userRepository.findUser(username)).isPresent()) {
            throw new IllegalStateException("User already exists");
        }
        String secretPassword = passwordEncoder.encode(password);
        User newUser = new User(username,secretPassword,"ADMIN");
        //Returns id
        return userRepository.createUser(newUser);
    }
}
