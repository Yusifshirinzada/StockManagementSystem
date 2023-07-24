package com.stockmanagementsystem.controllers;

import com.stockmanagementsystem.controllers.requests.LoginRequest;
import com.stockmanagementsystem.model.User;
import com.stockmanagementsystem.repository.UserRepository;
import com.stockmanagementsystem.service.LoginService;
import com.stockmanagementsystem.service.impl.LoginServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LoggedIn {
    private final UserRepository userRepository;
    private final LoginService loginService;

    public User user;


    public String loggedCheck(LoginRequest loginRequest) {
        if (loginService.loginCheck(loginRequest.getUserName(), loginRequest.getPassword()) == true) {
            user = userRepository.findByUserNameAndPassword(loginRequest.getUserName(), loginRequest.getPassword());
            return "Login successfully.";
        } else {
            user = null;
            return "Login or password is wrong.";
        }
    }

    public String logOut() {
        user = null;
        return "Successfully logged out.";
    }

}
