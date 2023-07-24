package com.stockmanagementsystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false,unique = true)
    private String userName;

    @Column(nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "roleId",referencedColumnName = "id",nullable = false)
    private Role role;

//    @Override
//    public String toString() {
//        return "User :" +
//                "\nuserId= " + userId +
//                "\nuserName= " + userName  +
//                "\npassword= " + password  +
//                "\nrole= " + role;
//    }
}
