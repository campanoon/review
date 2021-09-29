package com.udacity.jwdnd.c1.review;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ReviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReviewApplication.class, args);
	}
	/*
		System.out.println("message()");
		return "Hello, Spring!";
	}

	@Bean
	String upperMessage(MessageService messageService){
		System.out.println("upperCaseMessageBean");
		return messageService.uppercaseMessage();
	}
	@Bean
	String lowercaseMessage(MessageService messageService){
		System.out.println("lowerCaseMessageBean");
		return messageService.lowercaseMessage();
	}
	*/
}
