package com.example.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hoodie.foodie.Exception.OrderDetailsException;
import hoodie.foodie.Module.OrderDetails;
@Repository
public interface  OrderDetailsRepo extends JpaRepository<OrderDetails, Integer> {

public 	List<OrderDetails> findById(String restaurantId) throws OrderDetailsException;

}
