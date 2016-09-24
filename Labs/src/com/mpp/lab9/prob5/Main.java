package edu.mum.cs.cs401.examples.java8.lesson9.Five;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		List<Employee> list = Arrays.asList(new Employee("Joe", "Davis", 120000), new Employee("John", "Sims", 110000),
				new Employee("Joe", "Stevens", 200000), new Employee("Andrew", "Reardon", 80000),
				new Employee("Joe", "Cummings", 760000), new Employee("Steven", "Walters", 135000),
				new Employee("Thomas", "Blake", 111000), new Employee("Alice", "Richards", 101000),
				new Employee("Donald", "Trump", 100000));

		// Modify it to print last names starting with N-Z

		int count = 0;

		
		//=================== 5a =====================================
		
		// List<Employee> empList = list.stream().sorted((e1, e2) ->
		// e1.getFirstName().compareTo(e2.getFirstName()))
		// .filter(lname -> lname.getLastName().startsWith("S")).filter(sal ->
		// sal.getSalary() > 100000)
		// .collect(Collectors.toList());
		// for (Employee e : empList) {
		// System.out.print(e.firstName + " " + e.lastName);
		// if (!(count == empList.size() - 1)) {
		// System.out.print(", ");
		// }
		// count++;
		// }

		
		//=================== 5b =====================================
		List<Employee> listSorted = LambdaLibrary.NAME_LIST.apply(list, "S");
		
		for (Employee employee : listSorted) {
			System.out.print(employee.firstName + "  " + employee.lastName);
			if (!(count == listSorted.size() - 1))
				System.out.print(", ");
			count++;
		}
	
	}

}
