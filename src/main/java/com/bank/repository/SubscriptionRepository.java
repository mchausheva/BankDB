package com.bank.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bank.model.Subscription;

@Repository
public interface SubscriptionRepository extends CrudRepository<Subscription, Integer> {
	
	  Iterable<Subscription> findAll(Sort sort);

	  Page<Subscription> findAll(Pageable pageable);
}
