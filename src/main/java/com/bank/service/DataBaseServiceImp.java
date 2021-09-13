package com.bank.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.bank.model.Category;
import com.bank.model.SubscrResponse;
import com.bank.model.SubscrResponse.ResponseStatus;
import com.bank.model.Subscription;
import com.bank.repository.CategoryRepository;
import com.bank.repository.MerchantRepository;
import com.bank.repository.SubscriptionRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class DataBaseServiceImp implements DataBaseService {

	@Autowired
	private MerchantRepository merchantRepository;

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private SubscriptionRepository subscrRepository;
	
	@Override
	public void insertAll(List<Category> categoryList) {
		log.info("Inserting. ");
		categoryRepository.saveAll(categoryList);
	}

	@Override
	public void deleteAll() {
		log.info("Delete all. ");
		merchantRepository.deleteAll();
		categoryRepository.deleteAll();
	}

	@Override
	public Iterable<Category> getAll() {
		log.info("Get merchants and categories. ");
		return categoryRepository.findAll();
	}
	
	@Override
	public SubscrResponse saveSubscription(Subscription subscription) {
		log.info("Save Subscription. ");

		SubscrResponse response = new SubscrResponse(null, null, null, null, null, null, 0);
		
		subscrRepository.save(subscription);
		boolean existId = subscrRepository.existsById(subscription.getSubscriptionId());
		
		
		if (!existId) {
			response = new SubscrResponse("200", "SUCCESS", "Успешно", null, null, "Success", 1);
			response.setStatus(ResponseStatus.OK);
		} else {
			response.setStatus(SubscrResponse.ResponseStatus.GENERAL_ERROR);
		}
		
		return response;
	}

	@Override
	public CompletableFuture<List<Subscription>> sortSubscrByDate() throws InterruptedException{		
		log.info("Sort Subscription by Date. ");
		
		Pageable pageable = PageRequest.of(1, 20, Sort.by("cachedDueCheckedDate").ascending());
		Page<Subscription> page = subscrRepository.findAll(pageable);
		
		List<Subscription> listSubscr = page.getContent();

	    return CompletableFuture.completedFuture(listSubscr);
		
	    //return listSubscr;
	}
}