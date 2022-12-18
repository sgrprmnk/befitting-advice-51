package com.example.service;

import com.example.exceptions.FoodCartException;
import com.example.model.FoodCart;
import com.example.model.Item;

public interface FoodCartService {
  public FoodCart saveFoodcart(FoodCart foodCart)throws FoodCartException;
  public FoodCart addItemToCart (String foodCartId , Item item)throws FoodCartException;
  //  public FoodCart addItemCart(Item item, String )
  public FoodCart increaseQuantity(String foodCartId,Item item,Integer quantity)throws FoodCartException;
  public FoodCart reduceQuantity(String foodCartId, Item item, Integer quantity)throws FoodCartException;
  public FoodCart removeItem(String foodCartId,Item item)throws FoodCartException;
  public FoodCart clearCart(FoodCart foodCart)throws FoodCartException;
}