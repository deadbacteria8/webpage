package com.application.About;


import com.domain.model.About;
import com.application.dto.FullAbout;

public interface AboutRepository {
    public void createAbout(About about, Long id);
    public About getFirstAbout();
    public FullAbout getFullAboutFromUsername(String username);
}
