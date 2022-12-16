package com.example.services;

import java.time.LocalDate;
import java.util.List;

import com.example.Exception.BillException;
import com.example.Module.Bill;

public interface BillServices {
	public Bill addBill(Bill bill) throws BillException;
	public Bill updateBill(Bill bill)throws BillException;
	public Bill removeBill (Bill bill)throws BillException;
	public Bill viewsBill(Bill bill)throws BillException;
	public List<Bill> viewsBillByDate (LocalDate startDate,LocalDate endDate)throws BillException;
	public List<Bill> viewsBillByCustomerId(String custid)throws BillException;
	public double calculateTotalCost(Bill bill)throws BillException;

}
