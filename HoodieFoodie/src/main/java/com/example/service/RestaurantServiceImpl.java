package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.exceptions.ItemException;
import com.example.exceptions.ResturantException;
import com.example.model.Item;
import com.example.repository.AddressDao;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.exceptions.RestaurantException;
import com.example.model.Address;
import com.example.model.Restaurant;
import com.example.repository.RestaurantDao;
import org.springframework.stereotype.Service;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    private RestaurantDao restaurantDao;

    @Autowired
    private AddressDao addressDao;
    @Override
    public Restaurant addrestaurant(Restaurant restaurant) throws ResturantException {
Restaurant existingRestaurant=restaurantDao.findByRestaurantName(restaurant.getRestaurantName());
if (existingRestaurant!=null){
    throw new ResturantException("Already Registered");
}
// List<Item> itemList=restaurant.getItemList();
// for(Item item:itemList){
//     item.getRestaurants().add(restaurant);
// }


        return restaurantDao.save(restaurant);
    }

    @Override
    public Restaurant updaterestaurant(Restaurant restaurant) throws RestaurantException {
        Optional<Restaurant> rest= restaurantDao.findById(restaurant.getRestaurantId());
        if(rest.isPresent()) {
            return restaurantDao.save(restaurant);
        }
        throw new RestaurantException("Restaurant is not there with given id");
    }
    @Override
    public Restaurant deleterestaurant(String restaurantId) throws RestaurantException {
        Optional<Restaurant> rest= restaurantDao.findById(restaurantId);
        if(rest.isPresent()) {
            Restaurant deleterest =rest.get();
            restaurantDao.delete(deleterest);
            return deleterest;
        }
        throw new RestaurantException("Restaurant is not there with given id");
    }
    @Override
    public Restaurant viewByRestaurantName(String restaurantName) throws RestaurantException {
        Restaurant viewrestaurant= restaurantDao.findByRestaurantName(restaurantName);
        if(viewrestaurant!=null) {
            return viewrestaurant;
        }
        throw new RestaurantException("No data found with given restaurant name");
    }

    @Override
    public Restaurant viewRestaurant(String restaurantId) throws RestaurantException {
        return  restaurantDao.findById(restaurantId).orElseThrow(()->new RestaurantException("Not found by location"));

    }



	@Override
	public List<Restaurant> viewRestaurantByLocation(String location) throws RestaurantException {
		Address address =addressDao.findByArea(location);

		List<Restaurant> rests =restaurantDao.getRestaurantByAddress(address.getAddressId());

		if(rests.isEmpty()) {
			throw new RestaurantException("Resto not exist");
		}

		return rests;
	}


}
