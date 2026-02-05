package com.infrastructure.database.entities;


import com.domain.models.Socials;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class SocialsEntity extends EntityBase<Socials> {
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity userEntity;
    private String githubAcc;
    private String linkedInAcc;
    public SocialsEntity(Socials socials, UserEntity userEntity) {
        this.userEntity = userEntity;
        this.githubAcc = socials.getGithubAcc();
        this.linkedInAcc = socials.getLinkedInAcc();
    }

    public SocialsEntity() {}

    @Override
    public Socials mapToDomain() {
        return new Socials(githubAcc, linkedInAcc);
    }
}
