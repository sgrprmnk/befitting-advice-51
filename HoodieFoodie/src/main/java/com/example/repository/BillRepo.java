package com.example.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hoodie.foodie.Module.Bill;
@Repository
public interface BillRepo extends JpaRepository<Bill, String> {
	
	public List<Bill> findByCustomerId(String custId);
	
//	select b from Bill b where b.billDate between ?1 and ?2)
	public List<Bill> findByBillDateBetweenBills(LocalDate startdate,LocalDate enddate);

	
}
