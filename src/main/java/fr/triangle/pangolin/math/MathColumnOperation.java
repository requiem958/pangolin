package fr.triangle.pangolin.math;

import fr.triangle.pangolin.dataframe.Column;

public abstract class MathColumnOperation {

	public Number op(Column<? extends Number> c) throws ArithmeticException, ClassCastException{
		Number var;
		if (c.getType().equals(Integer.class))
			var = 0;
		else
			var = 0.0;
		for (Number n : c.getListe()) {
			var = doOp(var,n);
		}
		var = doEndOp(var,c);
		return var;
	}
	
	protected abstract Integer opOnInteger(Integer a, Integer b) throws ArithmeticException;
	protected abstract Double opOnDouble(Double a, Double b) throws ArithmeticException;
	
	protected abstract int endOpOnInteger(Integer a, Column<Integer> c) throws ArithmeticException;
	protected abstract double endOpOnDouble(Double a, Column<Double> c) throws ArithmeticException;

	@SuppressWarnings("unchecked")
	protected Number doEndOp(Number var, Column<? extends Number> c) throws ArithmeticException {
		if (c.getType().equals(Integer.class))
			return endOpOnInteger(var.intValue(),(Column<Integer>)c);
		else //if (c.getType().equals(Double.class))
			return endOpOnDouble(var.doubleValue(),(Column<Double>)c);
		//on a une string
		//return null;
	}

	
	protected Number doOp(Number a, Number b) throws ArithmeticException {
		if (a instanceof Integer)
			return opOnInteger(a.intValue(),b.intValue());
		else //if (a instanceof Double)
			return opOnDouble(a.doubleValue(), b.doubleValue());
		//on a une string
		//return null;
	}
}
