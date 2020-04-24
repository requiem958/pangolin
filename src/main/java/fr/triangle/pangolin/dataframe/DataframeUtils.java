package fr.triangle.pangolin.dataframe;

import java.util.ArrayList;
import java.util.List;

public final class DataframeUtils {
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
