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
}
