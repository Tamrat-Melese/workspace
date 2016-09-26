package com.mpp.lab10.prob1.soln2;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.mpp.lab10.prob1.Employee;

public class TestMain {

	static class EmployeeData {
		Employee employee;
		Boolean salary;
		Boolean lastNameAfterM;

		public EmployeeData(Employee employee, Boolean salary, Boolean lastNameAfterM) {
			super();
			this.employee = employee;
			this.salary = salary;
			this.lastNameAfterM = lastNameAfterM;
		}
	}

	private static List<EmployeeData> listEmployeeData = Arrays.asList(
			new EmployeeData(new Employee("Joe", "Davis", 120000), true, false),
			new EmployeeData(new Employee("John", "Sims", 110000), true, true),
			new EmployeeData(new Employee("Joe", "Stevens", 200000), true, true),
			new EmployeeData(new Employee("Andrew", "Reardon", 80000), false, true),
			new EmployeeData(new Employee("Joe", "Cummings", 760000), true, false),
			new EmployeeData(new Employee("Steven", "Walters", 135000), true, true),
			new EmployeeData(new Employee("Thomas", "Blake", 111000), true, false),
			new EmployeeData(new Employee("Alice", "Richards", 101000), true, true),
			new EmployeeData(new Employee("Donald", "Trump", 100000), false, true)
	);

	@Test
	public void testSalaryGreaterThan100000() {
		for (EmployeeData employeeData : listEmployeeData) {
			Assert.assertEquals(
					employeeData.salary,
					TestMainUtil.salaryGreaterThan100000(employeeData.employee)
			);
		}
	}

	@Test
	public void testLastNameAfterM() {
		for (EmployeeData employeeData : listEmployeeData) {
			Assert.assertEquals(
					employeeData.lastNameAfterM,
					TestMainUtil.lastNameAfterM(employeeData.employee)
			);
		}
	}

	@Test
	public void testFullName() {
		for (EmployeeData employeeData : listEmployeeData) {
			Employee employee = employeeData.employee;
			
			StringBuilder builder = new StringBuilder();
			builder.append(employee.getFirstName()).append(" ").append(employee.getLastName());
			
			Assert.assertEquals(
					builder.toString(),
					TestMainUtil.fullName(employeeData.employee)
			);
		}
	}
}
