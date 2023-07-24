package com.stockmanagementsystem.service;

import com.stockmanagementsystem.model.Product;

public interface ProductService {
    String addProduct(Product product);
    String deleteProduct(Long id);
}
