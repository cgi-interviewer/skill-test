package com.cgi.boat.interview;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Map<String, List<String>> firstByLast = PeopleProcessor.firstnamesByLastname(PeopleSetup.people);
        Map<String, List<String>> lastByFirst = PeopleProcessor.lastnamesByFirstname(PeopleSetup.people);

        // TODO: Print out 3 most common first names along with number of occurrences
        // for example:
        // Homer: 32
        // Bart: 21
        // William: 3

        threeMostCommonOccurences(commonOccurences(lastByFirst,firstByLast));

    }

    private static Map<String, Long> commonOccurences(Map<String, List<String>> lastNamesByFirst, Map<String, List<String>> firstNamesByLast) {
        List<String> allFirstNames = lastNamesByFirst.keySet().stream().collect(Collectors.toList());
        allFirstNames.addAll(firstNamesByLast.values().stream()
                .flatMap(firstName -> firstName.stream())
                .collect(Collectors.toList()));

        return allFirstNames.stream().collect(
                Collectors.groupingBy(
                        Function.identity(),
                        HashMap::new,
                        Collectors.counting()
                )
        );
    }

    private static void threeMostCommonOccurences(Map<String, Long> occurences) {
        Map<String,Long> sorted = occurences.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        List<Map.Entry<String,Long>> entryList =
                new ArrayList<Map.Entry<String, Long>>(sorted.entrySet());
        System.out.println(entryList.get(entryList.size()-1)+", "+entryList.get(entryList.size()-2)+", "+entryList.get(entryList.size()-3));
    }







}
