package com.stockmanagementsystem.controllers;

import com.stockmanagementsystem.model.Role;
import com.stockmanagementsystem.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/role")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @PostMapping("/add")
    public String add(@RequestBody Map<String,String> roleName){
        return roleService.add(roleName.get("roleName"));
    }

    @PostMapping("/delete")
    public String delete(@RequestBody Map<String ,String> roleName){
        return roleService.delete(roleName.get("roleName"));
    }

    @PostMapping("/update")
    public String update(@RequestBody Map<String,String> requestBody){
        return roleService.update(requestBody.get("roleName"),requestBody.get("newRoleName"));
    }

    @GetMapping("/showAll")
    public List<Role> showAll(){
        return roleService.showAll();
    }

}
