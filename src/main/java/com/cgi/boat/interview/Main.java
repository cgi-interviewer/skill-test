package com.cgi.boat.interview;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<String, List<String>> firstByLast = PeopleProcessor.firstnamesByLastname(PeopleSetup.people);
        Map<String, List<String>> lastByFirst = PeopleProcessor.lastnamesByFirstname(PeopleSetup.people);

        System.out.println(firstByLast);
        System.out.println(lastByFirst);

        // TODO: Print out 3 most common first names along with number of occurrences
        // for example:
        // Homer: 32
        // Bart: 21
        // William: 3
        List<String> first3MostCommonFirstName = PeopleProcessor.mostCommonNames(lastByFirst, 3);
        first3MostCommonFirstName.forEach(System.out::println);
    }

}
