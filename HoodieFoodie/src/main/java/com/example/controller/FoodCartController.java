package com.example.controller;

import com.example.exceptions.FoodCartException;
import com.example.model.FoodCart;
import com.example.model.Item;
import com.example.service.FoodCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class FoodCartController {
    @Autowired
    FoodCartService foodCartService;

    @PostMapping("/foodcart")
    public ResponseEntity<FoodCart> addItemToCart(@RequestBody FoodCart foodCart, @RequestBody Item item) throws FoodCartException, FoodCartException {

        FoodCart fc = foodCartService.addItemToCart(foodCart, item);
        return new ResponseEntity<>(fc, HttpStatus.ACCEPTED);
    }

    @PutMapping("/IncreaseQuantity")
    public ResponseEntity<FoodCart> increaseItemQuantity(@RequestBody FoodCart foodCart, @RequestBody Item item, Integer quantity) throws FoodCartException {

        FoodCart fc = foodCartService.increaseQuantity(foodCart, item, quantity);
        return new ResponseEntity<>(fc, HttpStatus.ACCEPTED);
    }

    @PutMapping("/ReduceQuantity")
    public ResponseEntity<FoodCart> ReduceItemQuantity(@RequestBody FoodCart foodCart, @RequestBody Item item, Integer quantity) throws FoodCartException {

        FoodCart fc = foodCartService.reduceQuantity(foodCart, item, quantity);
        return new ResponseEntity<>(fc, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/deleteItem")
    public ResponseEntity<FoodCart> removeItem(@RequestBody FoodCart foodCart, @RequestBody Item item) throws FoodCartException {

        FoodCart fc = foodCartService.removeItem(foodCart, item);
        return new ResponseEntity<>(fc, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/deleteFoodCart")
    public ResponseEntity<FoodCart> removeFoodCart(@RequestBody FoodCart foodCart) throws FoodCartException {
        FoodCart fc = foodCartService.clearCart(foodCart);
        return new ResponseEntity<>(fc, HttpStatus.ACCEPTED);
    }

}