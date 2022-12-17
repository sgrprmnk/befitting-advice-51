package com.example.repository;

import com.example.model.Customer;
import com.example.model.FoodCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface FoodCartDao extends JpaRepository<FoodCart,String> {
    public Optional<FoodCart> findById(String cartId);
    @Query("select c from FoodCart c where c.customer.customerId=?1")
    public FoodCart getCustomer(String customerId);




}
