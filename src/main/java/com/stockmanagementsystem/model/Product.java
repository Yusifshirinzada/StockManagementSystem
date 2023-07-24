package com.stockmanagementsystem.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(nullable = false)
    private String name;

    private String model;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "categoryId",referencedColumnName = "categoryId",nullable = false)
    private Category category;


    @Override
    public String toString() {
        return "Product Table:" +
                "\nproductId=" + productId +
                "\nname= " + name +
                "\nmodel= " + model +
                "\nprice= " + price +
                "\nstock= " + stock +
                "\ncategory = " + category;
    }
}
