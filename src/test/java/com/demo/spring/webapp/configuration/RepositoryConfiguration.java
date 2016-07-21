package com.demo.spring.webapp.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.demo.spring.webapp.domain"})
@EnableJpaRepositories(basePackages = {"com.demo.spring.webapp.repositories"})
@EnableTransactionManagement
public class RepositoryConfiguration {
}
