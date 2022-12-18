package com.example.controller;

import com.example.exceptions.BillException;
import com.example.model.Bill;
import com.example.service.BillServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


@RestController
public class BillController {

	@Autowired
	BillServices billServices;

	@PostMapping("/Bill")
	public ResponseEntity<Bill> AddBill(@RequestBody Bill bill) throws BillException {

		Bill bills= billServices.addBill(bill);
		return new ResponseEntity<>(bills, HttpStatus.ACCEPTED);
	}




	@PutMapping("/Bill")
	public ResponseEntity<Bill> updateBill(@RequestBody Bill bill) throws BillException{
		Bill bills= billServices.updateBill(bill);
		return new ResponseEntity<>(bills, HttpStatus.ACCEPTED);
	}




	@DeleteMapping("/bill/{billId}")
	public ResponseEntity<Bill>  deleteBill(@PathVariable("billId") String billId )throws BillException{
		Bill bills= billServices.removeBill(billId);
		return new ResponseEntity<>(bills, HttpStatus.OK);
	}



	@GetMapping("/viewbill/{billId}")
	public ResponseEntity<Bill> viewBill(@PathVariable("billId") String billId) throws BillException{
		Bill bills= billServices.viewsBill(billId);
		return new ResponseEntity<>(bills, HttpStatus.ACCEPTED);
	}



	@GetMapping("/totalcostofBill")
	public  ResponseEntity<Double> totalCostBill(@RequestBody Bill bill) throws BillException{
		Double totalCost= billServices.calculateTotalCost(bill);
		return new ResponseEntity<>(totalCost,HttpStatus.OK);
	}

	@GetMapping("bills/{localdatetime}")
   public ResponseEntity<Bill> viewBillByTimeHandler(@PathVariable("localdatetime")LocalDateTime localDateTime) throws BillException {
		Bill bill =billServices.viewsBillByTime(localDateTime);
		return new ResponseEntity<>(bill,HttpStatus.FOUND);
	}

}