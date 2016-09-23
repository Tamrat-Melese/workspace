package com.mpp.lab9.prob1;

import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Question1 {

	public static void main(String[] args) {
		{
			long maxSize = 3;
			IntStream ones = IntStream.generate(() -> 1).limit(maxSize);
			ones.forEach(System.out::println);
			
		}
		
		{
			Stream<String> stringStream = Stream.of("Bill", "Thomas", "Mary");
			System.out.println(stringStream.collect(Collectors.joining(", ")));
		}
		
		{
			Stream<Integer> myIntStream = Stream.of(1, 2, 3, 4, 5, 6);
			IntSummaryStatistics summary = myIntStream.collect(Collectors.summarizingInt(n -> n));
			System.out.println("max " + summary.getMax());
			System.out.println("min " + summary.getMin());
		}
	}
}
