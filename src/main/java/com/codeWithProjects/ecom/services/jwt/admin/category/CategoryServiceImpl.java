package com.codeWithProjects.ecom.services.jwt.admin.category;

import com.codeWithProjects.ecom.dto.CategoryDto;
import com.codeWithProjects.ecom.entity.Category;
import com.codeWithProjects.ecom.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

// The @RequiredAgrsConstructor annotation generates a parameterized
// constructor with the final member
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;

    public Category createCategory(CategoryDto categoryDto){
        Category category = new Category();
        category.setName(categoryDto.getName());
        category.setDescription(categoryDto.getDescription());

        return categoryRepository.save(category);
    }

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }
}
