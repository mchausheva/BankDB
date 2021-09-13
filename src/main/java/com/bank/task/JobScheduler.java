package com.bank.task;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.bank.model.DivideMerchantCategory;
import com.bank.model.ERequest;
import com.bank.model.EResponse;
import com.bank.model.EResponse.ResStatus;
import com.bank.model.Subscription;
import com.bank.repository.SubscriptionRepository;
import com.bank.service.BankService;
import com.bank.service.DataBaseService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableAsync
@Service
public class JobScheduler {

	@Autowired
	private BankService bankService;
	
	@Autowired
	private DataBaseService dataBaseService;
	
	@Autowired
	SubscriptionRepository subscriptionRepo;

	@Scheduled(fixedRate = 500_000)
	public void refreshMerchantCategory()
	{
		log.info("Refreshing Data. ");
		
		DivideMerchantCategory dmc = bankService.getMerchants();
		
		dataBaseService.deleteAll();
		dataBaseService.insertAll(dmc.asList());
	}
	
	@Scheduled(fixedDelay = 500_000)
	public void loadingPendingDues() throws InterruptedException {
		log.info("Loading Dues. ");
		
		ERequest request = new ERequest("", "", "", null, 1000);
		
		
		CompletableFuture<List<Subscription>> s1 = dataBaseService.sortSubscrByDate();
		CompletableFuture<List<Subscription>> s2 = dataBaseService.sortSubscrByDate();
		CompletableFuture<List<Subscription>> s3 = dataBaseService.sortSubscrByDate();
		CompletableFuture<List<Subscription>> s4 = dataBaseService.sortSubscrByDate();
		
		CompletableFuture.allOf(s1,s2,s3,s4).join();
		
	    log.info("--> " + s1);
	    log.info("--> " + s2);
	    log.info("--> " + s3);
	    log.info("--> " + s4);
		
//		for (Subscription subs : s) {
//			EResponse resp = null;
//			subs.setCachedDueCheckedDate(subs.getCachedDueCheckedDate());
//			try {
//				resp = bankService.checkBill(request);
//
//				if (resp.getStatus().equals(ResStatus.OK)) {
//					subs.setCachedDueAmount(resp.getAmount());
//					subs.setCachedDueServiceResponse("Success");
//					
//					log.info("Success. ");
//					
//				} else {
//					subs.setCachedDueServiceResponse("Error");
//					subs.setCachedDueErrorCode(resp.getErrorCode());
//					subs.setCachedDueErrorDescription(resp.getErrorDes());
//					
//					log.info("Error. ");
//					
//				}
//			} catch (RuntimeException ex) {
//				log.info("message", ex);
//			}
//			subscriptionRepo.save(subs);
//		}
	}
}