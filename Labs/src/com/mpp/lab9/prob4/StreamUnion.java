package com.mpp.lab9.prob4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamUnion {

	public static void main(String[] args) {
		List<Set<String>> sets = new ArrayList<Set<String>>();
		{
			sets.add(new HashSet<String>(Arrays.asList("A", "B")));
			sets.add(new HashSet<String>(Arrays.asList("D")));
			sets.add(new HashSet<String>(Arrays.asList("1", "3", "5")));

			Set<String> union = union(sets);
			union.forEach(x -> System.out.println(x));
		}
	}

	/*
	 * transform the list [{“A”, “B”}, {“D”}, {“1”, “3”, “5”}] to 
	 * the set {“A”, “B”, “D”, “1”, “3”, “5”}.
	 */
	public static Set<String> union(List<Set<String>> sets) {
		Set<String> set = sets.stream().flatMap(Set::stream).collect(Collectors.toSet());
		return set;
	}

}
