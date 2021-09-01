package com.bank.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.bank.model.DivideMerchantCategory;
import com.bank.model.ERequest;
import com.bank.model.EResponse;

@Service
public interface BankService {

	public DivideMerchantCategory getMerchants();

	public EResponse checkBill(@RequestBody ERequest eRequest);
	
	public EResponse checkBillBlocked(@RequestBody ERequest eRequest);
	
	public EResponse payBill(@RequestBody ERequest eRequest);
	
	public EResponse reverseBill(@RequestBody ERequest eRequest);
}
