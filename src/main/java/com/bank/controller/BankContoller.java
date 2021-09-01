package com.bank.controller;

import org.springframework.web.bind.annotation.RequestBody;

import com.bank.model.Category;
import com.bank.model.ERequest;
import com.bank.model.EResponse;
import com.bank.model.SubscrResponse;
import com.bank.model.Subscription;

public interface BankContoller {

	public Iterable<Category> getMerchantsData();
	
	public EResponse checkBill(@RequestBody ERequest eRequest);

	public SubscrResponse saveUpClient(@RequestBody Subscription subscription);
}
