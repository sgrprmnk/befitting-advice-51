package com.example.service;

import com.example.exceptions.CategoryException;
import com.example.exceptions.ItemException;
import com.example.exceptions.ResturantException;
import com.example.model.Category;
import com.example.model.Item;
import com.example.model.Restaurant;

import java.util.List;

public interface ItemService {
    public Item addItem(Item item, String restaurantId) throws ResturantException;
    public Item updateItem(Item item) throws ItemException;
    public Item viewItem(String itemId) throws ItemException;
    public Item removeItem(String itemId) throws ItemException;
    public List<Item> viewAllItems(String categoryId) throws CategoryException,ItemException;
    public List<Item> viewAllItem(String resId) throws ItemException, ResturantException;
    public List<Item> viewAllItemsByName(String name) throws ItemException;
}
