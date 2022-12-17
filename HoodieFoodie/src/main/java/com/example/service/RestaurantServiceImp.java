package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.exceptions.RestaurantException;
import com.example.model.Address;
import com.example.model.Restaurant;
import com.example.repository.RestaurantDao;


public class RestaurantServiceImp implements RestaurantService {
	@Autowired
	private RestaurantDao rdao;

	@Override
	public Restaurant addrestaurant(Restaurant restaurant) {
		return rdao.save(restaurant);
	}

	@Override
	public Restaurant updaterestaurant(Restaurant restaurant) throws RestaurantException {
		Optional<Restaurant> rest= rdao.findById(restaurant.getRestaurantId());
		if(rest.isPresent()) {
			return rdao.save(restaurant);
		}
		throw new RestaurantException("Restaurant is not there with given id");
	}
	@Override
	public Restaurant deleterestaurant(Restaurant restaurant) throws RestaurantException {
		Optional<Restaurant> rest= rdao.findById(restaurant.getRestaurantId());
		if(rest.isPresent()) {
			Restaurant deleterest =rest.get();
			rdao.delete(deleterest);
			return deleterest;
		}
		throw new RestaurantException("Restaurant is not there with given id");
	}
	@Override
	public List<Restaurant> viewByRestaurantName(String restaurantName) throws RestaurantException {
		List<Restaurant> viewrestaurant= rdao.findByRestaurantName(restaurantName);
		if(viewrestaurant!=null) {
			return viewrestaurant;
		}
		throw new RestaurantException("No data found with given restaurant name");
	}

	@Override
	public Restaurant viewRestaurant(Restaurant restaurant) throws RestaurantException {
		return  rdao.findById(restaurant.getRestaurantId()).orElseThrow(()->new RestaurantException("Not found by location"));
		
	}
//
//	@Override
//	public List<Restaurant> viewRestaurantByLocation(String Location) throws RestaurantException {
//		Address address =rdao.findByAreaAddress(Location);
//		
//		List<Restaurant> rests =rdao.findByAddress(address);
//		
//		if(rests.isEmpty()) {
//			throw new RestaurantException("Resto not exist");
//		}
//		
//		return rests;
//	}
	

}
