package com.controller;
import com.application.login.LoginService;
import com.controller.requestData.LoginRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }
    @PostMapping("/login")
    public String adminLogin(@RequestBody LoginRequest loginRequest) {
        return loginService.login(loginRequest.username(), loginRequest.password());
    }

}
