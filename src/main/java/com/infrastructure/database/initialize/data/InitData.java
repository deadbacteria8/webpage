package com.infrastructure.database.initialize.data;

import com.application.About.AboutService;
import com.application.socials.SocialMediaRepository;
import com.application.socials.SocialMediaService;
import com.application.user.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;


@Configuration
public class InitData implements CommandLineRunner {
    private final String username = "deadbacteria8";
    @Value("${admin.password}")
    private String password;
    private final UserService userService;
    private final AboutService aboutService;
    private final SocialMediaService socialMediaService;

    public InitData(UserService userService, AboutService aboutService, SocialMediaService socialMediaService) {
        this.userService = userService;
        this.aboutService = aboutService;
        this.socialMediaService = socialMediaService;
    }
    @Override
    public void run(String... args) throws Exception {
        try {
            Long id = userService.createUser(this.username, this.password);
            aboutService.createAbout("Hey my name is Olle. I have the acronym of deadbacteria8", id);
            socialMediaService.createSocials("deadbacteria8", "olle-frid-a72191219", id);
        } catch (IllegalStateException e) {
            //means user already exists
            System.out.println(e.getMessage());
        }
    }
}

