package com.stockmanagementsystem.service.impl;

import com.stockmanagementsystem.controllers.LoggedIn;
import com.stockmanagementsystem.model.Product;
import com.stockmanagementsystem.repository.ProductRepository;
import com.stockmanagementsystem.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final LoggedIn loggedIn;

    @Override
    public String addProduct(Product product) {
        if(loggedIn==null||loggedIn.user==null){
            return "Not entered.";
        }
        if(product.getName().isEmpty()|| product.getPrice()==null || product.getStock()==null){
            return "Name,price or stock is empty";
        }

        productRepository.save(product);

        return product.getName()+" added to database.";
    }

    @Override
    public String deleteProduct(Long id) {


        if(loggedIn==null || loggedIn.user==null){
            return "Not entered";
        }

        if(id==null){
            return "Id is empty";
        }

        Optional<Product> optionalProduct=productRepository.findById(id);
        if(optionalProduct.isEmpty()){
            return "Product with id:"+id+" not found";
        }

        Product product=optionalProduct.get();

        productRepository.delete(product);

        return product.getName()+" was deleted.";

    }
}
