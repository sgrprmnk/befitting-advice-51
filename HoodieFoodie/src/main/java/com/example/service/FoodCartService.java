package com.example.service;

import com.example.exceptions.FoodCartException;
import com.example.model.FoodCart;
import com.example.model.Item;

public interface FoodCartService {
    public FoodCart addItemToCart (FoodCart foodCard , Item item)throws FoodCartException;
    public FoodCart increaseQuantity(FoodCart foodCart,Item item,Integer quantity)throws FoodCartException;
    public FoodCart reduceQuantity(FoodCart foodCart, Item item, Integer quantity)throws FoodCartException;
    public FoodCart removeItem(FoodCart foodCart,Item item)throws FoodCartException;
    public FoodCart clearCart(FoodCart foodCart)throws FoodCartException;
}
