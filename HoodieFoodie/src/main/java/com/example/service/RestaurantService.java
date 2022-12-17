package com.example.service;

import com.example.exceptions.ItemException;
import com.example.exceptions.RestaurantException;
import com.example.exceptions.ResturantException;
import com.example.model.Restaurant;

import java.util.List;

public interface RestaurantService {
    public Restaurant addrestaurant(Restaurant restaurant) throws ResturantException;
    public Restaurant updaterestaurant(Restaurant restaurant)throws RestaurantException;
    public Restaurant deleterestaurant(Restaurant restaurant)throws RestaurantException;
    public Restaurant viewByRestaurantName(String restaurantName)throws RestaurantException;
    public Restaurant viewRestaurant(Restaurant restaurant)  throws RestaurantException;
    public List<Restaurant> viewRestaurantByLocation(String location) throws RestaurantException;

}
