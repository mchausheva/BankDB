package com.bank.service;

import org.springframework.stereotype.Service;

import com.bank.model.DivideMerchantCategory;
import com.bank.model.ERequest;
import com.bank.model.EResponse;

@Service
public interface BankService {

	public DivideMerchantCategory getMerchants();

	public EResponse checkBill(ERequest eRequest);
	
	public EResponse checkBillBlocked(ERequest eRequest);
	
	public EResponse payBill(ERequest eRequest);
	
	public EResponse reverseBill(ERequest eRequest);
}
