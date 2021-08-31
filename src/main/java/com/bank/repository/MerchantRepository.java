package com.bank.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bank.model.Merchant;

@Repository
public interface MerchantRepository extends CrudRepository<Merchant, String>{

}
