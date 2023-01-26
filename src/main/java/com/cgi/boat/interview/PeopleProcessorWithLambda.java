package com.cgi.boat.interview;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PeopleProcessorWithLambda {
	/**
	 * Returns a {@link Map} where keys are first names and values lists of all last names
	 * of people from the input list who have the first name
	 * equal to the key.
	 * <p>
	 * Example:
	 * For input: ["John Doe", "John Silver", "Peter Doe"]
	 * Expected result would be:
	 * {
	 * "John" -> ["Doe", "Silver"]
	 * "Peter" -> ["Doe"]
	 * }
	 */
	static Map<String, List<String>> lastnamesByFirstname(List<Person> people) {
		return getPersonsAttributeByValue(people, personFirstName(), personLastName());
	}
	
	/**
	 * Same as {@link PeopleProcessor#lastnamesByFirstname} except that the mapping
	 * returned is lastname -> firstnames
	 * <p>
	 * Example:
	 * For input: ["John Doe", "John Silver", "Peter Doe"]
	 * Expected result would be:
	 * {
	 * "Doe" -> ["John", "Peter"]
	 * "Silver" -> ["John"]
	 */
	static Map<String, List<String>> firstnamesByLastname(List<Person> people) {
		return getPersonsAttributeByValue(people, personLastName(), personFirstName());
	}
	
	private static Map<String, List<String>> getPersonsAttributeByValue(List<Person> people,
																		Function<Person, String> attributeToMapBy,
																		Function<Person, String> attributeToCollect
	) {
		Map<String, List<String>> personMap = new HashMap<>();
		people.stream()
				.map(attributeToMapBy)
				.distinct()
				.forEach(collectValuesForKey(people, personMap, attributeToMapBy, attributeToCollect));
		return personMap;
	}
	
	private static Consumer<String> collectValuesForKey(List<Person> people,
														Map<String, List<String>> lastnamesByFirstname,
														Function<Person, String> attributeToMapBy,
														Function<Person, String> attributeToCollect) {
		return key ->
				lastnamesByFirstname.put(key,
						people.stream()
								.filter(person -> key.equals(attributeToMapBy.apply(person)))
								.map(attributeToCollect)
								.distinct()
								.collect(Collectors.toList()));
	}
	
	private static Function<Person, String> personFirstName() {
		return Person::getFirstName;
	}
	
	private static Function<Person, String> personLastName() {
		return Person::getLastName;
	}
}
