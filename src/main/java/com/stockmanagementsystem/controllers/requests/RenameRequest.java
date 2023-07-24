package com.stockmanagementsystem.controllers.requests;

import lombok.Data;

import java.util.Map;

@Data
public class RenameRequest {
    private Map<String, String> categoryName;
    private Map<String, String> newCategoryName;
}
