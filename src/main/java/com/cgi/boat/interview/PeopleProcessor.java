package com.cgi.boat.interview;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class PeopleProcessor {
    /**
     *
     * @param people List of Person objects
     * @return       Map with Person's firstName attribute as key
     *               and a String list as value, which contains all the last names
     *               which can connect with the key as a first name last name pair
     */
    static Map<String, List<String>> lastnamesByFirstname(List<Person> people){
        return people
                .stream()
                .collect(Collectors.groupingBy(Person::getFirstName,
                        Collectors.mapping(Person::getLastName, Collectors.toList())));
    }

    /**
     *
     * @param people List of Person objects
     * @return       Map with Person's lastName attribute as key
     *               and a String list as value, which contains all the first names
     *               which can connect with the key as a first name last name pair
     */
    static Map<String, List<String>> firstnamesByLastname(List<Person> people){
        return people
                .stream()
                .collect(Collectors.groupingBy(Person::getLastName,
                        Collectors.mapping(Person::getFirstName, Collectors.toList())));
    }
}
