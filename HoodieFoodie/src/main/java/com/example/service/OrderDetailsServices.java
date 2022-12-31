package com.example.service;


import com.example.exceptions.OrderDetailsException;
import com.example.exceptions.RestaurantException;
import com.example.model.Customer;
import com.example.model.OrderDetails;
import com.example.model.Restaurant;
import org.springframework.stereotype.Service;

import java.util.List;
public interface OrderDetailsServices {
	public OrderDetails addOrder(OrderDetails orderdertails) throws OrderDetailsException;
	public OrderDetails updateOrder(OrderDetails orderdetails) throws OrderDetailsException;
	public OrderDetails removeOrder(OrderDetails orderdetails) throws OrderDetailsException;
	public OrderDetails viewOrder(int orderId) throws OrderDetailsException;
	public List<OrderDetails>viewAllOrdersByRestaurant(String restoId) throws OrderDetailsException;
	public List<OrderDetails> viewAllOrdersByCustomer(String customerId) throws OrderDetailsException, RestaurantException;
	

}
