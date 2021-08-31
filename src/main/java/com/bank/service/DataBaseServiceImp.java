package com.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bank.model.Category;
import com.bank.model.EResponse;
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
		log.info("Inserting ");
		categoryRepository.saveAll(categoryList);
	}

	@Override
	public void deleteAll() {
		log.info("Delete all ");
		merchantRepository.deleteAll();
		categoryRepository.deleteAll();
	}

	@Override
	public Iterable<Category> getAll() {
		return categoryRepository.findAll();
	}

	@Override
	public EResponse saveSubscription(Subscription subscription) {
		EResponse response = new EResponse();

		try {
			subscrRepository.save(subscription);
			boolean have = subscrRepository.existsById(subscription.subscriptionId);
			if (have) {
				response.setStatus(EResponse.ResStatus.OK);
			} else {
				response.setStatus(EResponse.ResStatus.GENERAL_ERROR);
			}
		} catch (Exception e) {
			response.setStatus(EResponse.ResStatus.GENERAL_ERROR);
		}
		return response;
	}
}