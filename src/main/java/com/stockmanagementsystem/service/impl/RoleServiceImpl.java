package com.stockmanagementsystem.service.impl;

import com.stockmanagementsystem.controllers.LoggedIn;
import com.stockmanagementsystem.model.Category;
import com.stockmanagementsystem.model.Role;
import com.stockmanagementsystem.repository.RoleRepository;
import com.stockmanagementsystem.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final LoggedIn loggedIn;
    private final RoleRepository roleRepository;

    @Override
    public String add(String roleName) {
        if(loggedIn==null||loggedIn.user==null){
            return "Not entered";
        }

        int userRoleId = loggedIn.user.getRole().getId();

        if (!(userRoleId == 1)) {
            return "You do not have the authority to add a role!";
        }
        if (roleName.isEmpty()) {
            return "Write a role name.";
        }

        Optional<Role> checkRole=roleRepository.findByRoleName(roleName);
        if(!checkRole.isEmpty()){
            return roleName + " Role already exists";
        }

        Role role = Role.builder()
                .roleName(roleName)
                .build();
        roleRepository.save(role);
        return roleName+ " Role added.";
    }

    @Override
    public String delete(String roleName) {
        if(loggedIn==null||loggedIn.user==null){
            return "Not entered";
        }

        int userRoleId = loggedIn.user.getRole().getId();

        if (!(userRoleId == 1)) {
            return "You do not have the authority to delete a role!";
        }
        if (roleName.isEmpty()) {
            return "Write a role name.";
        }

        Optional<Role> checkRole=roleRepository.findByRoleName(roleName);
        if(checkRole.isEmpty()){
            return "Role not found";
        }

        roleRepository.delete(checkRole.get());

        return "Role "+checkRole.get().getRoleName()+" has been delete.";
    }

    @Override
    public String update(String roleName, String newRoleName) {
        if(loggedIn==null||loggedIn.user==null){
            return "Not entered";
        }

        int userRoleId = loggedIn.user.getRole().getId();

        if (!(userRoleId == 1)) {
            return "You do not have the authority to delete a role!";
        }
        if (roleName.isEmpty()) {
            return "Write a role name.";
        }

        Optional<Role> checkRole=roleRepository.findByRoleName(roleName);
        if(checkRole.isEmpty()){
            return "Role "+roleName+" not found";
        }

        checkRole.get().setRoleName(newRoleName);
        roleRepository.save(checkRole.get());

        return "Role "+roleName+" has been updated to "+newRoleName;

    }

    @Override
    public List<Role> showAll() {
        if(loggedIn==null||loggedIn.user==null || !(loggedIn.user.getRole().getId() == 1)){
            return new ArrayList<>();
        }

        List<Role> roles=roleRepository.findAll();

        return roles;
    }


}
