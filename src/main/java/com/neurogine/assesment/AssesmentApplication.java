package com.neurogine.assesment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.neurogine.assesment.streams.StreamTest;

@SpringBootApplication
public class AssesmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssesmentApplication.class, args);
	}
	
	@Bean
	public StreamTest streamsTest() {
		return new StreamTest();
	}	

}
