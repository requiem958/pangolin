package fr.triangle.pangolin.math;

import fr.triangle.pangolin.dataframe.Column;

public class Sum extends MathColumnOperation {

	@Override
	protected Integer opOnInteger(Integer a, Integer b) {
		return a + b;
	}

	@Override
	protected Double opOnDouble(Double a, Double b) {
		return a + b;
	}

	@Override
	protected int endOpOnInteger(Integer a, Column<Integer> c) {
		return a;
	}

	@Override
	protected double endOpOnDouble(Double a, Column<Double> c) {
		return a;
	}

}
