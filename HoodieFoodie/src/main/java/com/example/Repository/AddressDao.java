package com.example.repository;

import com.example.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressDao extends JpaRepository<Address,String> {
    public Address findByArea(String area);
}
