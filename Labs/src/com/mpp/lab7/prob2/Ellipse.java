package com.mpp.lab7.prob2;

public class Ellipse implements ClosedCurve {
	/** length of the semi-major axis */
	private double a;
	/** value of the elliptic integral evaluated at  the ellipse’s eccentricity */
	private double E;

	public Ellipse(double a, double e) {
		super();
		this.a = a;
		E = e;
	}

	@Override
	public double computePerimeter() {
		return (4 * a * E);
	}

	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getE() {
		return E;
	}

	public void setE(double e) {
		E = e;
	}

}
