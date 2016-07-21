package com.demo.spring.webapp.bootstrap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.demo.spring.webapp.domain.Customer;
import com.demo.spring.webapp.repositories.CustomerRepository;
import com.demo.spring.webapp.utils.CustomersGenerator;

@Component
public class CustomerLoader implements ApplicationListener<ContextRefreshedEvent> {

    private CustomerRepository customerRepository;

    private Logger log = Logger.getLogger(CustomerLoader.class);

    @Autowired
    public void setProductRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        
        Customer[] customers = CustomersGenerator.generateFakeCustomers(5);
        for (Customer customer : customers) {
        	customerRepository.save(customer);
        	log.info("Saved Customer - id: " + customer.getId());
        }

    }
}
