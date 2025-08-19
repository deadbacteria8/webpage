package com.application.login;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

@Service
public class Login {
    private LoginInterface loginInterface;
    private LoginToken loginToken;
    public Login(LoginInterface loginInterface, LoginToken loginToken) {
        this.loginToken = loginToken;
        this.loginInterface = loginInterface;
    }

    public String login(String username, String password)  throws BadCredentialsException  {
        if (!this.loginInterface.login(username, password)) {
            throw new BadCredentialsException(username);
        }
        return loginToken.generateToken(username);
    }
}
