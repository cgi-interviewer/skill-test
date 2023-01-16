package com.cgi.boat.interview;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Map<String, List<String>> firstByLast = PeopleProcessor.firstnamesByLastname(PeopleSetup.people);
        Map<String, List<String>> lastByFirst = PeopleProcessor.lastnamesByFirstname(PeopleSetup.people);

        List<Map.Entry<String, List<String>>> result = lastByFirst
                .entrySet()
                .stream()
                .sorted((o1, o2) -> Integer.compare(o2.getValue().size(), o1.getValue().size()))
                .limit(3)
                .collect(Collectors.toList());

        result.forEach(stringListEntry -> System.out.println(stringListEntry.getKey() + " : " + stringListEntry.getValue().size()));
    }







}
