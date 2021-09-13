package com.bank.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.stereotype.Service;

import com.bank.model.Category;
import com.bank.model.SubscrResponse;
import com.bank.model.Subscription;

@Service
public interface DataBaseService {

	public void insertAll(List<Category> categoryList);
	
    public void deleteAll();
    
    public Iterable<Category> getAll();
    
    public SubscrResponse saveSubscription(Subscription subscResponse);

	public CompletableFuture<List<Subscription>> sortSubscrByDate() throws InterruptedException;
}