package fr.triangle.pangolin.dataframe;

import java.util.ArrayList;
import java.util.List;

public class Column<E> {
	String label;
	List<E> liste;
	protected Column(String label) {
		this.label = label;
		liste = new ArrayList<>();
	}
	protected void add(E atribut) {
		liste.add(atribut); 
		
	}
	
}
