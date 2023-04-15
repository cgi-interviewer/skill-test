package com.cgi.boat.interview;

import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		//Map<String, List<String>> firstByLast = PeopleProcessor.firstnamesByLastname(PeopleSetup.people);
		Map<String, List<String>> lastByFirst = PeopleProcessor.lastnamesByFirstname(PeopleSetup.people);

		//first name
		print(lastByFirst);
	}

	/**
	 * Prints out 3 most common along with number of occurrences 
	 * for example: 
	 * Homer: 32 
	 * Bart: 21 
	 * William: 3
	 */
	public static void print(Map<String, List<String>> groupedMap) {
		groupedMap.entrySet().stream()
				.map(entry -> new Counted(entry.getKey(), entry.getValue()))
				.sorted()
				.limit(3)
				.forEach(entry -> {
					System.out.println(entry);
				});
	}

}
