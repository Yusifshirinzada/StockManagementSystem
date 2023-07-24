package com.stockmanagementsystem.service.impl;

import com.stockmanagementsystem.controllers.CategoryController;
import com.stockmanagementsystem.controllers.LoggedIn;
import com.stockmanagementsystem.model.Category;
import com.stockmanagementsystem.repository.CategoryRepository;
import com.stockmanagementsystem.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final LoggedIn loggedIn;

    @Override
    public String add(String categoryName) {
        if (categoryName.isEmpty()) {
            return "Write a category name.";
        }
        try {
            int userRoleId = loggedIn.user.getRole().getId();
            if (userRoleId == 1) {
                if (categoryRepository.findByName(categoryName) == null) {
                    Category category = Category.builder()
                            .name(categoryName)
                            .build();
                    categoryRepository.save(category);
                    return categoryName + " Category added.";
                } else {
                    return categoryName + " Category already exists";
                }
            } else {
                return "You do not have the authority to add a category";
            }
        } catch (NullPointerException e) {
            return "Not entered!";
        }
    }

    @Override
    public String delete(String categoryName) {
        if (categoryName.isEmpty()) {
            return "Write a category name.";
        }
        try {
            int userRoleId = loggedIn.user.getRole().getId();
            if (userRoleId == 1) {
                try {
                    Category category = categoryRepository.findByName(categoryName);
                    categoryRepository.deleteById(category.getCategoryId());
                    return categoryName + " has been delete.";
                } catch (NullPointerException e) {
                    return "Category not found.";
                }
            } else {
                return "You do not have the authority to delete a category!";
            }
        } catch (NullPointerException e) {
            return "Not entered.";
        }
    }

    @Override
    public String rename(String categoryName,String newCategoryName) {
        if (categoryName.isEmpty()||newCategoryName.isEmpty()) {
            return "Write a category name.";
        }

        try {
            int userRoleId = loggedIn.user.getRole().getId();
            if (userRoleId == 1) {
                try {
                    Category category = categoryRepository.findByName(categoryName);
                    category.setName(newCategoryName);
                    categoryRepository.save(category);
                    return categoryName + " has been renamed to "+newCategoryName;
                } catch (NullPointerException e) {
                    return "Category not found.";
                }
            } else {
                return "You do not have the authority to delete a category!";
            }
        } catch (NullPointerException e) {
            return "Not entered.";
        }

    }

    @Override
    public String showAllCategories() {
        List<Category> categories=categoryRepository.findAll();
        StringBuilder showCategories=new StringBuilder();
        for (int i=0;i<categories.size();i++){
            showCategories.append(categories.get(i).getName()).append("\n");
        }
        return showCategories.toString().trim();
    }


}
