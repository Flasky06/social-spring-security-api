package com.bony.blog_application.Mappers;

import com.bony.blog_application.domain.PostStatus;
import com.bony.blog_application.domain.dto.CategoryDto;
import com.bony.blog_application.domain.dto.CreateCategoryRequest;
import com.bony.blog_application.domain.entity.Category;
import com.bony.blog_application.domain.entity.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryMapper {

    @Mapping(target = "postCount" , source = "posts" , qualifiedByName = "calculatePostCount")
    CategoryDto toDto(Category category);

    Category toEntity(CreateCategoryRequest createCategoryRequest);

    @Named("calculatePostCount")
    default long calculatedPosts(List<Post> posts){
        if (null == posts){
            return 0;
        }
        return posts.stream()
                .filter(post -> PostStatus.PUBLISHED
                        .equals(post.getStatus())).count();
    }
}
