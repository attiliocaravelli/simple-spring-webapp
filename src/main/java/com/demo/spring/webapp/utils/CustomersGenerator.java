package com.demo.spring.webapp.utils;

import com.demo.spring.webapp.configuration.Constraints;
import com.demo.spring.webapp.domain.Customer;

public class CustomersGenerator {

	public static Customer[] generateFakeCustomers(int numberOfCustomers) {
		if (numberOfCustomers < 1) { throw new IllegalArgumentException(); }

		Customer[] customers = new Customer[numberOfCustomers];
		
		for (int i = 0; i < numberOfCustomers; i++) {
			Customer customer = new Customer();
			customer.setName("Attilio " + i);
			customer.setEmail("attiliocaravelli" + i + "@gmail.com");
			
			customer.setAge(calculateFakeAgeBy(i));
			
			customer.setCity("Reggio Calabria Loc. " + i);
			
			customer.setCountry(selectFakeCountryBy(i));
			
			customers[i] = customer;
		}
        return customers;
	}
	
	private static int choice(int counter, int max) {
	    return counter % max;
	}
	
	private static String calculateFakeAgeBy(int counter) {
		return String.valueOf(choice(counter + Constraints.MIN_AGE, Constraints.MAX_AGE));
	}
	
	private static String selectFakeCountryBy(int counter) {
		switch (choice(counter, 5)) {
		case 0: return "Italy";
		case 1: return "Ireland";
		case 2: return "Germany";
		case 3: return "France";
		case 4: return "Netherlands";
		}
		return null;
	}
}
