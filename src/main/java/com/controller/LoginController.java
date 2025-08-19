package com.controller;
import com.application.login.Login;
import com.controller.requestData.LoginRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    private final Login login;

    public LoginController(Login login) {
        this.login = login;
    }
    @PostMapping("/login")
    public String adminLogin(@RequestBody LoginRequest loginRequest) {
        return login.login(loginRequest.username(), loginRequest.password());
    }

}
