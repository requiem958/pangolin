package fr.triangle.pangolin.dataframe;

import java.io.PrintStream;

public class Dataview implements View{

	Dataframe d;
	public Dataview(Dataframe dataframe) {
		d = dataframe;
	}

	@Override
	public void printAll(PrintStream ps) {
		for(int j = 0; j<d.getColumns().size(); j++) {
			ps.print(d.getColumns().get(j).label + "\t|\t");
		}
		ps.println("\n-------------------------");
		for(int i = 0; i<d.lines.size(); i++) {
			for(int k = 0; k<d.lines.get(0).length; k++) {
				ps.print(d.lines.get(i).get(k) + "\t|\t");
			}
			ps.println();
		}
		
	}

	@Override
	public void printFirst(PrintStream ps) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printFirst(PrintStream ps, int n) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printLast(PrintStream ps) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printLast(PrintStream ps, int n) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Dataframe getData() {
		return d;
	}

}
