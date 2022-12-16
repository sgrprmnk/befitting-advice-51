package com.example.services;

import com.example.Exception.FoodCartException;
import com.example.Module.FoodCart;
import com.example.Module.Item;

public interface FoodCartService {
	public FoodCart addItemToCart (FoodCart foodCard ,Item item)throws FoodCartException;
	public FoodCart increaseQuantity(FoodCart foodCart,Item item,Integer quantity)throws FoodCartException;
	public FoodCart reduceQuantity(FoodCart foodCart,Item item,Integer quantity)throws FoodCartException; 
	public FoodCart removeItem(FoodCart foodCart,Item item)throws FoodCartException; 
	public FoodCart clearCart(FoodCart foodCart)throws FoodCartException;
	

}
