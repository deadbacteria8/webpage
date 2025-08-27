package com.infrastructure.security.userdetails;

import com.infrastructure.database.entities.UserEntity;
import com.infrastructure.database.repository.user.JpaUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

//Component because its not handling business logic
@Component
public class UserInfoService implements UserDetailsService {
    private JpaUserRepository userRepository;
    public UserInfoService(JpaUserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) {
        UserEntity user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return new UserInfoDetails(user.getUsername(), user.getPassword(), user.getRole(), user.getId());
    }
}
