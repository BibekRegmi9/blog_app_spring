package com.bibek.blog.services.impl;

import com.bibek.blog.entities.Category;
import com.bibek.blog.exceptions.ResourceNotFoundException;
import com.bibek.blog.payloads.CategoryDto;
import com.bibek.blog.repository.CategoryRepo;
import com.bibek.blog.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = this.modelMapper.map(categoryDto, Category.class);
        Category savedCategory = this.categoryRepo.save(category);
        return this.modelMapper.map(savedCategory, CategoryDto.class);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
        Category category = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "Category Id", categoryId));
        category.setCategoryTitle(categoryDto.getCategoryTitle());
        category.setCategoryDescription(categoryDto.getCategoryDescription());
        Category updatedCategory =  this.categoryRepo.save(category);
        return this.modelMapper.map(updatedCategory, CategoryDto.class);
    }

    @Override
    public void deleteCategory(Integer categoryId) {
        Category category = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "category Id", categoryId));
        this.categoryRepo.delete(category);
    }

    @Override
    public CategoryDto getCategory(Integer categoryId) {
        Category category = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "category Id", categoryId));
        return this.modelMapper.map(category, CategoryDto.class);
    }

    @Override
    public List<CategoryDto> getCategories() {
        List<Category> categories = this.categoryRepo.findAll();
        List<CategoryDto> categoryDtos = categories.stream().map(category -> this.modelMapper.map(category, CategoryDto.class)).collect(Collectors.toList());
        return categoryDtos;
    }
}
