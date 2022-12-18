package com.example.repository;

import com.example.model.Category;
import com.example.model.Item;
import com.example.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemDao extends JpaRepository<Item,String> {
    public List<Item> findByItemName(String name);
    public List<Item> findByCategory(Category cat);
    @Query("select a from Item a where a.category.catId=?1")
    public List<Item> findByCatId(String catId);
@Query("select s.itemList from Restaurant s where s.restaurantId=?1 ")
    public List<Item> findByRestaurants(String restaurantId);

}
