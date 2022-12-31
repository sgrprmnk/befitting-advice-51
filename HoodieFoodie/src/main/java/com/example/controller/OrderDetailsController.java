package com.example.controller;

import com.example.exceptions.OrderDetailsException;
import com.example.exceptions.RestaurantException;
import com.example.model.Customer;
import com.example.model.OrderDetails;
import com.example.model.Restaurant;
import com.example.service.OrderDetailsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class OrderDetailsController {
	@Autowired
	OrderDetailsServices ods;

	@PostMapping("/OrderDetails")
	public ResponseEntity<OrderDetails> addOrderDetailsHanler(@RequestBody OrderDetails ordeDetails) throws OrderDetailsException {
		OrderDetails od=ods.addOrder(ordeDetails);
		return new ResponseEntity<>(od, HttpStatus.ACCEPTED);
	}


	@PutMapping("OrderDetails")
	public ResponseEntity<OrderDetails> updateOrderDetailsHanler(@RequestBody OrderDetails ordeDetails) throws OrderDetailsException{
		OrderDetails od=ods.updateOrder(ordeDetails);
		return new ResponseEntity<>(od, HttpStatus.CREATED);
	}


	@DeleteMapping("OrderDetails")
	public ResponseEntity<OrderDetails> removeOrderDetailsHanler(@RequestBody OrderDetails ordeDetails) throws OrderDetailsException{
		OrderDetails od=ods.removeOrder(ordeDetails);
		return new ResponseEntity<>(od, HttpStatus.OK);
	}

	@GetMapping("viewsOrderDetails/{id}")
	public ResponseEntity<OrderDetails> viewOrderDetailsHanler(@PathVariable("id") int id) throws OrderDetailsException{
		OrderDetails od=ods.viewOrder(id);
		return new ResponseEntity<>(od, HttpStatus.ACCEPTED);
	}


	@GetMapping("ByRestraunt/{restoId}")
	public ResponseEntity<List<OrderDetails>> viewOrderDetailsByRestrauntHanler(@PathVariable("restoId") String restoId) throws OrderDetailsException{
		List<OrderDetails> odlist=ods.viewAllOrdersByRestaurant(restoId);

		return new ResponseEntity<>(odlist, HttpStatus.ACCEPTED);
	}


	@GetMapping("ByCustomer/{customerId}")
	public ResponseEntity<List<OrderDetails>> viewOrderDetailsByCustomerHanler(@PathVariable("customerId") String customerId ) throws OrderDetailsException, RestaurantException {
		List<OrderDetails> odlist=ods.viewAllOrdersByCustomer(customerId);

		return new ResponseEntity<>(odlist, HttpStatus.ACCEPTED);
	}




}