package com.mpp.lab9.prob6;

import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaLibrary {
    public static Predicate<Employee> salaryGreaterThan(int i){
        return e -> e.getSalary() > i;
    }

    public static Predicate<Employee> fistLeterInLastNameComeAfter(char c){
        return e -> e.getLastName().charAt(0) > c;
    }

    public static Function<Employee, String> fullNameInCapital(){
        return e -> (e.getFirstName() + " " + e.getLastName()).toUpperCase();
    }
}
