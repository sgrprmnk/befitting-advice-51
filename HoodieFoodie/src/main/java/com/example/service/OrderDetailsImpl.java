package com.example.service;


import com.example.exceptions.OrderDetailsException;
import com.example.exceptions.RestaurantException;
import com.example.model.*;
import com.example.repository.FoodCartDao;
import com.example.repository.OrderDetailsDao;
import com.example.repository.RestaurantDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class OrderDetailsImpl implements OrderDetailsServices {

	@Autowired
	OrderDetailsDao orderDetailsDao;

	@Autowired
	FoodCartDao foodCartDao;

	@Autowired
	RestaurantDao restaurantDao;

	@Override
	public OrderDetails addOrder(OrderDetails orderdertails) throws OrderDetailsException {
		OrderDetails od= orderDetailsDao.save(orderdertails);
		if(od==null) {
			throw new OrderDetailsException("Data not saved..");
		}else {
			return od;
		}
		
	}

	@Override
	public OrderDetails updateOrder(OrderDetails orderdetails) throws OrderDetailsException {
		 Optional<OrderDetails> opt= orderDetailsDao.findById(orderdetails.getOrderId());
		 if(opt.isPresent()) {
			 throw new OrderDetailsException("Your data not updated...");
		 }else {
			 OrderDetails od=opt.get();
			 orderDetailsDao.save(od);
			 return od;
		 }
		 
	}

	@Override
	public OrderDetails removeOrder(OrderDetails orderdetails) throws OrderDetailsException {
		Optional<OrderDetails> opt= orderDetailsDao.findById(orderdetails.getOrderId());
		if(opt.isPresent()) {
			OrderDetails od=opt.get();
			orderDetailsDao.delete(od);
			return od;
		}else {
			throw new OrderDetailsException("data not deleted...");
		}
	}

	@Override
	public OrderDetails viewOrder(OrderDetails orderdetails) throws OrderDetailsException {
		Optional<OrderDetails> opt= orderDetailsDao.findById(orderdetails.getOrderId());
		if(opt.isPresent()) {
			OrderDetails ood=opt.get();
			return ood;
		}else {
			throw new OrderDetailsException("data not found....");
		}
		
	}

	@Override
	public List<OrderDetails> viewAllOrdersByRestaurant(Restaurant restaurant) throws OrderDetailsException {

	List<Item> items=restaurantDao.getItem(restaurant.getRestaurantId());

		return null;

	}

	@Override
	public List<OrderDetails> viewAllOrdersByCustomer(Customer customer) throws OrderDetailsException{
		FoodCart foodCart =foodCartDao.getCustomer(customer.getCustomerId());
		List<OrderDetails> orderDetails=orderDetailsDao.getCart(foodCart.getCartId());
if(orderDetails.isEmpty()){
	throw new OrderDetailsException("Not Found");
}
else
	return orderDetails;
	}

	

	

}
