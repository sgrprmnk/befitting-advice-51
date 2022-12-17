package com.example.service;

import java.util.Optional;

import com.example.exceptions.FoodCartException;
import com.example.model.FoodCart;
import com.example.model.Item;
import com.example.repository.FoodCartDao;
import com.example.repository.ItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class FoodCartServiceImpl implements FoodCartService {

    @Autowired
    FoodCartDao foodCartDao;

    @Autowired
    ItemDao itemDao;

    @Override
    public FoodCart addItemToCart(String foodCartId, Item item) throws FoodCartException {
        Optional<FoodCart> opt = foodCartDao.findById(foodCartId);
        if (opt.isPresent()) {
            FoodCart fc = opt.get();
            fc.getItemList().add(item);
            return fc;
        } else {
            throw new FoodCartException("data not added..");
        }

    }

    @Override
    public FoodCart increaseQuantity(String foodCartId, Item item, Integer quantity) throws FoodCartException {
        Optional<FoodCart> opt = foodCartDao.findById(foodCartId);
        if (opt.isPresent()) {
            FoodCart fc = opt.get();
            Item it = (Item) fc.getItemList();
            it.setQuantity(it.getQuantity() + quantity);
//			Integer q=it.getQuantity();
//			Integer s=q+quantity;
            fc.getItemList().add(it);
            return fc;
        } else {
            throw new FoodCartException("quantity not increasing...");
        }
    }


    @Override
    public FoodCart reduceQuantity(String foodCartId, Item item, Integer quantity) throws FoodCartException {
        Optional<FoodCart> opt = foodCartDao.findById(foodCartId);

        if (opt.isPresent()) {
            FoodCart fc = opt.get();
            Item it = (Item) fc.getItemList();
            it.setQuantity(it.getQuantity() - quantity);
//			Integer q=it.getQuantity();
//			Integer s=q+quantity;
            fc.getItemList().add(it);
            return fc;
        } else {
            throw new FoodCartException("quantity not reduce...");
        }
    }


    @Override
    public FoodCart removeItem(String foodCartId, Item item) throws FoodCartException {
        Optional<FoodCart> opt = foodCartDao.findById(foodCartId);
        if (opt.isPresent()) {
            FoodCart fc = opt.get();

            Item items = (Item) fc.getItemList();
            itemDao.delete(items);

            return fc;
        } else {
            throw new FoodCartException("Item not removed...");
        }
    }


    @Override
    public FoodCart clearCart(FoodCart foodCart) throws FoodCartException {
        Optional<FoodCart> opt = foodCartDao.findById(foodCart.getCartId());
        if (opt.isPresent()) {
            FoodCart fc = opt.get();
            foodCartDao.delete(fc);
            return fc;
        } else {
            throw new FoodCartException("FoodCart  not clear....");
        }
    }
}

