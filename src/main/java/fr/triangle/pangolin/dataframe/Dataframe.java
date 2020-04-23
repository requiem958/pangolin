package fr.triangle.pangolin.dataframe;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import fr.triangle.pangolin.math.MathColumnOperation;

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
			if (DataframeUtils.createColumns(this,data))
				DataframeUtils.fillData(this,data);	
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
				d.lines.add(this.lines.get(i));
			}
		}
		d.getColumns().addAll(getColumns());
		d.labelsToInt.putAll(labelsToInt);
		return d;
	}

	public Dataframe fromColumns(String labels[]) {
		Dataframe d = new Dataframe();
		List<String> list_labels = List.of(labels);
		int i = 0;
		for (Column c : getColumns()) {
			if (list_labels.contains(c.label)) {
				d.getColumns().add(c);
				d.labelsToInt.put(c.label, i++);
			}
		}
		d.lines.addAll(this.lines);
		
		return d;
	}
	
	@SuppressWarnings("unchecked")
	public Number[] operation(MathColumnOperation op, String[] labels) {
		List<Column<? extends Number>> todo = new ArrayList<>();
		List<String> list_labels = List.of(labels);
		for (Column c : getColumns()) {
			if (list_labels.contains(c.label) && !c.getType().equals(String.class)) {
				todo.add((Column<? extends Number>)c);
			}
		}
		
		Number[] result = new Number[todo.size()];
		
		for (int i = 0; i < todo.size(); i++) {
			result[i] = op.op(todo.get(i));
		}
		return result;
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
		
		if (!new HashSet<Column>(getColumns()).equals(new HashSet<Column>(that.getColumns())))
			return false;
		
		return true;
    }

	public List<Column> getColumns() {
		return columns;
	}
	
}

class DataframeUtils{
	static private void clear(Dataframe d) {
		d.labelsToInt.clear();
		d.getColumns().clear();
		d.lines.clear();
	}
	
	@SuppressWarnings("unchecked")
	static boolean fillData(Dataframe d, Object[][] data) {
		try {
		for (int i = 1; i < data.length; i++) {
			d.lines.add(new Line(data[i]));
			for (int j = 0; j < data[i].length; j++) {
				if (data[i][j] instanceof Double) {
					d.getColumns().get(j).add((Double)data[i][j]);
				}else if (data[i][j] instanceof Integer) {
					d.getColumns().get(j).add((Integer)data[i][j]);
				}else if (data[i][j] instanceof String) {
					d.getColumns().get(j).add((String)data[i][j]);
				}
				else {
					System.err.println("Not a int / double / string value : (line="+i+",col="+j+") : "+data[i][j]);
					clear(d);
					return false;
				}
			}
		}
		} catch(ClassCastException e) {
			clear(d);
		}
		return true;
	}
	
	@SuppressWarnings({"rawtypes"})
	static boolean createColumns(Dataframe d, Object[][] data) {
		Column c;
		List<String> labels = new ArrayList<>();
		Object[] line;
		for (int i = 0; i < data[0].length; i++) {
			labels.add((String)data[0][i]);
			d.labelsToInt.put(labels.get(i), i);
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
				clear(d);
				return false;
			}
			d.getColumns().add(c);
		}
		return true;
	}
}