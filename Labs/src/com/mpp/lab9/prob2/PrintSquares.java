package com.mpp.lab9.prob2;

import java.util.stream.IntStream;

public class PrintSquares {

	public static void main(String[] args) {
		printSquares(4);
	}
	
	public static void printSquares(int num) {
		IntStream
				.rangeClosed(1, num)
				.map(n -> n * n)
				.forEach(System.out::println);
	}

}