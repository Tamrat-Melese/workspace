package com.mpp.lab10.prob1.soln2;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.mpp.lab10.prob1.Employee;

public class TestMainUtil {


	public static String asString(Stream<Employee> stream){
		return stream
				.filter(TestMainUtil::salaryGreaterThan100000)
				.filter(TestMainUtil::lastNameAfterM)
				.map(TestMainUtil::fullName)
				.sorted()
				.collect(Collectors.joining(", "));
	}

	public static boolean salaryGreaterThan100000(Employee  e) {
		return e.getSalary() > 100000;
	}

	public static boolean lastNameAfterM(Employee e) {
		return e.getLastName().charAt(0) > 'M';
	}


	public static String fullName(Employee e) {
		return e.getFirstName() + " " + e.getLastName();
	}

}
