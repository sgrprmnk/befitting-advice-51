package com.example.service;



import com.example.exceptions.BillException;
import com.example.model.Bill;

import java.time.LocalDate;
import java.util.List;

public interface BillServices {
	public Bill addBill(Bill bill) throws BillException;
	public Bill updateBill(Bill bill)throws BillException;
	public Bill removeBill (Bill bill)throws BillException;
	public Bill viewsBill(Bill bill)throws BillException;
	public List<Bill> viewsBillByDate (LocalDate startDate,LocalDate endDate)throws BillException;
	public List<Bill> viewsBillByCustomerId(String custid)throws BillException;
	public Double calculateTotalCost(Bill bill)throws BillException;

}
