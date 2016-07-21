package com.demo.spring.webapp.repositories;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.demo.spring.webapp.configuration.Constraints;
import com.demo.spring.webapp.configuration.RepositoryConfiguration;
import com.demo.spring.webapp.domain.Customer;
import com.demo.spring.webapp.repositories.CustomerRepository;

import static org.junit.Assert.*;

import javax.validation.ConstraintViolationException;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {RepositoryConfiguration.class})
public class CustomerRepositoryTest {

    private CustomerRepository customerRepository;

    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Test
    public void saveNewAndUpdatedCustomer_Test(){
        //setup customer
    	Customer customer = createCustomer();
    	
        //save customer, verify has ID value after save
        assertNull(customer.getId()); //null before save
        customerRepository.save(customer);
        assertNotNull(customer.getId()); //not null after save   
      
        //fetch from DB
        Customer fetchedCustomer = customerRepository.findOne(customer.getId());

        //should not be null
        assertNotNull(fetchedCustomer);

        //should equal
        assertEquals(customer.getId(), fetchedCustomer.getId());
        assertEquals(customer.getName(), fetchedCustomer.getName());

        //update description and save
        fetchedCustomer.setName("Attilio 2");
        customerRepository.save(fetchedCustomer);

        //get from DB, should be updated
        Customer fetchedUpdatedCustomer = customerRepository.findOne(fetchedCustomer.getId());
        assertEquals(fetchedCustomer.getName(), fetchedUpdatedCustomer.getName());

        //verify count of customers in DB
        long customerCount = customerRepository.count();
        assertEquals(customerCount, 1);

        //get all customers, list should only have one
        Iterable<Customer> customers = customerRepository.findAll();

        assertEquals(sizeOf(customers), 1);
    }
    
    @Test(expected = ConstraintViolationException.class)
    public void customerNameValidation_Test(){
        //setup customer
    	Customer customer = createCustomer();
    	customer.setName("A");
    	customerRepository.save(customer);
    }
    
    @Test(expected = ConstraintViolationException.class)
    public void customerEmailValidation_Test(){
        //setup customer
    	Customer customer = createCustomer();
    	customer.setEmail("attilio");
    	customerRepository.save(customer);
    }
    
    @Test(expected = ConstraintViolationException.class)
    public void customerMaxAgeValidation_Test(){
        //setup customer
    	Customer customer = createCustomer();
    	customer.setAge(String.valueOf(Constraints.MAX_AGE + 1));
    	customerRepository.save(customer);
    }
    
    @Test(expected = ConstraintViolationException.class)
    public void customerMinAgeValidation_Test(){
        //setup customer
    	Customer customer = createCustomer();
    	customer.setAge(String.valueOf(Constraints.MIN_AGE - 1));
    	customerRepository.save(customer);
    }
    
    @Test(expected = ConstraintViolationException.class)
    public void customerCityValidation_Test(){
        //setup customer
    	Customer customer = createCustomer();
    	customer.setCity("More  of  MAX LENGHT More  of  MAX LENGHT More  of  MAX LENGHT More  of  MAX LENGHT");
    	customerRepository.save(customer);
    }
    
    @Test(expected = ConstraintViolationException.class)
    public void customerCountryValidation_Test(){
        //setup customer
    	Customer customer = createCustomer();
    	customer.setCountry("More  of  MAX LENGHT More  of  MAX LENGHT More  of  MAX LENGHT More  of  MAX LENGHT");
    	customerRepository.save(customer);
    }
    private Customer createCustomer() {
    	Customer customer = new Customer();
        customer.setName("Attilio Test");
		customer.setEmail("attiliocaravelli@gmail.com");
		
		customer.setAge("38");
		
		customer.setCity("Reggio Calabria");
		
		customer.setCountry("Italy");
		return customer;
    }
    
    private int sizeOf(Iterable<Customer> customers) {
    	  int count = 0;
          
          for(@SuppressWarnings("unused") Customer p : customers){
              count++;
          }
          
          return count;
    }
}
