package com.controller;
import com.application.About.AboutService;
import com.application.dto.FullAbout;
import com.domain.model.About;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/portfolio")
public class Homepage {

    private final AboutService aboutService;

    public Homepage(AboutService aboutService) {
        this.aboutService = aboutService;
    }

    @GetMapping("/{username}/about")
    public FullAbout fullAbout(@PathVariable String username) {
        return aboutService.getFullAboutByUsername(username);
    }


}