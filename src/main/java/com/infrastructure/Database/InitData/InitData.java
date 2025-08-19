package com.infrastructure.Database.InitData;

import com.application.about.AboutService;
import com.application.user.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;


@Configuration
public class InitData implements CommandLineRunner {
    @Value("${admin.password}")
    private String password;
    @Value("${admin.username}")
    private String username;
    private final UserService userService;
    private final AboutService aboutService;
    public InitData(UserService userService, AboutService aboutService) {
        this.userService = userService;
        this.aboutService = aboutService;
    }
    @Override
    public void run(String... args) throws Exception {
        try {
            userService.createUser(this.username, this.password);
            aboutService.createAbout("Introduction", this.username);
        } catch (IllegalStateException e) {
            //means user already exists
            System.out.println(e.getMessage());
        }
    }
}

