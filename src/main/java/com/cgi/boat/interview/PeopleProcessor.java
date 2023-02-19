package com.cgi.boat.interview;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class PeopleProcessor {
    /**
     * Returns a {@link Map} where keys are first names and values lists of all last names
     * of people from the input list who have the first name
     * equal to the key.
     *
     * Example:
     * For input: ["John Doe", "John Silver", "Peter Doe"]
     * Expected result would be:
     * {
     *  "John" -> ["Doe", "Silver"]
     *  "Peter" -> ["Doe"]
     * }
     */
    static Map<String, List<String>> lastnamesByFirstname(List<Person> people) {
        return people.stream()
                .collect(nameBy(Person::getFirstName, Person::getLastName));
    }

    /**
     * Same as {@link PeopleProcessor#lastnamesByFirstname} except that the mapping
     * returned is lastname -> firstnames
     *
     * Example:
     * For input: ["John Doe", "John Silver", "Peter Doe"]
     * Expected result would be:
     * {
     *  "Doe" -> ["John", "Peter"]
     *  "Silver" -> ["John"]
     *
     */
    static Map<String, List<String>> firstnamesByLastname(List<Person> people){
        return people.stream()
                .collect(nameBy(Person::getLastName, Person::getFirstName));
    }

    static Collector<Person, ?, Map<String, List<String>>> nameBy(Function<Person, String> groupingName,
                                                                  Function<Person, String> valueName) {
        return Collectors.groupingBy(groupingName,
                Collectors.mapping(valueName, Collectors.toList()));
    }

    static List<String> mostCommonNames(Map<String, List<String>> grouped, long amount){
        return grouped.entrySet()
                .stream()
                .sorted((e1, e2) -> Long.compare(e2.getValue().size(), e1.getValue().size()))
                .limit(amount)
                .map(map -> map.getKey() + ": " + map.getValue().size())
                .collect(Collectors.toList());
    }

}
