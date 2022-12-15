package com.example.service;

import com.example.exceptions.CategoryException;
import com.example.model.Category;

public interface CategoryService {

	public Category addCategory(Category category) throws CategoryException;
	public Category updateCategory(Category category) throws CategoryException;
	public Category removeCategory(Category category) throws CategoryException;
	
}
