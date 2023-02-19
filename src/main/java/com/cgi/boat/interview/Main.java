package com.cgi.boat.interview;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<String, List<String>> firstByLast = PeopleProcessor.firstnamesByLastname(PeopleSetup.people);
        Map<String, List<String>> lastByFirst = PeopleProcessor.lastnamesByFirstname(PeopleSetup.people);

        printTopThreeOccurrences(firstByLast);
        printTopThreeOccurrences(lastByFirst);
    }

    private static void printTopThreeOccurrences(Map<String, List<String>> map) {
        map.entrySet()
            .stream()
            .map(entry -> new CounterEntry<>(entry))
            .sorted(Comparator.reverseOrder())
            .limit(3)
            .forEach(CounterEntry::print);
    }
}
