package com.bank.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.bank.model.DivideMerchantCategory;
import com.bank.service.BankService;
import com.bank.service.DataBaseService;

@Service
public class JobScheduler {

	@Autowired
	private BankService bankService;
	
	@Autowired
	private DataBaseService dataBaseService;

	@Scheduled(fixedRate = 500_000)
	public void refreshMerchantCategory()
	{
		DivideMerchantCategory dmc = bankService.getMerchants();
		
		dataBaseService.deleteAll();
		dataBaseService.insertAll(dmc.asList());
	}
}