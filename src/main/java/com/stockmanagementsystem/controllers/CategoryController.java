package com.stockmanagementsystem.controllers;

import com.stockmanagementsystem.controllers.requests.RenameRequest;
import com.stockmanagementsystem.model.Category;
import com.stockmanagementsystem.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    private final LoggedIn loggedIn;

    @PostMapping("/add")
    public String addCategory(@RequestBody Map<String, String> categoryName) {
        return categoryService.add(categoryName.get("categoryName"));
    }

    @PostMapping("/delete")
    public String deleteCategory(@RequestBody Map<String, String> categoryName) {
        return categoryService.delete(categoryName.get("categoryName"));
    }

    @PostMapping("/rename")
    public String renameCategory(@RequestBody RenameRequest request) {
        return categoryService.rename(request.getCategoryName().get("categoryName"), request.getNewCategoryName().get("newCategoryName"));
    }

    @GetMapping("/allcategories")
    public String showAllCategories(){
        return categoryService.showAllCategories();
    }
}
