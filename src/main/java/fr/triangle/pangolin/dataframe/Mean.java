package fr.triangle.pangolin.dataframe;

public class Mean extends Sum {

	@Override
	protected String name() {
		return "MOYENNE";
	}

	@Override
	protected int endOpOnInteger(Integer a, Column<Integer> c) {
		return a/c.liste.size();
	}

	@Override
	protected double endOpOnDouble(Double a, Column<Double> c) {
		return a/c.liste.size();
	}

}

