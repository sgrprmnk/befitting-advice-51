package com.example.services;

import java.lang.StackWalker.Option;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Exception.FoodCartException;
import com.example.Module.FoodCart;
import com.example.Module.Item;
import com.example.Repo.FoodCartRepo;
import com.example.Repo.ItemRepo;

@Service
public class FoodCartServiceImpl implements FoodCartService {
	
    @Autowired
    FoodCartRepo fcp;
    
    @Autowired
    ItemRepo ir;
	@Override
	public FoodCart addItemToCart(FoodCart foodCard, Item item)throws FoodCartException {
		 Optional<FoodCart> opt=fcp.findAllById(foodCard.getCartId());
		 if(opt.isPresent()) {
			 FoodCart fc=opt.get();
			 fc.getItemList().add(item);
			 return fc;
		 }
		 else {
	    	   throw new FoodCartException("data not added..");
	       }
		
	}

	@Override
	public FoodCart increaseQuantity(FoodCart foodCart, Item item, Integer quantity) throws FoodCartException{
		Optional<FoodCart> opt=fcp.findAllById(foodCart.getCartId());
		if(opt.isPresent()){
			FoodCart fc=opt.get();
			Item it=(Item) fc.getItemList();
			it.setQuantity(it.getQuantity()+quantity);			
//			Integer q=it.getQuantity();
//			Integer s=q+quantity;
			fc.getItemList().add(it);
			return fc;
		}
		else {
	    	   throw new FoodCartException("quantity not increasing...");
	       }
	}


	@Override
	public FoodCart reduceQuantity(FoodCart foodCart, Item item, Integer quantity) throws FoodCartException{
		Optional<FoodCart> opt=fcp.findAllById(foodCart.getCartId());
		
		if(opt.isPresent()){
			FoodCart fc=opt.get();
			Item it=(Item) fc.getItemList();
			it.setQuantity(it.getQuantity()-quantity);			
//			Integer q=it.getQuantity();
//			Integer s=q+quantity;
			fc.getItemList().add(it);
			return fc;
		}
		else {
	    	   throw new FoodCartException("quantity not reduce...");
	       }	}

	
	@Override
	public FoodCart removeItem(FoodCart foodCard, Item item) throws FoodCartException{
		 Optional<FoodCart> opt=fcp.findAllById(foodCard.getCartId());
		 if(opt.isPresent()) {
			 FoodCart fc=opt.get();
			 
			Item items= (Item) fc.getItemList();
			 ir.delete(items);
			
			 return fc;
		 }
		 else {
	    	   throw new FoodCartException("Item not removed...");
	       }
	}

	
	@Override
	public FoodCart clearCart(FoodCart foodCart) throws FoodCartException{
	       Optional<FoodCart> opt=  fcp.findById(foodCart.getCartId());
	       if(opt.isPresent()) {
	    	   FoodCart fc=opt.get();
	    	   fcp.delete(fc);
	    	   return fc;
	       }else {
	    	   throw new FoodCartException("FoodCart  not clear....");
	       }
	}

}
