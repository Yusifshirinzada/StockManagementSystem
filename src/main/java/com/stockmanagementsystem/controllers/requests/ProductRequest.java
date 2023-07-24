package com.stockmanagementsystem.controllers.requests;

import com.stockmanagementsystem.model.Category;
import com.stockmanagementsystem.model.Product;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductRequest {

    private Long id;
    private String name;
    private String model;
    private Integer price;
    private Integer stock;
    private Category categoryId;
}
