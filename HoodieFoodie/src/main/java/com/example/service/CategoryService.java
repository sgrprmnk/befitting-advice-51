package com.example.service;

import com.example.exceptions.CategoryException;
import com.example.model.Category;

import java.util.List;

public interface CategoryService {
    public Category addCategory(Category category) throws CategoryException;
    public Category updateCategory(Category category) throws CategoryException;
    public Category removeCategory(Category category) throws CategoryException;
    public List<Category> viewByCategoryName(String catName) throws CategoryException;
    public List<Category> viewAllCategory() throws CategoryException;
}
