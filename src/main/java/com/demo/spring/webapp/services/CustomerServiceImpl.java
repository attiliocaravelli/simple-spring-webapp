package com.demo.spring.webapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.spring.webapp.domain.Customer;
import com.demo.spring.webapp.repositories.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;

    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

	@Override
	public Iterable<Customer> listAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Customer getCustomerById(Integer id) {
		return customerRepository.findOne(id);
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
}
