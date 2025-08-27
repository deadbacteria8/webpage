package com.application.About;

import com.application.dto.FullAbout;
import com.domain.model.About;
import org.springframework.stereotype.Service;

@Service
public class AboutService {

    private AboutRepository aboutRepository;

    public AboutService(AboutRepository aboutRepository) {
        this.aboutRepository = aboutRepository;
    }

    public void createAbout(String shortIntroduction, Long id) {
        About about = new About(shortIntroduction);
        aboutRepository.createAbout(about, id);
    }

    public About getAbout() {
        return aboutRepository.getFirstAbout();
    }

    public FullAbout getFullAboutByUsername(String username) {
        return aboutRepository.getFullAboutFromUsername(username);
    }
}
