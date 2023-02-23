package com.cgi.boat.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    static Map<String, List<String>> lastnamesByFirstname(List<Person> people){
        return groupByFirst(
                people.stream()
                        .map(p -> new String[]{p.getFirstName(), p.getLastName()})
                        .collect(Collectors.toList()));
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
        return groupByFirst(
                people.stream()
                        .map(p -> new String[]{p.getLastName(), p.getFirstName()})
                        .collect(Collectors.toList()));
    }

    static Map<String, List<String>> groupByFirst(List<String[]> namePairList) {
        Map<String, List<String>> res = new HashMap<>();
        namePairList.forEach(m -> {
            if (!res.isEmpty() && res.containsKey(m[0])) {
                res.get(m[0]).add(m[1]);
            } else {
                res.put(m[0], new ArrayList<>(Collections.singletonList(m[1])));
            }
        });
        return res;
    }

}
