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
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		
		if (!(obj instanceof Column))
			return false;
		
		Column<?> that = (Column<?>) obj;
		
		if (this.type != that.type)
			return false;
		
		if (this.label != that.label)
			return false;
		
		if (this.liste.equals(that.liste))
			return true;
		
		return false;
	}
	
    @Override
    public int hashCode() {
        return label.hashCode();
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
