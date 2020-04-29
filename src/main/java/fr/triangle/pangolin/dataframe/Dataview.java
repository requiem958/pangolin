package fr.triangle.pangolin.dataframe;

import java.io.PrintStream;

public class Dataview implements View{

	Dataframe d;
	int nbLigne;
	int nbCol;
	public Dataview(Dataframe dataframe) {
		d = dataframe;
		nbLigne = d.lines.size();
		nbCol = d.getColumns().size();
	}


	public void printBeatifull(PrintStream ps) {
		for(int j = 0; j<nbCol; j++) {

			ps.print(d.getColumns().get(j).label + "\t|\t");
		}
		ps.println("\n");
		for(int i = 0; i<nbLigne; i++) {
			for(int k = 0; k<d.lines.get(0).length; k++) {
				ps.print(d.lines.get(i).get(k) + "\t|\t");
			}
			ps.println();
		}
	}

	@Override
	public void printAll(PrintStream ps) {
		printPrecise(ps, 1, nbLigne);
	}

	//pour les 3 premieres s = 1 et e = 3
	private void printPrecise(PrintStream ps, int s, int e) {

		int max = Math.min(e, nbLigne);

		for(int j = 0; j<nbCol-1; j++) {
			ps.print(d.getColumns().get(j).label + ";");
		}
		ps.println(d.getColumns().get(nbCol-1).label); //le dernier label
		for(int i = s-1; i<max; i++) {
			for(int k = 0; k<d.lines.get(0).length-1; k++) {
				ps.print(d.lines.get(i).get(k) + ";");
			}
			ps.println(d.lines.get(i).get(d.lines.get(0).length-1)); //le denier argument de la ligne
		}
		ps.println();

	}
	@Override
	public void printFirst(PrintStream ps) {
		printPrecise(ps, 1, 10);

	}

	@Override
	public void printFirst(PrintStream ps, int n) {
		printPrecise(ps, 1, n);

	}

	@Override
	public void printLast(PrintStream ps) {
		printPrecise(ps, Math.max(1, nbLigne-9), nbLigne);
	}

	@Override
	public void printLast(PrintStream ps, int n) {
		printPrecise(ps, Math.max(1, nbLigne-n+1), nbLigne);

	}

	@Override
	public Dataframe getData() {
		return d;
	}

}
