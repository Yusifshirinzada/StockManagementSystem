package com.stockmanagementsystem.service;

import com.stockmanagementsystem.model.Role;

import java.util.List;

public interface RoleService {
    String add(String roleName);
    String delete(String roleName);
    String update(String roleName,String newRoleName);
    List<Role> showAll();
}
