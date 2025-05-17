package com.bony.blog_application.services;


import com.bony.blog_application.domain.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> listCategories();
}
