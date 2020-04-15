package fr.triangle.pangolin.dataframe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SuppressWarnings("rawtypes")
public class Dataframe{
	
	private final int tailleInitiale = 10; 
	private HashMap<String, Integer> labelsToInt;
	
	private List<Column> columns;
	private List<Object[]> lines;
	
	//Constructeur privé sans argument pour emptyDataframe
	private Dataframe() {
		labelsToInt = new HashMap<>(tailleInitiale);
		columns = new ArrayList<>(tailleInitiale);
		lines = new ArrayList<>(tailleInitiale);
	}
	
	public Dataframe(Object data[][]) {
		this();
		createColumns(data);
		fillData(data);
	}

	public Dataframe(String csvFile) {

	}
	
	public View view() {
		return new Dataview(this);
	}
	
	public Dataframe fromLines(int lines[]) {
		return null;
	}
	
	public Dataframe fromColumns(String labels[]) {
		return null;
	}
	
	//Utilisable par le parseur CSV pour initialiser le dataframe
	
	//Créer un dataframe vide
	protected static Dataframe emptyDataframe() {
		return new Dataframe();
	}
	
	//Ajouter des colonnes au dataframe
	protected boolean addColumn(Column c) {
		return false;
	}
	
	//Ajouter des lignes au dataframe
	protected boolean addLine(Object[] line) {
		return false;
	}
	
	private void createColumns(Object[][] data) {
		
		Column c;
		List<String> labels = new ArrayList<>(tailleInitiale);
		Object[] line;
		for (int i = 0; i < data.length; i++) {
			labels.add((String)data[0][i]);
			labelsToInt.put(labels.get(i), i);
		}
		
		line = data[1];
		for (int i = 0; i < data.length; i++) {
			if (line[i] instanceof Double) {
				c = new Column<Double>(labels.get(i));
			}else if (line[i] instanceof Integer) {
				c = new Column<Integer>(labels.get(i));
			}else if (line[i] instanceof String) {
				c = new Column<String>(labels.get(i));
			}
			else {
				System.err.println("Not a int / double / string value : (1,"+i+" : "+line[i]);
				return;
			}
			columns.add(c);
		}
	}
	
	@SuppressWarnings("unchecked")
	private void fillData(Object[][] data) {
		for (int i = 0; i < data.length; i++) {
			lines.add(data[i]);
			for (int j = 0; j < data[i].length; j++) {
				columns.get(i).add(data[i][j]);
			}
		}
	}
}
