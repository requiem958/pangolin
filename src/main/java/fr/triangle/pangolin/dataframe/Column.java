package fr.triangle.pangolin.dataframe;

import java.util.ArrayList;
import java.util.List;

public class Column<E> {
	String label;
	List<E> liste;
	Class<?> type;
	
	private Column(String label, Class<?>  type) {
		this.label = label;
		this.type = type;
		liste = new ArrayList<>();
	}
	protected void add(E attribut) throws ClassCastException{
		if (attribut.getClass().equals(type)) {
			liste.add(attribut);
		}else {
			throw new ClassCastException();
		}
	}
	
	public static Column<Integer> integerColumn(String label){
		return new Column<Integer>(label, Integer.class);
	}
	
	public static Column<Double> doubleColumn(String label){
		return new Column<Double>(label, Double.class);
	}
	
	public static Column<String> stringColumn(String label){
		return new Column<String>(label, String.class);
	}
}
