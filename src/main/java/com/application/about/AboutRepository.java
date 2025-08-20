package com.application.about;


import com.domain.model.About;

public interface AboutRepository {
    public void createAbout(About about, String username);
    public About getFirstAbout();
}
