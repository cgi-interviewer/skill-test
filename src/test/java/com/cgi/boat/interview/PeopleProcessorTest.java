package com.cgi.boat.interview;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PeopleProcessorTest extends PeopleProcessor {

	@Test
	public void test_lastnamesByFirstname_valid() {

		/*
		 * Example: For input: ["John Doe", "John Silver", "Peter Doe"] 
		 * Expected result would be: { "John" -> ["Doe", "Silver"] "Peter" -> ["Doe"] }
		 */
		
		List<Person> people = Arrays.asList(
					new Person("John", "Doe"), 
					new Person("John","Silver"), 
					new Person("Peter","Doe")
				);
		
		Map<String, List<String>> result = lastnamesByFirstname(people);
		
		Assertions.assertEquals(2,result.keySet().size());
		
		Assertions.assertEquals(Arrays.asList("Doe", "Silver"),result.get("John"));
		Assertions.assertEquals(Arrays.asList("Doe"),result.get("Peter"));
	}
	
	@Test
	public void test_lastnamesByFirstname_null() {

		Map<String, List<String>> result = lastnamesByFirstname(null);
		
		Assertions.assertTrue(result.keySet().isEmpty());
		
	}
	
	@Test
	public void test_lastnamesByFirstname_invalid_firstname() {

		
		List<Person> people = Arrays.asList(
					new Person(null, "Doe"), 
					new Person("John", "Doe"), 
					new Person("John","Silver"), 
					new Person("Peter","Doe")
				);
		
		Map<String, List<String>> result = lastnamesByFirstname(people);
		
		Assertions.assertEquals(3,result.keySet().size());
		
		Assertions.assertEquals(Arrays.asList("Doe", "Silver"),result.get("John"));
		Assertions.assertEquals(Arrays.asList("Doe"),result.get("Peter"));
	}
	
	@Test
	public void test_lastnamesByFirstname_invalid_lastname() {

		List<Person> people = Arrays.asList(
					new Person("John", null), 
					new Person("John", "Doe"), 
					new Person("John","Silver"), 
					new Person("Peter","Doe")
				);
		
		Map<String, List<String>> result = lastnamesByFirstname(people);
		
		Assertions.assertEquals(2,result.keySet().size());
		
		Assertions.assertEquals(Arrays.asList(null, "Doe", "Silver"),result.get("John"));
		Assertions.assertEquals(Arrays.asList("Doe"),result.get("Peter"));
	}
}
