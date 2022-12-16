package com.example.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Module.FoodCart;

@Repository
public interface FoodCartRepo extends JpaRepository<FoodCart,String > {

	public Optional<FoodCart> findAllById(String cartId);
	

}
