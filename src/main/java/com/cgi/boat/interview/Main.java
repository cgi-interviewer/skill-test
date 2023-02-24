package com.cgi.boat.interview;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<String, List<String>> firstByLast = PeopleProcessor.firstnamesByLastname(PeopleSetup.people);
        Map<String, List<String>> lastByFirst = PeopleProcessor.lastnamesByFirstname(PeopleSetup.people);

        // Print out 3 most common first names along with number of occurrences
        lastByFirst.entrySet()
                .stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()))
                .limit(3)
                .map(r -> r.getKey() + ": " + r.getValue().size())
                .forEach(System.out::println);
    }
}
