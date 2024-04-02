package com.bibek.blog.controllers;

import com.bibek.blog.payloads.ApiResponse;
import com.bibek.blog.payloads.CategoryDto;
import com.bibek.blog.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    //create
    @PostMapping("/")
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto){
        CategoryDto createCategory = this.categoryService.createCategory(categoryDto);
        return new ResponseEntity<CategoryDto>(createCategory, HttpStatus.CREATED);
    }

    //update
    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto categoryDto, @PathVariable("categoryId") Integer cid){
        CategoryDto updateCategory = this.categoryService.updateCategory(categoryDto, cid);
        return new ResponseEntity<CategoryDto>(updateCategory, HttpStatus.OK);
    }

    //delete
    @DeleteMapping("/{categoryId}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable("categoryId") Integer cid){
        this.categoryService.deleteCategory(cid);
        return new ResponseEntity<ApiResponse>(new ApiResponse("category is deleted successfully!!", true), HttpStatus.OK);
    }

    //get
    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> getCategory(@PathVariable("categoryId") Integer cid){
        CategoryDto categoryDto = this.categoryService.getCategory(cid);
        return new ResponseEntity<CategoryDto>(categoryDto, HttpStatus.OK);
    }

    //get-all
    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>> getAllCategory(){
        List<CategoryDto> categories = this.categoryService.getCategories();
        return ResponseEntity.ok(categories);
    }

}
