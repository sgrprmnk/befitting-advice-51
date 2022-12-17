package com.example.controller;

import com.example.exceptions.BillException;
import com.example.model.Bill;
import com.example.service.BillServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



public class BillController {

	@Autowired
	BillServices billServices;

	@PostMapping("/Bill")
	public ResponseEntity<Bill> AddBill(@RequestBody Bill bill) throws BillException {

		Bill bills= billServices.addBill(bill);
		return new ResponseEntity<Bill>(bills,HttpStatus.ACCEPTED);
	}




	@PutMapping("/Bill")
	public ResponseEntity<Bill> updateBill(@RequestBody Bill bill) throws BillException{
		Bill bills= billServices.updateBill(bill);
		return new ResponseEntity<Bill>(bills,HttpStatus.ACCEPTED);
	}




	@DeleteMapping("/Bill")
	public ResponseEntity<Bill>  deleteBill(@RequestBody Bill bill)throws BillException{
		Bill bills= billServices.removeBill(bill);
		return new ResponseEntity<Bill>(bills,HttpStatus.OK);
	}



	@GetMapping("/ViewBill")
	public ResponseEntity<Bill> viewBill(@RequestBody Bill bill) throws BillException{
		Bill bills= billServices.viewsBill(bill);
		return new ResponseEntity<Bill>(bills,HttpStatus.ACCEPTED);
	}



	@GetMapping("/totalcostofBill")
	public  double totalCostBill(@RequestBody Bill bill) throws BillException{
		double totalCost= billServices.calculateTotalCost(bill);
		return totalCost;
	}



}