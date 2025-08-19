package com.infrastructure.Database.model;
import jakarta.persistence.*;
import com.domain.model.User;

@Entity
public class UserEntity extends EntityBase<User>{


    public User mapToDomain() {
        return new User(this.username, this.password, this.role);
    }
    private String password;
    @Column(unique = true)
    private String username;
    private String role;
    public UserEntity(User user) {
        this.password = user.getPassword();
        this.username = user.getUsername();
        this.role = user.getRole();
    }

    public UserEntity(){}

    public String getPassword() {
        return this.password;
    }

    public String getUsername() {
        return this.username;
    }

    public String getRole() {
        return this.role;
    }

    public void mapToOrm(User user) {
        this.password = user.getPassword();
        this.username = user.getUsername();
    }
}
