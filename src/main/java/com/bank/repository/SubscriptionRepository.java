package com.bank.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bank.model.Subscription;

@Repository
public interface SubscriptionRepository extends CrudRepository<Subscription, Integer> {

}
