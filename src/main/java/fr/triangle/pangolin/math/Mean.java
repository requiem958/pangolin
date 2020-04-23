package fr.triangle.pangolin.math;

import fr.triangle.pangolin.dataframe.Column;

public class Mean extends Sum {

	@Override
	protected String name() {
		return "MOYENNE";
	}

	@Override
	protected int endOpOnInteger(Integer a, Column<Integer> c) {
		return a/c.getListe().size();
	}

	@Override
	protected double endOpOnDouble(Double a, Column<Double> c) {
		return a/c.getListe().size();
	}

}

