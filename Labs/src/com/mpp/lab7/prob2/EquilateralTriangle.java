package com.mpp.lab7.prob2;

import java.util.Arrays;

public class EquilateralTriangle implements ClosedCurve {
	/** sides of the triangle, defined so that side1 = side2 = side3 */
	private double side1;
	private double side2;
	private double side3;

	public EquilateralTriangle(double side1, double side2, double side3) {
		super();
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}

	@Override
	public double[] getSides() {
		double[] sides = { side1, side2, side3 };
		return sides;
	}

	@Override
	public double computePerimeter() {
		return Arrays.stream(getSides()).sum();
	}

	public double getSide1() {
		return side1;
	}

	public void setSide1(double side1) {
		this.side1 = side1;
	}

	public double getSide2() {
		return side2;
	}

	public void setSide2(double side2) {
		this.side2 = side2;
	}

	public double getSide3() {
		return side3;
	}

	public void setSide3(double side3) {
		this.side3 = side3;
	}
}
