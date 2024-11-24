package com.example.EventCenter.Service;

import com.example.EventCenter.Entity.Category;
import com.example.EventCenter.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository eventCategoryRepository;


    @Autowired
    public CategoryService(CategoryRepository eventCategoryRepository) {
        this.eventCategoryRepository = eventCategoryRepository;
    }

    public List<Category> getAllCategories() {
        return eventCategoryRepository.findAll();
    }
}

