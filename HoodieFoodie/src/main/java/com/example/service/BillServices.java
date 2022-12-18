package com.example.service;



import com.example.exceptions.BillException;
import com.example.model.Bill;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface BillServices {
	public Bill addBill(Bill bill) throws BillException;
	public Bill updateBill(Bill bill)throws BillException;
	public Bill removeBill (String billId)throws BillException;
	public Bill viewsBill(String billId)throws BillException;
	public List<Bill> viewsBillByDate (LocalDate startDate,LocalDate endDate)throws BillException;
	public Bill viewsBillByTime(LocalDateTime localDateTime) throws BillException;
	public Double calculateTotalCost(Bill bill)throws BillException;

}
