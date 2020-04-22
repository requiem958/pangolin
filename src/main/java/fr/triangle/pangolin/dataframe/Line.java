package fr.triangle.pangolin.dataframe;

public class Line{
	protected Object[] line;
	public int length;
	
	public Line(Object[] line2) {
		line = new Object[line2.length];
		length = line2.length;
		int i = 0;
		for(Object o : line2) {
			line[i] = o;
			i++;
		}
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		
		if (!(o instanceof Line))
			return false;
		
		Line that = (Line) o;
		
		if (that.line.length != line.length)
			return false;
		
		for (int i = 0; i < line.length; i++) {
			if (!line[i].equals(that.line[i]))
				return false;
		}
		return true;
	}
	
	@Override
	public int hashCode() {
		int hashcode = 0xff;
		for (Object o : line) {
			hashcode ^= o.hashCode();
		}
		return hashcode;
	}
	
	public Object get(int index) {
		return line[index];
	}

}
