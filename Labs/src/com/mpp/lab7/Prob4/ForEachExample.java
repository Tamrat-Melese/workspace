package edu.mum.cs.cs401.examples.java8.prob4;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ForEachExample {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("Hello there", "Goodbye", "Back soon", "Away", "On Vacation",
				"Everywhere you want to be");
		
		Consumer<String> consumer = ForEachExample::printInUpperCase;
		
		for (String s : list) {
			consumer.accept(s.toUpperCase());
		}

	}

	public static void printInUpperCase(String str) {
		System.out.println(str);
	}
}