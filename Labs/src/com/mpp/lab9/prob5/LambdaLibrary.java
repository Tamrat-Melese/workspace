package com.mpp.lab9.prob5;

import java.util.List;
import java.util.stream.Collectors;

public class LambdaLibrary {
	
	public static final QuaterFunction<List<Employee>,  Character,  Character,  Integer,  String> NAME_LIST = 
			(list, lastNameRangeStart, lastNameRangeEnd, salary) ->
			list.stream()
			.filter(lname -> lname.getLastName().charAt(0) > lastNameRangeStart)
			.filter(lname -> lname.getLastName().charAt(0) <= lastNameRangeEnd)
			.filter(sal -> sal.getSalary() > salary)
			.map(e -> e.getFullName())
			.sorted()
			.collect(Collectors.joining(", "));
}
