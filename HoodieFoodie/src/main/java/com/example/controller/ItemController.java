package com.example.controller;

import com.example.exceptions.CategoryException;
import com.example.exceptions.ItemException;
import com.example.exceptions.ResturantException;
import com.example.model.Category;
import com.example.model.Item;
import com.example.model.Restaurant;
import com.example.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("hoodiefoodie")
public class ItemController {
    @Autowired
    private ItemService itemService;
    @PostMapping("/item")
    private ResponseEntity<Item> addItemHandler(@RequestBody  Item item){
      Item items=itemService.addItem(item);
      return new ResponseEntity<>(items, HttpStatus.CREATED);

    }
    @PutMapping("item")
    private ResponseEntity<Item> updateItemHandler(@RequestBody  Item item) throws ItemException {
        Item uitem=itemService.updateItem(item);
        return new ResponseEntity<>(uitem,HttpStatus.ACCEPTED);
    }
    @GetMapping("item")
    private ResponseEntity<Item> viewItemHandler(@RequestBody Item item) throws ItemException {
        Item item1=itemService.viewItem(item);
        return new ResponseEntity<>(item1,HttpStatus.FOUND);
    }
    @DeleteMapping("item")
    private ResponseEntity<Item> removeItemHandler(@RequestBody Item item) throws ItemException {
        Item ditem=itemService.removeItem(item);
        return new ResponseEntity<>(ditem,HttpStatus.GONE);
    }

    @GetMapping("itemscat")
    private ResponseEntity<List<Item>> viewAllItemByCategoryHandler(@RequestBody Category cat) throws ItemException, CategoryException {
        List<Item> items=itemService.viewAllItem(cat);
        return new ResponseEntity<>(items,HttpStatus.FOUND);
    }

    @GetMapping("itemsres")
    private ResponseEntity<List<Item>> viewAllItemByRestaurantHandler(@RequestBody Restaurant rest) throws ItemException, ResturantException {
        List<Item> items=itemService.viewAllItem(rest);
        return new ResponseEntity<>(items,HttpStatus.FOUND);
    }
  @GetMapping("items/{name}")
  private ResponseEntity<List<Item>> viewAllItemsByNameHandler(@PathVariable("name") String name) throws ItemException {
        List<Item> items=itemService.viewAllItemsByName(name);
        return new ResponseEntity<>(items,HttpStatus.FOUND);
  }


}
