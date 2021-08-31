package com.sgfs;

import java.time.LocalDate;
import java.util.Date;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bank.BankApplication;
import com.bank.model.DivideMerchantCategory;
import com.bank.model.MerchantList;
import com.bank.service.BankService;
import com.bank.service.DataBaseService;

@SpringBootTest(classes = BankApplication.class)
class BankApplicationTests {

	@Autowired
	private BankService bankService;
	
	@Autowired 
	private DataBaseService dataBaseService;
	
	@Test
	public void getMerchant() {
		DivideMerchantCategory list = bankService.getMerchants();
	    
	    Assert.assertEquals(12, list.getMerchantList());
	}
	
	@Test
	public void insertMerchant() {

	}
}
