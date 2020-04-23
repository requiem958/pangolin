package fr.triangle.pangolin.dataframe;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@SuppressWarnings("rawtypes")
public class Dataframe{

	protected HashMap<String, Integer> labelsToInt;

	protected List<Column> columns;
	protected List<Line> lines;

	//Constructeur privé sans argument pour emptyDataframe
	private Dataframe() {
		labelsToInt = new HashMap<>();
		columns = new ArrayList<>();
		lines = new ArrayList<>();
	}

	public Dataframe(Object data[][]) {
		this();
		if(data != null) {
			if (createColumns(data))
				fillData(data);	
		}
	}

	public Dataframe(String csvFile) throws FileNotFoundException{
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
		d.columns.addAll(columns);
		d.labelsToInt.putAll(labelsToInt);
		return d;
	}

	public Dataframe fromColumns(String labels[]) {
		Dataframe d = new Dataframe();
		List<String> list_labels = List.of(labels);
		int i = 0;
		for (Column c : columns) {
			if (list_labels.contains(c.label)) {
				d.addColumn(c);
				d.labelsToInt.put(c.label, i++);
			}
		}
		d.lines.addAll(this.lines);
		
		return d;
	}
	
	@Override
    public boolean equals(Object obj) 
    { 
		if (this == obj)
			return true;
		if (!(obj instanceof Dataframe))
			return false;
		
		//On sait que obj est un autre dataframe
		//On checke les données
		Dataframe that = (Dataframe) obj;
		
		
		if (!lines.equals(that.lines))
			return false;
		
		if (!new HashSet<Column>(columns).equals(new HashSet<Column>(that.columns)))
			return false;
		
		return true;
    }

	//Ajouter des colonnes au dataframe
	protected boolean addColumn(Column c) {
		columns.add(c);
		return true;
	}

	//Ajouter des lignes au dataframe
	protected boolean addLine(Object[] line) {
		lines.add(new Line(line));
		return true;
	}
	
	protected boolean addLine(Line line) {
		lines.add(line);
		return true;
	}


	private boolean createColumns(Object[][] data) {
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
				c = Column.doubleColumn(labels.get(i));
			}else if (line[i] instanceof Integer) {
				c = Column.integerColumn(labels.get(i));
			}else if (line[i] instanceof String) {
				c = Column.stringColumn(labels.get(i));
			}
			else {
				System.err.println("Not a int / double / string value : (1,"+i+" : "+line[i]);
				clear();
				return false;
			}
			addColumn(c);
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	private boolean fillData(Object[][] data) {
		try {
		for (int i = 1; i < data.length; i++) {
			addLine(data[i]);
			for (int j = 0; j < data[i].length; j++) {
				if (data[i][j] instanceof Double) {
					columns.get(j).add((Double)data[i][j]);
				}else if (data[i][j] instanceof Integer) {
					columns.get(j).add((Integer)data[i][j]);
				}else if (data[i][j] instanceof String) {
					columns.get(j).add((String)data[i][j]);
				}
				else {
					System.err.println("Not a int / double / string value : (line="+i+",col="+j+") : "+data[i][j]);
					clear();
					return false;
				}

			}
		}
		} catch(ClassCastException e) {
			clear();
		}
		return true;
	}
	
	private void clear() {
		labelsToInt.clear();
		columns.clear();
		lines.clear();
	}
}
