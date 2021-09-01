package com.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bank.model.Category;
import com.bank.model.ERequest;
import com.bank.model.EResponse;
import com.bank.model.SubscrResponse;
import com.bank.model.Subscription;
import com.bank.service.BankService;
import com.bank.service.DataBaseService;

@RestController
public class BankControllerImp implements BankContoller{

	@Autowired
	private BankService bankService;
	
	@Autowired
	private DataBaseService baseService;
	
	@Override
	@GetMapping("/getMerchantsData")
	public Iterable<Category> getMerchantsData() {
		return baseService.getAll();
	}
	
	@Override
	@PostMapping(value = "/checkBill")
	public EResponse checkBill(@RequestBody ERequest eRequest) {
		return bankService.checkBill(eRequest);
	}
	
	@Override
	@PostMapping(value = "/saveUpClient")
	public SubscrResponse saveUpClient(@RequestBody Subscription subscription) {
		return baseService.saveSubscription(subscription);
	}
}
