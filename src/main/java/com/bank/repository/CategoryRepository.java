package com.bank.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bank.model.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer>{

}
