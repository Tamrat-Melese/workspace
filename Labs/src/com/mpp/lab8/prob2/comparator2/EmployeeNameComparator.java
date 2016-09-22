package com.mpp.lab8.prob2.comparator2;

import java.util.Comparator;

/* A functor, but not a closure */
public class EmployeeNameComparator implements Comparator<Employee> {
	@Override
	public int compare(Employee e1, Employee e2) {
		int result = e1.name.compareTo(e2.name);
		if (result != 0){			
			return result;
		}
		else {
			return Integer.compare(e1.salary, e2.salary);
		}
	}
}
