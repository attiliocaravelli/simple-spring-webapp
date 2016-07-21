Problem
1) Write a HTML web form that collects and stores the following information: 

- Name
- Email
- Age
- City
- Country
- Mailing list opt-in tickbox


Input Data
Database 
Output Data
Database
Data Format
RESTful protocol 
Problem to resolve
Write a HTML web form that collects and stores the model.
Use Java Spring to collect the submitted data and design a database table to store it. Don't forget data validation. Please submit all code, tests, database schema and a readme file on how to deploy and run it.
Model
Customer (Name, Email, Age, City, Country, Mailing list opt-in tickbox)
Type of solution 
Web App by using Spring (Boot, Thymeleaf, Web,  Data JPA and Security)
Hibernate
Thymeleaf HTML engine
Configuration
Global class

I used Spring Boot and H2 Database in order to have a faster development.
The table is automatically created with hibernate specifications
The form is validated with annotation in the model class

Launching the web application:
			mvn clean install spring-boot:run
			http://localhost:8080/

Connection to the H2 Console in order to query the table “Customers” created:
			http://localhost:8080/console
			user: sa pass: sa     db name: springbootdb

