package fr.triangle.pangolin.dataframe;

public class Dataframe{

	public Dataframe(Object data[][]) {
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
}
