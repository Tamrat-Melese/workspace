package com.mpp.lab10.prob1.soln1;

import com.mpp.lab10.prob1.Employee;
import com.mpp.lab10.prob1.Main;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Stream;

public class TestMain {
    @Test
    public void testAsString(){
        Stream<Employee> emps = Arrays.asList(new Employee("Joe", "Davis", 120000),
                new Employee("John", "Sims", 110000),
                new Employee("Joe", "Stevens", 200000),
                new Employee("Andrew", "Reardon", 80000),
                new Employee("Joe", "Cummings", 760000),
                new Employee("Steven", "Walters", 135000),
                new Employee("Thomas", "Blake", 111000),
                new Employee("Alice", "Richards", 101000),
                new Employee("Donald", "Trump", 100000)).stream();

        Assert.assertEquals(Main.asString(emps), "Alice Richards, Joe Stevens, John Sims, Steven Walters");
    }
}
