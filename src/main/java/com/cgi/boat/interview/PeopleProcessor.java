package com.cgi.boat.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
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
        return people.parallelStream()
            .collect(Collectors.toConcurrentMap(
                Person::getFirstName,
                person -> createListFrom(person::getLastName),
                (list1, list2) -> mergeLists(list1, list2)
            ));
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
    static Map<String, List<String>> firstnamesByLastname(List<Person> people) {
        return people.parallelStream()
            .collect(Collectors.toConcurrentMap(
                Person::getLastName,
                person -> createListFrom(person::getFirstName),
                (list1, list2) -> mergeLists(list1, list2)
            ));
    }

    private static List<String> createListFrom(Supplier<String> value) {
        List<String> list = new ArrayList<>();
        list.add(value.get());
        return list;
    }

    private static List<String> mergeLists(List<String> list1, List<String> list2) {
        list1.addAll(list2);
        return list1;
    }
}
