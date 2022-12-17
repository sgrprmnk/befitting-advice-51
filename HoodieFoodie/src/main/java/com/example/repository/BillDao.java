package com.example.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.Bill;
@Repository
public interface BillDao extends JpaRepository<Bill, String> {

//	public List<Bill> findByCustomerId(String custId);

	//	select b from Bill b where b.billDate between ?1 and ?2)
	@Query("select b from Bill b where b.billDate between ?1 and ?2")
	public List<Bill> getBillDateBetweenBills(LocalDate startdate,LocalDate enddate);


}