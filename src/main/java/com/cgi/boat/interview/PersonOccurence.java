package com.cgi.boat.interview;

public class PersonOccurence {
	private String firstname;
	private int occurrence;
	
	public PersonOccurence(String firstname, int occurrence) {
		this.firstname = firstname;
		this.occurrence = occurrence;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public int getOccurrence() {
		return occurrence;
	}
	
	@Override
	public String toString() {
		return "PersonOccurence{" +
				"firstname='" + firstname + '\'' +
				", occurrence=" + occurrence +
				'}';
	}
}
