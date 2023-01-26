package com.cgi.boat.interview;

import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		firstImplementation();
		//I've made two versions to compare, wasn't sure about the performance, second one seems faster to me, tested them separately in different run instances, difference is a few ms, not significant
		secondImplementation();
	}
	private static void firstImplementation() {
		long started = System.currentTimeMillis();
		Map<String, List<String>> firstnamesByLastname = PeopleProcessor.firstnamesByLastname(PeopleSetup.people);
		long firsnamesByLastName = System.currentTimeMillis();
		PeopleProcessor.calculateElapsed(started, firsnamesByLastName);
		Map<String, List<String>> lastnamesByFirstname = PeopleProcessor.lastnamesByFirstname(PeopleSetup.people);
		long lastnamesByfirstname = System.currentTimeMillis();
		PeopleProcessor.calculateElapsed(firsnamesByLastName, lastnamesByfirstname);
		//here I wouldn't use the previous map to count the names because it wouldn't count exact name duplicates
		PeopleProcessor.extractThreeMostPopularFirstNamesWithDuplicates(PeopleProcessor.countFirstnames());
		//use the distinct occurences by firstname, this version contains one firstname - lastname combination once
		PeopleProcessor.extractThreeMostPopularFirstNames(lastnamesByFirstname);
	}
	
	private static void secondImplementation() {
		long started = System.currentTimeMillis();
		Map<String, List<String>> firstnamesByLastname = PeopleProcessorWithLambda.firstnamesByLastname(PeopleSetup.people);
		long firsnamesByLastName = System.currentTimeMillis();
		PeopleProcessor.calculateElapsed(started, firsnamesByLastName);
		Map<String, List<String>> lastnamesByFirstname = PeopleProcessorWithLambda.lastnamesByFirstname(PeopleSetup.people);
		long lastnamesByfirstname = System.currentTimeMillis();
        PeopleProcessor.calculateElapsed(firsnamesByLastName, lastnamesByfirstname);
	}
}
