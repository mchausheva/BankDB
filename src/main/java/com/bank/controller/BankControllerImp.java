package com.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.model.Category;
import com.bank.model.ERequest;
import com.bank.model.EResponse;
import com.bank.service.DataBaseService;

@RestController
public class BankControllerImp implements BankContoller{

	@Autowired
	private DataBaseService baseService;
	
	@Override
	@GetMapping("/getMerchantsData")
	public Iterable<Category> getMerchantsData() {
		return baseService.getAll();
	}
	
	@Override
	@PostMapping("/checkBill")
	public EResponse checkBill(ERequest eRequest) {
		return null;
	}
}
