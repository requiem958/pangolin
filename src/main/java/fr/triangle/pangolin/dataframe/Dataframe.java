package fr.triangle.pangolin.dataframe;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;

import fr.triangle.pangolin.math.Comparison;
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

	public Dataframe fromLines(int lines[]) {
		List<Line> newLines = new ArrayList<>();
		for (int i : lines) {
			if (i < this.lines.size()) {
				newLines.add(this.lines.get(i));
			}
		}
		return fromLines(newLines);
	}
	
	private Dataframe fromLines(List<Line> newLines) {
		Dataframe d = new Dataframe();
		d.lines.addAll(newLines);
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
	public Dataframe where(String column, Comparable value, Comparison cmp) {
		List<Line> newLines = new ArrayList<>();
		Integer where = labelsToInt.get(column);
		
		if (where == null)
			return null;
		
		if (!columns.get(where).getType().equals(value.getClass()))
			return null;
		
		for (int i = 0; i < lines.size(); i++) {
			Object inside = lines.get(i).get(where);
			boolean ok = false;
			switch (cmp) {
			case EQUAL:
				ok = value.equals(inside);
				break;
			case NOT_EQUAL:
				ok = !value.equals(inside);
				break;
			case STRICT_SUP:
				ok = value.compareTo(inside) == 1;
				break;
			case STRICT_INF:
				ok = value.compareTo(inside) == -1;
				break;
			default:
				throw new NoSuchElementException("This comparison does not exist");
			}
			if (ok)
				newLines.add(lines.get(i));
		}
		return fromLines(newLines);
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
	

	public View view() {
		return new Dataview(this);
	}
	
}