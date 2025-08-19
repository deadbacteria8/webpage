package com.infrastructure.Database.model;
import com.domain.model.About;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class AboutEntity extends EntityBase<About> {

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity userEntity;

    private String shortIntroduction;
    public AboutEntity(About about, UserEntity userEntity) {
        this.userEntity = userEntity;
        this.shortIntroduction = about.getShortIntroduction();
    }

    public AboutEntity() {

    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public String getShortIntroduction() {
        return shortIntroduction;
    }

    @Override
    public About mapToDomain() {
        return new About(this.shortIntroduction);
    }
}
