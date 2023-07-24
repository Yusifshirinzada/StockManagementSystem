package com.stockmanagementsystem.service.impl;

import com.stockmanagementsystem.controllers.LoggedIn;
import com.stockmanagementsystem.controllers.requests.ProductRequest;
import com.stockmanagementsystem.model.Product;
import com.stockmanagementsystem.repository.ProductRepository;
import com.stockmanagementsystem.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
        if(product.getName().isEmpty()|| product.getPrice()==null || product.getStock()==null || product.getCategory()==null){
            return "Name,price or stock is empty";
        }

        productRepository.save(product);

        return product.getName()+" added to Products list.";
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

        return product.getName()+" has been deleted";

    }

    @Override
    public String updateProduct(Long id, ProductRequest productRequest) {
        if (loggedIn == null || loggedIn.user == null) {
            return "Not entered";
        }

        if (id == null || productRequest == null) {
            return "Id or Product information is empty";
        }

        Optional<Product> findProduct = productRepository.findById(id);
        if (findProduct.isEmpty()) {
            return "Product not found";
        }


        if (productRequest.getName() != null && !productRequest.getName().isEmpty()) {
            findProduct.get().setName(productRequest.getName());
        }
        if (productRequest.getModel() != null) {
            findProduct.get().setModel(productRequest.getModel());
        }
        if (productRequest.getPrice() != null) {
            findProduct.get().setPrice(productRequest.getPrice());
        }
        if (productRequest.getStock() != null) {
            findProduct.get().setStock(productRequest.getStock());
        }
        if (productRequest.getCategoryId() != null) {
            findProduct.get().setCategory(productRequest.getCategoryId());
        }

        productRepository.save(findProduct.get());
        return "Product " + findProduct.get().getName() + " updated";
    }

    @Override
    public List<Product> showAll() {
        if (loggedIn == null || loggedIn.user == null) {
            return new ArrayList<>();
        }

        List<Product> products=productRepository.findAll();
        return products;
    }


}
