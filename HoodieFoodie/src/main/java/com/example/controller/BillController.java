package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import hoodie.foodie.Exception.BillException;
import hoodie.foodie.Module.Bill;
import hoodie.foodie.Repo.BillRepo;
import hoodie.foodie.Services.BillServices;

public class BillController {

	@Autowired
	BillServices bs;
	
  @PostMapping("/Bill")
	public ResponseEntity<Bill> AddBill(@RequestBody Bill bill) throws BillException {
		
		Bill bills=bs.addBill(bill);
		return new ResponseEntity<Bill>(bills,HttpStatus.ACCEPTED);
	}
  
  
  
  
  @PutMapping("/Bill")
  public ResponseEntity<Bill> updateBill(@RequestBody Bill bill) throws BillException{
	  Bill bills=bs.updateBill(bill);
	  return new ResponseEntity<Bill>(bills,HttpStatus.ACCEPTED);	  
  }
  
  
  
  
  @DeleteMapping("/Bill")
  public ResponseEntity<Bill>  deleteBill(@RequestBody Bill bill)throws BillException{
	  Bill bills=bs.removeBill(bill);
	  return new ResponseEntity<Bill>(bills,HttpStatus.OK);
  }
  
  
  
  @GetMapping("/ViewBill")
  public ResponseEntity<Bill> viewBill(@RequestBody Bill bill) throws BillException{
	  Bill bills=bs.viewsBill(bill);
	  return new ResponseEntity<Bill>(bills,HttpStatus.ACCEPTED);
  }
  
  
  
  @GetMapping("/totalcostofBill")
  public  double totalCostBill(@RequestBody Bill bill) throws BillException{
	  double totalCost=bs.calculateTotalCost(bill);
	  return totalCost;
  }
  
  
  
}
