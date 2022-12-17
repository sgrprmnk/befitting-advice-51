package com.example.service;


import com.example.exceptions.BillException;
import com.example.model.Bill;
import com.example.repository.BillDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BillServicesImpl implements BillServices {


	@Autowired
	BillDao billDao;




	@Override
	public Bill addBill(Bill bill) throws BillException {

		Bill return_bill=billDao.save(bill);
		if(return_bill==null) {
			throw new BillException("Bill Data Not Added..");
		}
		else {
			return return_bill;
		}

	}

	@Override
	public Bill updateBill(Bill bill) throws BillException {
		Optional<Bill> opt=billDao.findById(bill.getBillId());
		if(opt.isPresent()) {

			Bill bills= billDao.save(bill);
			return bills;
		}else {
			throw new BillException("Enter a Valid Data ...");
		}
	}

	@Override
	public Bill removeBill(Bill bill) throws BillException {
		// TODO Auto-generated method stub
		Optional<Bill> opt=billDao.findById(bill.getBillId());
		if(opt.isPresent()) {
			Bill bills=opt.get();
			billDao.delete(bills);
			return bills;
		}else {
			throw new BillException("Enter a Valid Data");
		}

	}



	@Override
	public Bill viewsBill(Bill bill) throws BillException {
		Optional<Bill> opt=billDao.findById(bill.getBillId());
		if(opt.isPresent()) {
			Bill bills=opt.get();
			return bills;
		}else {
			throw new BillException("Enter a valid data...");
		}
	}




	@Override
	public List<Bill> viewsBillByDate(LocalDate startDate, LocalDate endDate) throws BillException {
//		List<Bill> bill_list=billDao.findByBillDateBetweenBills(startDate, endDate);
		List<Bill> bill_list =billDao.getBillDateBetweenBills(startDate,endDate);
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
	public Double calculateTotalCost(Bill bill) throws BillException {
		Optional<Bill> opt=billDao.findById(bill.getBillId());
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
