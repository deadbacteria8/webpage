package com.infrastructure.security.jwt;

import com.infrastructure.security.userdetails.UserInfoService;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Disabling global registration of jwtFilter as it should not be applied to every request
@Configuration
public class DisableGlobalRegistrationForJwtFilter {

    @Bean
    public JwtFilter jwtFilter(UserInfoService userInfoService, JwtService jwtService) {
        return new JwtFilter(userInfoService, jwtService);
    }
    @Bean
    public FilterRegistrationBean<JwtFilter> jwtFilterRegistration(JwtFilter filter) {
        FilterRegistrationBean<JwtFilter> registration = new FilterRegistrationBean<>(filter);
        registration.setEnabled(false);
        return registration;
    }
}
