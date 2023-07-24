package com.stockmanagementsystem.service.impl;

import com.stockmanagementsystem.controllers.CategoryController;
import com.stockmanagementsystem.controllers.LoggedIn;
import com.stockmanagementsystem.model.Category;
import com.stockmanagementsystem.repository.CategoryRepository;
import com.stockmanagementsystem.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final LoggedIn loggedIn;

    @Override
    public String add(String categoryName) {
        if(loggedIn==null||loggedIn.user==null){
            return "Not entered";
        }

        int userRoleId = loggedIn.user.getRole().getId();

        if (!(userRoleId == 1)) {
            return "You do not have the authority to add a category!";
        }
        if (categoryName.isEmpty()) {
            return "Write a category name.";
        }

        Optional<Category> checkCategory=categoryRepository.findByName(categoryName);

        if(!checkCategory.isEmpty()) {
            return categoryName + " Category already exists";
        }

        Category category = Category.builder()
                            .name(categoryName)
                            .build();
        categoryRepository.save(category);
        return categoryName + " Category added.";
    }

    @Override
    public String delete(String categoryName) {

        if(loggedIn==null||loggedIn.user==null){
            return "Not entered";
        }

        int userRoleId = loggedIn.user.getRole().getId();

        if (!(userRoleId == 1)) {
            return "You do not have the authority to delete a category!";
        }

        if (categoryName.isEmpty()) {
            return "Write a category name.";
        }

        Optional<Category> category=categoryRepository.findByName(categoryName);

        if(category.isEmpty()){
            return "Category not found.";
        }

        categoryRepository.delete(category.get());
        return categoryName + " has been delete.";
    }

    @Override
    public String update(String categoryName,String newCategoryName) {

        if(loggedIn==null||loggedIn.user==null){
            return "Not entered";
        }

        int userRoleId = loggedIn.user.getRole().getId();

         if (!(userRoleId == 1)) {
             return "You do not have the authority to delete a category!";
         }

        if (categoryName.isEmpty()||newCategoryName.isEmpty()) {
            return "Write a category name.";
        }

         Optional<Category> category = categoryRepository.findByName(categoryName);
         if(category.isEmpty()){
             return "Category not found.";
         }

         category.get().setName(newCategoryName);
         categoryRepository.save(category.get());
         return categoryName + " has been renamed to "+newCategoryName;

    }

    @Override
    public List<Category> showAllCategories() {
        if(loggedIn==null||loggedIn.user==null){
            System.out.println("Not entered");
            return new ArrayList<>();
        }
        List<Category> categories=categoryRepository.findAll();

        return categories;
    }


}
