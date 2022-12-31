package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.exceptions.CategoryException;
import com.example.model.Category;
import com.example.service.CategoryService;

@RestController
public class CategoryController {
@Autowired
    private CategoryService cservice;

    @PostMapping("/category")
    public ResponseEntity<Category> registerCategory(@RequestBody Category categpory) throws CategoryException {
        Category cat = cservice.addCategory(categpory);
        return new ResponseEntity<>(cat, HttpStatus.CREATED);
    }
    @PutMapping("/category")
    public ResponseEntity<Category> updateCategory(@RequestBody Category category) throws CategoryException {
        Category cat = cservice.updateCategory(category);
        return new ResponseEntity<>(cat, HttpStatus.OK);
    }
    @DeleteMapping("/category/{categoryId}")
    public ResponseEntity<Category> removesCategory(@PathVariable("categoryId") String categoryId) throws CategoryException {
        Category cat = cservice.removeCategory(categoryId);
        return new ResponseEntity<>(cat, HttpStatus.OK);
    }
    @GetMapping("/category/{catn}")
    public ResponseEntity<List<Category>> viewByCategory(@PathVariable("catn") String catName) throws CategoryException {
        List<Category> cat = cservice.viewByCategoryName(catName);
        return new ResponseEntity<>(cat, HttpStatus.OK);
    }
    @GetMapping("/allcategory")
    public ResponseEntity<List<Category>> viewAllCategory() throws CategoryException {
        List<Category> cat = cservice.viewAllCategory();
        return new ResponseEntity<>(cat, HttpStatus.OK);
    }
}