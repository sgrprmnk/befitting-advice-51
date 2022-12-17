package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exceptions.CategoryException;
import com.example.model.Category;
import com.example.repository.CategoryDao;
@Service
public class CategeryServiceImp implements CategoryService {
	@Autowired
	private CategoryDao cdao;
	@Override
	public Category addCategory(Category category) throws CategoryException {
		return  cdao.save(category);
	}

	@Override
	public Category updateCategory(Category category) throws CategoryException {
		Optional<Category> cat = cdao.findById(category.getCatId());
		if(cat.isPresent()) {
			cdao.save(category);
		}
		throw new CategoryException("There is no product which you are trying to update") ;
	}

	@Override
	public Category removeCategory(Category category) throws CategoryException {
		Optional<Category> c= cdao.findById(category.getCatId());
		if(c.isPresent()) {
			
			Category dle= c.get();
			cdao.delete(dle);
			return dle;
		}
		throw new CategoryException("There is no product which you are trying to delete");
	}
	
	@Override
	public List<Category> viewByCategoryName(String catName) throws CategoryException {
		List<Category> categoryList= cdao.findByCategoryName(catName);
		if(categoryList.size()!=0) {
			return categoryList;
		}
		throw new CategoryException("No data found with given category name");
	}

	@Override
	public List<Category> viewAllCategory() throws CategoryException {
		List<Category> list= cdao.findAll();
		if(list.isEmpty()) {
			throw new CategoryException("No categories are present");
		}
		return list;
	}

}
