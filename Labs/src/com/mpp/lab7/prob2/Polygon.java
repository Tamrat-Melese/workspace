package com.mpp.lab7.prob2;

public interface Polygon extends ClosedCurve{

	default double[] getSides(){
		throw new UnsupportedOperationException("getSides");
	}

	default double computePerimeter() {
		double[] lengths = getSides();
		double sum = 0.0;
		for(double len : lengths) {
			sum += len;
		}
		return sum;
	}
}
