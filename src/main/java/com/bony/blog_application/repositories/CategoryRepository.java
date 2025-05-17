package com.bony.blog_application.repositories;

import com.bony.blog_application.domain.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {
    @Query("SELECT c, COUNT(p) FROM Category c LEFT JOIN c.posts p GROUP BY c")
    List<Category> findAllWithPostCount();
}
