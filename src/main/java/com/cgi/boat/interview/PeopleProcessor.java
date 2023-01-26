package com.cgi.boat.interview;

import java.util.*;

class PeopleProcessor {
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
		Map<String, List<String>> personMap = new HashMap<>();
		people.forEach(person -> collectNameValuesByKey(personMap, person.getFirstName(), person.getLastName()));
		return personMap;
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
		Map<String, List<String>> personMap = new HashMap<>();
		people.forEach(person -> collectNameValuesByKey(personMap, person.getLastName(), person.getFirstName()));
		return personMap;
	}
	 static void collectNameValuesByKey(Map<String, List<String>> personMap, String key, String value) {
		if(personMap.containsKey(key)){
			List<String> names = personMap.get(key);
			if(!names.contains(value)){
				names.add(value);
				personMap.put(key, names);
			}
		} else {
			List<String >names = new ArrayList<>();
			names.add(value);
			personMap.put(key, names);
		}
	}
	
	 static void extractThreeMostPopularFirstNames(Map<String, List<String>> firstnamesByLastname) {
		List<PersonOccurence> threeMostPopularFirstNames = new ArrayList<>();
		Iterator<Map.Entry<String, List<String>>> iterator = firstnamesByLastname.entrySet().iterator();
		Map.Entry<String, List<String>> firstEntry = iterator.next();
		threeMostPopularFirstNames.add(new PersonOccurence(firstEntry.getKey(), firstEntry.getValue().size()));
		while (iterator.hasNext()) {
			Map.Entry<String, List<String>> entry = iterator.next();
			int occurence = entry.getValue().size();
			calculatePosition(threeMostPopularFirstNames, occurence, entry.getKey());
		}
		
		for (PersonOccurence personOccurence : threeMostPopularFirstNames) {
			System.out.println(personOccurence.toString());
		}
	}
	 static void extractThreeMostPopularFirstNamesWithDuplicates(Map<String, Integer> firstnamesByLastname) {
		List<PersonOccurence> threeMostPopularFirstNames = new ArrayList<>();
		Iterator<Map.Entry<String, Integer>> iterator = firstnamesByLastname.entrySet().iterator();
		Map.Entry<String, Integer> firstEntry = iterator.next();
		threeMostPopularFirstNames.add(new PersonOccurence(firstEntry.getKey(), firstEntry.getValue()));
		while (iterator.hasNext()) {
			Map.Entry<String, Integer> entry = iterator.next();
			int occurence = entry.getValue();
			calculatePosition(threeMostPopularFirstNames, occurence, entry.getKey());
		}
		
		for (PersonOccurence personOccurence : threeMostPopularFirstNames) {
			System.out.println(personOccurence.toString());
		}
	}
	
	 static void calculatePosition(List<PersonOccurence> threeMostPopularFirstNames, int occurence, String entry) {
		int position = -1;
		for (int i = 0; i < threeMostPopularFirstNames.size() && i < 3; i++) {
			if (occurence > threeMostPopularFirstNames.get(i).getOccurrence()) {
				position++;
				continue;
			}
			break;
		}
		if (position > -1) {
			if (threeMostPopularFirstNames.size() < 3) {
				threeMostPopularFirstNames.add(new PersonOccurence(entry, occurence));
			} else {
				threeMostPopularFirstNames.add(position, new PersonOccurence(entry, occurence));
				threeMostPopularFirstNames.remove(position + 1);
			}
		}
	}
	
	 static Map<String, Integer> countFirstnames() {
		Map<String, Integer> firstNamesCounted = new HashMap<>();
		PeopleSetup.people.forEach(person -> {
			if (firstNamesCounted.containsKey(person.getFirstName())){
				firstNamesCounted.put(person.getFirstName(), firstNamesCounted.get(person.getFirstName()) + 1);
			} else {
				firstNamesCounted.put(person.getFirstName(),1);
			}
		});
		return firstNamesCounted;
	}
	
	 static void calculateElapsed(long started, long firsnamesByLastName) {
		System.out.println("Elapsed:" + (firsnamesByLastName - started));
	}
}
