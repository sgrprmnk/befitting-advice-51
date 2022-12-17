package com.example.service;

import com.example.exceptions.CategoryException;
import com.example.exceptions.ItemException;
import com.example.exceptions.ResturantException;
import com.example.model.Category;
import com.example.model.Item;
import com.example.model.Restaurant;

import java.util.List;

public interface ItemService {
    public Item addItem(Item item, String restaurantName) throws ResturantException;
    public Item updateItem(Item item) throws ItemException;
    public Item viewItem(Item item) throws ItemException;
    public Item removeItem(Item item) throws ItemException;
    public List<Item> viewAllItem(Category cat) throws CategoryException,ItemException;
    public List<Item> viewAllItem(Restaurant res) throws ItemException, ResturantException;
    public List<Item> viewAllItemsByName(String name) throws ItemException;
}
