package com.application.login;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private AuthenticationPort authenticationPort;
    private TokenGenerator tokenGenerator;
    public LoginService(AuthenticationPort authenticationPort, TokenGenerator tokenGenerator) {
        this.tokenGenerator = tokenGenerator;
        this.authenticationPort = authenticationPort;
    }

    public String login(String username, String password)  throws BadCredentialsException  {
        if (!this.authenticationPort.login(username, password)) {
            throw new BadCredentialsException(username);
        }
        return tokenGenerator.generateToken(username);
    }
}
