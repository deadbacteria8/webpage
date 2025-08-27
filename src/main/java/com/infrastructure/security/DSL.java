package com.infrastructure.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;

public class DSL extends AbstractHttpConfigurer<DSL, HttpSecurity> {
    @Override
    public void init(HttpSecurity http) throws Exception {
        http
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                //stateless app so no csrf
                .csrf(AbstractHttpConfigurer::disable);
    }

    public static DSL customDsl() {
        return new DSL();
    }
}