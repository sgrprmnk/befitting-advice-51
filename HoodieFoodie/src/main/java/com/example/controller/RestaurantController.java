package com.example.controller;

import java.util.List;

import com.example.exceptions.ResturantException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.exceptions.RestaurantException;
import com.example.model.Restaurant;
import com.example.service.RestaurantService;

@RestController
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;

    @PostMapping("/restaurants")
    public ResponseEntity<Restaurant> registerrestaurants(@RequestBody Restaurant restaurant) throws ResturantException {
        Restaurant rest = restaurantService.addrestaurant(restaurant);
        return new ResponseEntity<>(rest, HttpStatus.CREATED);
    }

    @PutMapping("/restaurants")
    public ResponseEntity<Restaurant> updateRestaurants(@RequestBody Restaurant restaurant) throws RestaurantException {
        Restaurant rest = restaurantService.updaterestaurant(restaurant);
        return new ResponseEntity<>(rest, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/restaurants")
    public ResponseEntity<Restaurant> delRestaurants(Restaurant restaurant) throws RestaurantException {
        Restaurant rest = restaurantService.deleterestaurant(restaurant);
        return new ResponseEntity<>(rest, HttpStatus.OK);
    }

    @GetMapping("/restaurants")
    public ResponseEntity<Restaurant> getTheRestaurants(String restaurantName) throws RestaurantException {
        Restaurant rest = restaurantService.viewByRestaurantName(restaurantName);
        return new ResponseEntity<>(rest, HttpStatus.OK);
    }
    @GetMapping("/getrestaurant")
    public ResponseEntity<Restaurant> getRestaurants(Restaurant restaurant) throws RestaurantException {
        Restaurant rest = restaurantService.viewRestaurant(restaurant);
        return new ResponseEntity<>(rest, HttpStatus.OK);
    }
    @GetMapping("/viewresto/{loc}")
    public ResponseEntity<List<Restaurant>> viewRestoHandler(@PathVariable("loc")  String loc) throws RestaurantException {
        List<Restaurant> restaurants=restaurantService.viewRestaurantByLocation(loc);
        return new ResponseEntity<>(restaurants,HttpStatus.FOUND);
    }
}