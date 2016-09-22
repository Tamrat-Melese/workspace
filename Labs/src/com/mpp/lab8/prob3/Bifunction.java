package com.mpp.lab8.prob3;


import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class Bifunction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BiFunction<Double, Double, List<Double>> f = 
			(x,y) -> {
				List<Double> list = new ArrayList<>();
				list.add(Math.pow(x,y));
				list.add(x * y);
				return list;
			};
		System.out.println(f.apply(2.0, 3.0));	
	}

}
