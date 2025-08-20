package com.application.about;

import com.domain.model.About;
import org.springframework.stereotype.Service;

@Service
public class AboutService {

    private AboutRepository aboutRepository;

    public AboutService(AboutRepository aboutRepository) {
        this.aboutRepository = aboutRepository;
    }

    public void createAbout(String shortIntroduction, String username) {
        About about = new About(shortIntroduction);
        aboutRepository.createAbout(about, username);
    }
    //If app develops with multiple different portfolio owners, this should have username input to find specific about for specific user
    //now it will just collect the first one in the db
    public About getAbout() {
        return aboutRepository.getFirstAbout();
    }
}
