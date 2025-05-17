package com.bony.blog_application.services.Impl;

import com.bony.blog_application.domain.entity.Category;
import com.bony.blog_application.repositories.CategoryRepository;
import com.bony.blog_application.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> listCategories() {
        return categoryRepository.findAll();
    }
}
