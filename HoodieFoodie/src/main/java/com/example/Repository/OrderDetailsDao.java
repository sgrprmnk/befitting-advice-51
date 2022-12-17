package com.example.repository;


import com.example.exceptions.OrderDetailsException;
import com.example.model.FoodCart;
import com.example.model.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrderDetailsDao extends JpaRepository<OrderDetails, Integer> {

//public 	List<OrderDetails> findById(String restaurantId) throws OrderDetailsException;

    @Query("select c from OrderDetails c where c.cart.cartId=?1")
    public List<OrderDetails> getCart(String cartId);

}
