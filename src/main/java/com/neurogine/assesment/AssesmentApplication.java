package com.neurogine.assesment;

import java.util.Arrays;
import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AssesmentApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AssesmentApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(
				Stream.of("neurogine", "java", "Spring").map(String::toUpperCase).map(s -> s + ",").findFirst().get());

		Arrays.asList("abc", "an", "", "apple", "bcd", "", "jk");

		Stream.of("abc", "an", "", "apple", "bcd", "", "jk").filter(s -> s.startsWith("a")).count();

	}

}
