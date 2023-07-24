package com.stockmanagementsystem.controllers;

import com.stockmanagementsystem.controllers.requests.LoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Component
public class UserController {

    private final LoggedIn loggedIn;

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest){
       return loggedIn.loggedCheck(loginRequest);
    }

    @GetMapping("/logout")
    public String logOut(){
        return loggedIn.logOut();
    }
}
