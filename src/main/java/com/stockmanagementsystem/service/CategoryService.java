package com.stockmanagementsystem.service;

import com.stockmanagementsystem.model.Category;
import com.stockmanagementsystem.model.User;

import java.util.List;
import java.util.Map;

public interface CategoryService {
    String add(String categoryName);
    String delete(String categoryName);
    String update(String categoryName,String newCategoryName);
    List<Category> showAllCategories();
}
