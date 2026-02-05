package com.application.socials;

import com.domain.models.Socials;
import org.springframework.stereotype.Service;

@Service
public class SocialMediaService {
    private final SocialMediaRepository socialMediaRepository;

    public SocialMediaService(SocialMediaRepository socialMediaRepository) {
        this.socialMediaRepository = socialMediaRepository;
    }
    public Long createSocials(String githubAcc, String linkedInAcc, Long id) {
        Socials socials = new Socials(githubAcc, linkedInAcc);
        return socialMediaRepository.createSocials(socials, id);
    }
}
