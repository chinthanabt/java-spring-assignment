package com.neurogine.assesment.streams;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

	public StreamTest() {
		// Convert string to upper case and join them with comma(,)
		System.out.println(
				Stream.of("neurogine", "java", "Spring").map(String::toUpperCase).collect(Collectors.joining(",")));

		// Create a List with String more than 2 characters and count number of String
		// which starts with "a" and count empty string.
		Arrays.asList("abc", "an", "", "apple", "bcd", "", "jk");

		// Count number of String which starts with "a"
		System.out.println(Stream.of("abc", "an", "", "apple", "bcd", "", "jk").filter(s -> s.startsWith("a")).count());

		// Count number of empty Strings
		System.out.println(Stream.of("abc", "an", "", "apple", "bcd", "", "jk").filter(s -> "".equals(s)).count());
	}

}
