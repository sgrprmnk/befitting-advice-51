package com.example.repository;

import com.example.model.Category;
import com.example.model.Item;
import com.example.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemDao extends JpaRepository<Item,String> {
    public List<Item> findByItemName(String name);
    public List<Item> findByCategory(Category cat);

    public List<Item> findByRestaurants(Restaurant rest);

}
