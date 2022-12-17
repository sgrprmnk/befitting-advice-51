package com.example.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.exceptions.CategoryException;
import com.example.model.Category;
import com.example.service.CategoryService;

@RestController
public class CategoryController {
	
	private CategoryService cservice;
	
	@PostMapping("/category")
	public ResponseEntity<Category> registerCategory(@RequestBody Category categpory) throws CategoryException {
		Category cat = cservice.addCategory(categpory);
		return new ResponseEntity<Category>(cat, HttpStatus.CREATED);
	}
	@PutMapping("/category")
	public ResponseEntity<Category> updateCategory(@RequestBody Category category) throws CategoryException {
		Category cat = cservice.updateCategory(category);
		return new ResponseEntity<Category>(cat, HttpStatus.OK);
	}
	@DeleteMapping("/category")
	public ResponseEntity<Category> removesCategory(Category category) throws CategoryException {
		Category cat = cservice.removeCategory(category);
		return new ResponseEntity<Category>(cat, HttpStatus.OK);
	}
	@GetMapping("/category")
	public ResponseEntity<List<Category>> viewByCategory(String catName) throws CategoryException {
		List<Category> cat = cservice.viewByCategoryName(catName);
		return new ResponseEntity<List<Category>>(cat, HttpStatus.OK);
	}
	@GetMapping("/allcategory")
	public ResponseEntity<List<Category>> viewAllCategory() throws CategoryException {
		List<Category> cat = cservice.viewAllCategory();
		return new ResponseEntity<List<Category>>(cat, HttpStatus.OK);
	}
}
