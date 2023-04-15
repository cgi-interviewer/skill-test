package com.cgi.boat.interview;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class PeopleProcessor {
	/**
	 * Returns a {@link Map} where keys are first names and values lists of all last
	 * names of people from the input list who have the first name equal to the key.
	 *
	 * Example: For input: ["John Doe", "John Silver", "Peter Doe"] Expected result
	 * would be: { "John" -> ["Doe", "Silver"] "Peter" -> ["Doe"] }
	 */
	static Map<String, List<String>> lastnamesByFirstname(List<Person> people) {

		if (people == null) {
			return Collections.emptyMap();
		}

		return people.stream().collect(Collectors.groupingBy(p -> {
			if (p.getFirstName() == null) {
				return "";
			}
			return p.getFirstName();
		}, Collectors.collectingAndThen(Collectors.toList(),
				list -> list.stream().map(p -> p.getLastName()).collect(Collectors.toList()))));
	}

	/**
	 * Same as {@link PeopleProcessor#lastnamesByFirstname} except that the mapping
	 * returned is lastname -> firstnames
	 *
	 * Example: For input: ["John Doe", "John Silver", "Peter Doe"] Expected result
	 * would be: { "Doe" -> ["John", "Peter"] "Silver" -> ["John"]
	 *
	 */
	static Map<String, List<String>> firstnamesByLastname(List<Person> people) {
		// TODO: implement
		return null;
	}

}
