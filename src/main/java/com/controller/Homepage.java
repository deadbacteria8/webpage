package com.controller;
import com.application.about.AboutService;
import com.domain.model.About;
import com.domain.model.FullAbout;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/portfolio")
public class Homepage {

    private final AboutService aboutService;

    public Homepage(AboutService aboutService) {
        this.aboutService = aboutService;
    }

    @GetMapping("/about")
    public About sayHello() {
        return aboutService.getAbout();
    }


}