package com.bank.controller;

import com.bank.model.Category;
import com.bank.model.ERequest;
import com.bank.model.EResponse;

public interface BankContoller {

	public Iterable<Category> getMerchantsData();
	
	public EResponse checkBill(ERequest eRequest);
}
