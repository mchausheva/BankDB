package com.bank.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bank.model.Category;
import com.bank.model.EResponse;
import com.bank.model.Subscription;

@Service
public interface DataBaseService {

	public void insertAll(List<Category> categoryList);
	
    public void deleteAll();
    
    public Iterable<Category> getAll();
    
    public EResponse saveSubscription(Subscription subscResponse);
}