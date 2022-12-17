package com.example.repository;

import com.example.model.Address;
import com.example.model.Item;
import com.example.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RestaurantDao extends JpaRepository<Restaurant,String> {
    public Restaurant findByRestaurantName(String restaurantName);
    @Query("select c from Restaurant c where c.address.addressId=?1")
    public List<Restaurant> getRestaurantByAddress(String addressId);
    @Query("select s.itemList from Restaurant s where s.restaurantId=?1")
public List<Item> getItem(String resturaId);


}
