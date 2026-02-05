package com.application.socials;

import com.domain.models.Socials;

public interface SocialMediaRepository {
    public Long createSocials(Socials socials, Long id);
}
