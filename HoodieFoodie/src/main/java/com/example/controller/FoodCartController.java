package com.example.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Exception.FoodCartException;
import com.example.Module.FoodCart;
import com.example.Module.Item;
import com.example.Services.FoodCartService;

@RestController
public class FoodCartController {
	@Autowired
	FoodCartService fcs;
	
	@PostMapping("/FoodCart")
	public ResponseEntity<FoodCart> addItemToCart(@RequestBody FoodCart foodCart, @RequestBody Item item) throws FoodCartException{
		
		FoodCart fc=fcs.addItemToCart(foodCart, item);
	  return new ResponseEntity<FoodCart>(fc,HttpStatus.ACCEPTED);
	}
	@PutMapping("/IncreaseQuantity")
    public ResponseEntity<FoodCart> increaseItemQuantity(@RequestBody FoodCart foodCart, @RequestBody Item item,Integer quantity) throws FoodCartException{
		
		FoodCart fc=fcs.increaseQuantity(foodCart, item, quantity);
	  return new ResponseEntity<FoodCart>(fc,HttpStatus.ACCEPTED);
	 }
	
	@PutMapping("/ReduceQuantity")
    public ResponseEntity<FoodCart> ReduceItemQuantity(@RequestBody FoodCart foodCart, @RequestBody Item item,Integer quantity) throws FoodCartException{
		
		FoodCart fc=fcs.reduceQuantity(foodCart, item, quantity);
	  return new ResponseEntity<FoodCart>(fc,HttpStatus.ACCEPTED);
	 }
	
	@DeleteMapping("/deleteItem")
    public ResponseEntity<FoodCart> removeItem(@RequestBody FoodCart foodCart,@RequestBody Item item) throws FoodCartException{
		
		FoodCart fc=fcs.removeItem(foodCart,item);
	  return new ResponseEntity<FoodCart>(fc,HttpStatus.ACCEPTED);
	 }
	
	@DeleteMapping("/deleteFoodCart")
    public ResponseEntity<FoodCart> removeFoodCart(@RequestBody FoodCart foodCart) throws FoodCartException{
		FoodCart fc=fcs.clearCart(foodCart);
	  return new ResponseEntity<FoodCart>(fc,HttpStatus.ACCEPTED);
	 }

}
