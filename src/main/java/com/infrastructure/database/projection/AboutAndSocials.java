package com.infrastructure.database.projection;


import com.application.dto.FullAbout;
import com.infrastructure.database.entities.AboutEntity;
import com.infrastructure.database.entities.SocialsEntity;

public class AboutAndSocials {
    private AboutEntity aboutEntity;
    private SocialsEntity socialsEntity;
    public AboutAndSocials(AboutEntity aboutEntity, SocialsEntity socialsEntity) {
        this.aboutEntity = aboutEntity;
        this.socialsEntity = socialsEntity;
    }

    public AboutEntity getAboutEntity() {
        return aboutEntity; }

    public SocialsEntity getSocialsEntity() {
        return socialsEntity;
    }

    public FullAbout mapToDto() {
        return new FullAbout(socialsEntity.mapToDomain(), aboutEntity.mapToDomain());
    }
}
