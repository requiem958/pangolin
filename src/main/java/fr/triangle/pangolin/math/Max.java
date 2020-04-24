package fr.triangle.pangolin.math;

import fr.triangle.pangolin.dataframe.Column;

public class Max extends MathColumnOperation {

	@Override
	protected Integer opOnInteger(Integer a, Integer b) throws ArithmeticException {
		return Integer.max(a, b);
	}

	@Override
	protected Double opOnDouble(Double a, Double b) throws ArithmeticException {
		return Double.max(a, b);
	}

	@Override
	protected int endOpOnInteger(Integer a, Column<Integer> c) throws ArithmeticException {
		return a;
	}

	@Override
	protected double endOpOnDouble(Double a, Column<Double> c) throws ArithmeticException {
		return a;
	}

}
