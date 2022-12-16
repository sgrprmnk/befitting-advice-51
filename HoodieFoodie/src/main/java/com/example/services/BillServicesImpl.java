package com.example.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Exception.BillException;
import com.example.Module.Bill;
import com.example.Repo.BillRepo;

@Service
public class BillServicesImpl implements BillServices {
	
	
	@Autowired
      BillRepo bp;
	
	
	
	
	@Override
	public Bill addBill(Bill bill) throws BillException {
		
		Bill return_bill=bp.save(bill);
		if(return_bill==null) {
			throw new BillException("Bill Data Not Added..");
		}
		else {
			return return_bill;
		}
		
	}

	@Override
	public Bill updateBill(Bill bill) throws BillException {
		Optional<Bill> opt=bp.findById(bill.getBillId());
		if(opt.isPresent()) {
		 
		 Bill bills= bp.save(bill);
		 return bills;
		}else {
			throw new BillException("Enter a Valid Data ...");
		}
 	}

	@Override
	public Bill removeBill(Bill bill) throws BillException {
		// TODO Auto-generated method stub
		Optional<Bill> opt=bp.findById(bill.getBillId());
		if(opt.isPresent()) {
			Bill bills=opt.get();
			bp.delete(bills);
			return bills;
		}else {
			throw new BillException("Enter a Valid Data");
		}
		
	}

	
	
	@Override
	public Bill viewsBill(Bill bill) throws BillException {
		Optional<Bill> opt=bp.findById(bill.getBillId());
		if(opt.isPresent()) {
			Bill bills=opt.get();
			return bills;
		}else {
			throw new BillException("Enter a valid data...");
		}
	}

	
	
	
	@Override
	public List<Bill> viewsBillByDate(LocalDate startDate, LocalDate endDate) throws BillException {
		List<Bill> bill_list=bp.findByBillDateBetweenBills(startDate, endDate);
		// TODO Auto-generated method stub
		if(bill_list.isEmpty()) {
			throw new BillException("data not found...");
		}else {
			return bill_list;
		}
		
	}

	@Override
	public List<Bill> viewsBillByCustomerId(String custid) throws BillException {
		// TODO Auto-generated method stub	4
		
		return null;
	}

	@Override
	public double calculateTotalCost(Bill bill) throws BillException {
		Optional<Bill> opt=bp.findById(bill.getBillId());
		if(opt.isPresent()) {
			Bill bills=opt.get();
			double totalCost=bills.getTotalCost();
		return totalCost;
		}
		else {
			throw new BillException("Enter a valid Data...");
		}
	}

	
}
