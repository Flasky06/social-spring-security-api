package com.bony.blog_application.services.Impl;

import com.bony.blog_application.domain.entity.Category;
import com.bony.blog_application.repositories.CategoryRepository;
import com.bony.blog_application.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> listCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category createCategory(Category category) {
        String categoryName = category.getName();

        if (categoryRepository.existsByNameIgnoreCase(categoryName)){
            throw new  IllegalArgumentException("A category all ready exists with that name : " +categoryName);
        }
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(UUID id) {
       Optional<Category> category = categoryRepository.findById(id);

       if (category.isPresent()){
           if (!category.get().getPosts().isEmpty()){
               throw new IllegalArgumentException("Category has posts  associated with it !");
           }
       }
       categoryRepository.deleteById(id);
    }
}
