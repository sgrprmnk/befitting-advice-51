package com.example.repository;

import com.example.exceptions.OrderDetailsException;
import com.example.model.Category;
import com.example.model.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryDao extends JpaRepository<Category,String> {
    public List<Category> findByCategoryName(String catName);
}
