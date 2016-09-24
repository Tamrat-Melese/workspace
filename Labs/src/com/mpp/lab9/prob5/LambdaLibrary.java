package edu.mum.cs.cs401.examples.java8.lesson9.Five;

import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class LambdaLibrary {
	public static final BiFunction<List<Employee>, String, List<Employee>> NAME_LIST = (list, search) -> list.stream()
			.sorted((e1, e2) -> e1.getFirstName().compareTo(e2.getFirstName()))
			.filter(lname -> lname.getLastName().startsWith("S")).filter(sal -> sal.getSalary() > 100000)
			.collect(Collectors.toList());
}
