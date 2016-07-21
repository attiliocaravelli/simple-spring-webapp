package com.demo.spring.webapp.services;


import com.demo.spring.webapp.domain.Customer;

public interface CustomerService {
    Iterable<Customer> listAllCustomers();

    Customer getCustomerById(Integer id);

    Customer saveCustomer(Customer customer);
}
