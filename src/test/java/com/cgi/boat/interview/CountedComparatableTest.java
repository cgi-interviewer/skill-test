package com.cgi.boat.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CountedComparatableTest {

	@Test
	public void test_compare_valid() {
		
		Counted three = new Counted("three", 3);
		Counted one = new Counted("one",1);
		
		Assertions.assertEquals(-2, three.compareTo(one));
		Assertions.assertEquals(2, one.compareTo(three));
	}
	
	@Test
	public void test_compare_null() {
		
		Counted three = new Counted("three", 3);
		
		Assertions.assertEquals(Integer.MAX_VALUE, three.compareTo(null));
	}
	
	@Test
	public void test_compare_in_a_list() {
		
		Counted three = new Counted("three", 3);
		Counted one = new Counted("one",1);
		
		List<Counted> list = new ArrayList<>();
		list.add(one);
		list.add(three);
		
		Collections.sort(list);
		
		Assertions.assertEquals(three, list.get(0), "first element must be three");
		Assertions.assertEquals(one, list.get(1), "second element must be one");
	}
}
