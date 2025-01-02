package com.example.EventCenter.Controller;

import com.example.EventCenter.Entity.Category;
import com.example.EventCenter.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/events")
public class CategoryController {

    private final CategoryService eventCategoryService;

    @Autowired
    public CategoryController(CategoryService eventCategoryService) {
        this.eventCategoryService = eventCategoryService;
    }

    @GetMapping("/categories")
    public List<Category> getCategories() {
        return eventCategoryService.getAllCategories();
    }
    }





