package com.example.controller;

import com.example.exceptions.FoodCartException;
import com.example.model.FoodCart;
import com.example.model.Item;
import com.example.service.FoodCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class FoodCartController {
    @Autowired
    FoodCartService foodCartService;

    @PostMapping("/foodcart/{cart}")
    public ResponseEntity<FoodCart> addItemToCart(@PathVariable("cart") String foodCart, @RequestBody Item item) throws FoodCartException, FoodCartException {

        FoodCart fc = foodCartService.addItemToCart(foodCart, item);
        return new ResponseEntity<>(fc, HttpStatus.ACCEPTED);
    }

    @PutMapping("/IncreaseQuantity/{cart}")
    public ResponseEntity<FoodCart> increaseItemQuantity(@PathVariable("cart")String foodCart, @RequestBody Item item, Integer quantity) throws FoodCartException {

        FoodCart fc = foodCartService.increaseQuantity(foodCart, item, quantity);
        return new ResponseEntity<>(fc, HttpStatus.ACCEPTED);
    }

    @PutMapping("/ReduceQuantity/{cart}")
    public ResponseEntity<FoodCart> ReduceItemQuantity(@PathVariable("cart")String foodCart, @RequestBody Item item, Integer quantity) throws FoodCartException {

        FoodCart fc = foodCartService.reduceQuantity(foodCart, item, quantity);
        return new ResponseEntity<>(fc, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/deleteItem/{cart}")
    public ResponseEntity<FoodCart> removeItem(@PathVariable("cart")String foodCart, @RequestBody Item item) throws FoodCartException {

        FoodCart fc = foodCartService.removeItem(foodCart, item);
        return new ResponseEntity<>(fc, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/deleteFoodCart")
    public ResponseEntity<FoodCart> removeFoodCart(@RequestBody FoodCart foodCart) throws FoodCartException {
        FoodCart fc = foodCartService.clearCart(foodCart);
        return new ResponseEntity<>(fc, HttpStatus.ACCEPTED);
    }

}