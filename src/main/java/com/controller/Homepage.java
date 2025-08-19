package com.controller;
import com.domain.model.FullAbout;
import com.application.Homepage.AboutDataDistributor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class Homepage {

    private final AboutDataDistributor homePageData;

    public Homepage(AboutDataDistributor homePageData) {
        this.homePageData = homePageData;
    }

    @GetMapping("/getdata")
    public String sayHello() {
        return homePageData.getData();
    }


}