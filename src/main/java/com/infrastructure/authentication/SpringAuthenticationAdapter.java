package com.infrastructure.authentication;

import com.application.login.AuthenticationPort;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class SpringAuthenticationAdapter implements AuthenticationPort {
    private AuthenticationManager authenticationManager;

    public SpringAuthenticationAdapter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    public Boolean login(String username, String password) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password));
        return authentication.isAuthenticated();
    }
}
