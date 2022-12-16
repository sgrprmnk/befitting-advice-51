package com.example.service;

import com.example.exceptions.CategoryException;
import com.example.exceptions.ItemException;
import com.example.exceptions.ResturantException;
import com.example.model.Category;
import com.example.model.Item;
import com.example.model.Restaurant;
import com.example.repository.ItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    private ItemDao itemDao;
    @Override
    public Item addItem(Item item) {
       return itemDao.save(item);
    }

    @Override
    public Item updateItem(Item item) throws ItemException {
    Optional<Item> item1= itemDao.findById(item.getItemId());
    if (item1.isPresent()){
        Item updatedItem=itemDao.save(item);
        return updatedItem;
    } else {
        throw new ItemException("Item does not exist");
    }
    }

    @Override
    public Item viewItem(Item item) throws ItemException {
      return itemDao.findById(item.getItemId()).orElseThrow(()-> new ItemException("Item Does not Exist"));
    }

    @Override
    public Item removeItem(Item item) throws ItemException {
    Optional<Item>item1= itemDao.findById(item.getItemId());
        if(item1.isPresent()){
            Item existingItem=item1.get();
            itemDao.delete(existingItem);
            return existingItem;
        }
        else
            throw new ItemException("Item does not exist");
    }

    @Override
    public List<Item> viewAllItem(Category cat) throws CategoryException {
        List<Item> items=itemDao.findByCategory(cat);
        if(items.isEmpty()){
            throw new CategoryException("Does not Exist");
        }
        return items;

    }

    @Override
    public List<Item> viewAllItem(Restaurant res) throws ResturantException {
        List<Item> items =itemDao.findByRestaurants(res);
        if(items.isEmpty()){
            throw new ResturantException("Does not exist");
        }
        return items;
    }

    @Override
    public List<Item> viewAllItemsByName(String name) throws ItemException {
      List<Item> items=itemDao.findByItemName(name);
      if (items.isEmpty()){
          throw new ItemException("Item does not exist");
      }
      return items;
    }
}
