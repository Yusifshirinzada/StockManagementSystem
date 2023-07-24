package com.stockmanagementsystem.service;

import com.stockmanagementsystem.model.User;
import org.springframework.stereotype.Service;
public interface LoginService {

    public boolean loginCheck(String userName, String password);


}
