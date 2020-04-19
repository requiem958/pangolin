package fr.triangle.pangolin.dataframe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SuppressWarnings("rawtypes")
public class Dataframe{

	protected HashMap<String, Integer> labelsToInt;

	protected List<Column> columns;
	protected List<Object[]> lines;

	//Constructeur privé sans argument pour emptyDataframe
	private Dataframe() {
		labelsToInt = new HashMap<>();
		columns = new ArrayList<>();
		lines = new ArrayList<>();
	}

	public Dataframe(Object data[][]) {
		this();
		createColumns(data);
		fillData(data);
	}

	public Dataframe(String csvFile) {
		this(ParseCsv.parse(csvFile));
	}

	public View view() {
		return new Dataview(this);
	}

	public Dataframe fromLines(int lines[]) {
		Dataframe d = new Dataframe();
		for (int i : lines) {
			if (i < this.lines.size()) {
				d.addLine(this.lines.get(i));
			}
		}
		d.columns = new ArrayList<>(columns);
		return d;
	}

	public Dataframe fromColumns(String labels[]) {
		Dataframe d = new Dataframe();
		List<String> list_labels = List.of(labels);
		for (Column c : columns) {
			if (list_labels.contains(c.label)) {
				d.addColumn(c);
			}
		}

		d.lines = new ArrayList<>(this.lines);
		return d;
	}

	//Utilisable par le parseur CSV pour initialiser le dataframe

	//Créer un dataframe vide
	protected static Dataframe emptyDataframe() {
		return new Dataframe();
	}

	//Ajouter des colonnes au dataframe
	protected boolean addColumn(Column c) {
		if (columns.contains(c)) {
			return false;
		}
		columns.add(c);
		return true;
	}

	//Ajouter des lignes au dataframe
	protected boolean addLine(Object[] line) {
		lines.add(line);
		return true;
	}


	private void createColumns(Object[][] data) {
		Column c;
		List<String> labels = new ArrayList<>();
		Object[] line;
		for (int i = 0; i < data[0].length; i++) {
			labels.add((String)data[0][i]);
			labelsToInt.put(labels.get(i), i);
		}

		line = data[1];
		for (int i = 0; i < line.length; i++) {
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
			addColumn(c);
		}
	}

	@SuppressWarnings("unchecked")
	private void fillData(Object[][] data) {
		for (int i = 0; i < data.length; i++) {
			addLine(data[i]);
			for (int j = 0; j < data[i].length; j++) {
				if (data[i][j] instanceof Double) {
					columns.get(i).add((Double)data[i][j]);
				}else if (data[i][j] instanceof Integer) {
					columns.get(i).add((Integer)data[i][j]);
				}else if (data[i][j] instanceof String) {
					columns.get(i).add((String)data[i][j]);
				}
				else {
					System.err.println("Not a int / double / string value : (line="+i+",col="+j+") : "+data[i][j]);
					return;
				}

			}
		}
	}
}
