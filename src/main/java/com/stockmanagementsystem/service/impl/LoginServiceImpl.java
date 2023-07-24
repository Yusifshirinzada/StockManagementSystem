package com.stockmanagementsystem.service.impl;

import com.stockmanagementsystem.model.User;
import com.stockmanagementsystem.repository.UserRepository;
import com.stockmanagementsystem.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final UserRepository userRepository;

    @Override
    public boolean loginCheck(String userName, String password) {
         User u=userRepository.findByUserNameAndPassword(userName,password);
         return u==null?false:true;
    }
}
