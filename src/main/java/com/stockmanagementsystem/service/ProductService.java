package com.stockmanagementsystem.service;

import com.stockmanagementsystem.controllers.requests.ProductRequest;
import com.stockmanagementsystem.model.Product;

import java.util.List;

public interface ProductService {
    String addProduct(Product product);
    String deleteProduct(Long id);
    String updateProduct(Long id, ProductRequest productRequest);
    List<Product> showAll();
}
