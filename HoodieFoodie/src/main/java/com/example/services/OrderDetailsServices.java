package com.example.services;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import hoodie.foodie.Exception.OrderDetailsException;
import hoodie.foodie.Module.Customer;
import hoodie.foodie.Module.OrderDetails;
import hoodie.foodie.Module.Restaurant;
@Service
public interface OrderDetailsServices {
	public OrderDetails addOrder(OrderDetails orderdertails) throws OrderDetailsException;
	public OrderDetails updateOrder(OrderDetails orderdetails) throws OrderDetailsException;
	public OrderDetails removeOrder(OrderDetails orderdetails) throws OrderDetailsException;
	public OrderDetails viewOrder(OrderDetails orderdetails) throws OrderDetailsException;
	public List<OrderDetails>viewAllOrdersByRestaurant(Restaurant restaurant) throws OrderDetailsException;
	public List<OrderDetails> viewAllOrdersByCustomer(Customer customer) throws OrderDetailsException;
	

}
