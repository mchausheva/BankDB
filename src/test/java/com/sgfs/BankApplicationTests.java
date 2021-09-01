package com.sgfs;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bank.BankApplication;
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
		//DivideMerchantCategory list = bankService.getMerchants();
	    
	    //Assert.assertEquals(12, list.getMerchantList());
	}
	
	@Test
	public void insertMerchant() {

	}
}
