package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.Address;
import com.example.model.Restaurant;
@Repository
public interface RestaurantDao extends JpaRepository<Restaurant, String> {
	
public List<Restaurant> findByRestaurantName(String restaurantName);
//public List<Restaurant> findByRestaurantArea(String area);
//public Address findByAreaAddress(String area);


//@Query("select s from Address s where s.area=?1")
//public Address findByAreaAddress(String area);
//public List<Restaurant> findByAddress(Address address);
}
