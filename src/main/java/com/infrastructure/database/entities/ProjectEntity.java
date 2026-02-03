package com.infrastructure.database.entities;
import com.domain.model.About;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.util.Set;

@Entity
public class Projects extends EntityBase<About> {

    @OneToMany
    @JoinColumn(name = "user_id", nullable = false)
    private Set<UserEntity> userEntity;

    private String shortIntroduction;
    public Projects(UserEntity userEntity) {

    }

    public Projects() {
    }

    @Override
    public About mapToDomain() {
        return new About(this.shortIntroduction);
    }
}
