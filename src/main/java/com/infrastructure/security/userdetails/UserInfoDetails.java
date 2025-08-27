package com.infrastructure.security.userdetails;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UserInfoDetails implements UserDetails {
    private final String username;
    private final String password;
    private final List<GrantedAuthority> authorities;
    private final Long id;
    public UserInfoDetails(String username, String password, String role, Long id) {
        this.username = username;
        this.password = password;
        this.id = id;
        this.authorities = List.of(new SimpleGrantedAuthority(role));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public Long getId() {
        return id;
    }


}