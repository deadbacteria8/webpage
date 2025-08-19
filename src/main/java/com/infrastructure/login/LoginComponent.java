package com.infrastructure.login;

import com.application.login.LoginInterface;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class LoginComponent implements LoginInterface {
    private AuthenticationManager authenticationManager;

    public LoginComponent(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    public Boolean login(String username, String password) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password));
        return authentication.isAuthenticated();
    }
}
