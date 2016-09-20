package com.mpp.lab7.prob2;

public interface Polygon {

	default double[] getSides(){
		throw new UnsupportedOperationException("getSides");
	}
}
