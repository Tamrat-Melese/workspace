package com.mpp.lab9.prob5;

import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class LambdaLibrary {
	public static final Function<List<Employee>,  List<Employee>> NAME_LIST = list -> list.stream()
			.sorted((e1, e2) -> e1.getFirstName().compareTo(e2.getFirstName()))
			.filter(lname -> lname.getLastName().charAt(0) > 'M')
			.filter(lname -> lname.getLastName().charAt(0) <= 'Z')
			.filter(sal -> sal.getSalary() > 100000)
			.collect(Collectors.toList());
}
