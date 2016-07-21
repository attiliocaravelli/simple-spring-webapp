package com.demo.spring.webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.demo.spring.webapp.domain.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer>{
}
