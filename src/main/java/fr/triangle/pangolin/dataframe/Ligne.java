package fr.triangle.pangolin.dataframe;

import java.util.ArrayList;
import java.util.List;

public class Ligne<E> {
	List<E> liste;
	protected Ligne(String label) {
		liste = new ArrayList<>();
	}
	protected void add(E atribut) {
		liste.add(atribut);
	}
	
}
