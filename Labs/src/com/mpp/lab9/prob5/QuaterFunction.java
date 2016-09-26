package com.mpp.lab9.prob5;

@FunctionalInterface
public interface QuaterFunction<S, T, U, V, R> {
	
	R apply(S s, T t, U u, V v);
}
