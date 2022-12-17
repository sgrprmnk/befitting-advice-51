package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.exceptions.RestaurantException;
import com.example.model.Restaurant;
import com.example.service.RestaurantService;

@RestController
public class RestaurantController {
	@Autowired
	private RestaurantService rservice;

	@PostMapping("/restaurants")
	public ResponseEntity<Restaurant> registerrestaurants(@RequestBody Restaurant restaurant) {
		Restaurant rest = rservice.addrestaurant(restaurant);
		return new ResponseEntity<Restaurant>(rest, HttpStatus.CREATED);
	}

	@PutMapping("/restaurants")
	public ResponseEntity<Restaurant> updateRestaurants(@RequestBody Restaurant restaurant) throws RestaurantException {
		Restaurant rest = rservice.updaterestaurant(restaurant);
		return new ResponseEntity<Restaurant>(rest, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/restaurants")
	public ResponseEntity<Restaurant> delRestaurants(Restaurant restaurant) throws RestaurantException {
		Restaurant rest = rservice.deleterestaurant(restaurant);
		return new ResponseEntity<Restaurant>(rest, HttpStatus.OK);
	}

	@GetMapping("/restaurants")
	public ResponseEntity<List<Restaurant>> getTheRestaurants(String restaurantName) throws RestaurantException {
		List<Restaurant> rest = rservice.viewByRestaurantName(restaurantName);
		return new ResponseEntity<List<Restaurant>>(rest, HttpStatus.OK);
	}
	@GetMapping("/getrestaurant")
	public ResponseEntity<Restaurant> getRestaurants(Restaurant restaurant) throws RestaurantException {
		Restaurant rest = rservice.viewRestaurant(restaurant);
		return new ResponseEntity<Restaurant>(rest, HttpStatus.OK);
	}
}
