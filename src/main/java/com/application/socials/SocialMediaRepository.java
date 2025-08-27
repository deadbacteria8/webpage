package com.application.socials;

import com.domain.model.Socials;

public interface SocialMediaRepository {
    public Long createSocials(Socials socials, Long id);
}
