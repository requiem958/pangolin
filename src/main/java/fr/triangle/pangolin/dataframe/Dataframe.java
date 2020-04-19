package fr.triangle.pangolin.dataframe;

public class Dataframe{

	//Constructeur privé sans argument pour emptyDataframe
	private Dataframe() {
		
	}
	
	public Dataframe(Object data[][]) {
	}
	
	public Dataframe(String csvFile) {
		ParseCsv.parce(csvFile, this);
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
}
