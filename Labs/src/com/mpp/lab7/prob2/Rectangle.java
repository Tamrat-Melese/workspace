package com.mpp.lab7.prob2;

import java.util.Arrays;

public class Rectangle implements Polygon {
	private double length, width;

	public Rectangle(double length, double width) {
		this.length = length;
		this.width = width;
	}

	@Override
	public double[] getSides() {
		double[] sides = { length, width, length, width };
		return sides;
	}

	@Override
	public double computePerimeter() {
		return Arrays.stream(getSides()).sum();
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}
}
