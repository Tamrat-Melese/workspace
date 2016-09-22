package com.mpp.lab8.prob2.comparator2;

import java.util.Comparator;

public class EmployeeSalaryComparator implements Comparator<Employee> {
	@Override
	public int compare(Employee e1, Employee e2) {
		int result = Integer.compare(e1.salary, e2.salary);
		if (result != 0){			
			return result;
		}
		else {
			return e1.name.compareTo(e2.name);
		}
	}
}
