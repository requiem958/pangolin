package fr.triangle.pangolin.math;

public class Min extends Max {
	@Override
	protected Integer opOnInteger(Integer a, Integer b) throws ArithmeticException {
		return Integer.min(a, b);
	}

	@Override
	protected Double opOnDouble(Double a, Double b) throws ArithmeticException {
		return Double.min(a, b);
	}
}
