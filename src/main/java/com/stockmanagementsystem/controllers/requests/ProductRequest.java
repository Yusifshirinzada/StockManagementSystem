package com.stockmanagementsystem.controllers.requests;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductRequest {
    private Long id;
    private String name;
}
