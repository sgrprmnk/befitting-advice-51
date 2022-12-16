package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Category;


public interface CategoryDao extends JpaRepository<Category, String> {
	public List<Category> findByCategoryName(String catName);
}
