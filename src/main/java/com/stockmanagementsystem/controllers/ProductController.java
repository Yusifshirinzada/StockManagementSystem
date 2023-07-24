package com.stockmanagementsystem.controllers;

import com.stockmanagementsystem.controllers.requests.ProductRequest;
import com.stockmanagementsystem.model.Product;
import com.stockmanagementsystem.service.impl.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductServiceImpl productService;

    @PostMapping("/add")
    public String add(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @PostMapping("/delete")
    public String delete(@RequestBody ProductRequest productRequest){
       return productService.deleteProduct(productRequest.getId());
    }
}
