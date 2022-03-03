package com.mouritech.onlinebookstoremanagement;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan("com.mouritech.onlinebookstoremanagement")
@EntityScan("com.mouritech.onlinebookstoremanagement.entity")
@EnableJpaRepositories(basePackages = "com.mouritech.onlinebookstoremanagement.repository")
public class OnlineBookStoreManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineBookStoreManagementApplication.class, args);
	}

}
