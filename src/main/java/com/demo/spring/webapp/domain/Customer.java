package com.demo.spring.webapp.domain;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@Entity
@Table(name = "customers")
public class Customer extends AbstractEntity{

	@Column(name = "name", nullable = false, length = com.demo.spring.webapp.configuration.Constraints.MAX_NAME_LENGTH)
	@Size(min = com.demo.spring.webapp.configuration.Constraints.MIN_NAME_LENGTH,
		  max = com.demo.spring.webapp.configuration.Constraints.MAX_NAME_LENGTH,
		  message = "{customer.name.size}")
	private String name;
	
	@Column(name = "email", length = com.demo.spring.webapp.configuration.Constraints.MAX_EMAIL_LENGTH)
	@Size(min = com.demo.spring.webapp.configuration.Constraints.MIN_EMAIL_LENGTH,
	      max = com.demo.spring.webapp.configuration.Constraints.MAX_EMAIL_LENGTH,
	      message = "{customer.email.size}")
	@Email(message = "{customer.email.email}")
	private String email;
	
	@Column(name = "age", length = com.demo.spring.webapp.configuration.Constraints.MAX_AGE_LENGTH)
	@NotNull(message = "{customer.age.notnull}")
	@Pattern(regexp="[\\d]{2}", message = "{customer.age.pattern}" )
	@Min(value = com.demo.spring.webapp.configuration.Constraints.MIN_AGE, 
		 message = "{customer.age.min}")
	@Max(value = com.demo.spring.webapp.configuration.Constraints.MAX_AGE,
		 message = "{customer.age.max}")
	private String age;
	
	@Column(name = "city", length = com.demo.spring.webapp.configuration.Constraints.MAX_LOCATION_LENGTH)
	@Size(min = com.demo.spring.webapp.configuration.Constraints.MIN_LOCATION_LENGTH, 
		  max = com.demo.spring.webapp.configuration.Constraints.MAX_LOCATION_LENGTH,
		  message = "{customer.city.size}")
	private String city;
	
	@Column(name = "country", length = com.demo.spring.webapp.configuration.Constraints.MAX_LOCATION_LENGTH)
    @Size(min = com.demo.spring.webapp.configuration.Constraints.MIN_LOCATION_LENGTH, 
  		  max = com.demo.spring.webapp.configuration.Constraints.MAX_LOCATION_LENGTH, 
    	  message = "{customer.country.size}")
	private String country;
	
	@Column(name = "mailing_list", columnDefinition = "BOOLEAN default false")
    private boolean inMailingList = false;
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name.trim();
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age.trim();
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email.trim();
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city.trim();
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country.trim();
	}
	public boolean isInMailingList() {
		return inMailingList;
	}
	public void setInMailingList(boolean inMailingList) {
		this.inMailingList = inMailingList;
	}
}
