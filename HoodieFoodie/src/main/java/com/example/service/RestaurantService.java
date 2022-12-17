package com.example.service;

import java.util.List;

import com.example.exceptions.RestaurantException;
import com.example.model.Restaurant;

public interface RestaurantService {
	public Restaurant addrestaurant(Restaurant restaurant);
	public Restaurant updaterestaurant(Restaurant restaurant)throws RestaurantException;
	public Restaurant deleterestaurant(Restaurant restaurant)throws RestaurantException;
	public List<Restaurant> viewByRestaurantName(String restaurantName)throws RestaurantException;
	public Restaurant viewRestaurant(Restaurant restaurant)  throws RestaurantException;
//	public List<Restaurant> viewRestaurantByLocation(String Location)  throws RestaurantException;
	
	
}
