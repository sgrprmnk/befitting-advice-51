package com.example.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Restaurant;
import com.example.service.RestaurantService;


@RestController
public class RestaurantController {
	@Autowired
	private RestaurantService rservice;
	@PostMapping("/restaurants")
	public ResponseEntity<Restaurant> registerrestaurants(@RequestBody Restaurant restaurant ){
		Restaurant rest= rservice.addrestaurant(restaurant);
		return new ResponseEntity<Restaurant>(rest,HttpStatus.CREATED);
	}
}
