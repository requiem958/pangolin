package fr.triangle.pangolin.dataframe;

import java.io.PrintStream;

public class Dataview implements View{

	Dataframe d;
	public Dataview(Dataframe dataframe) {
		d = dataframe;
	}

	@Override
	public void printAll(PrintStream ps) {
		// TODO Auto-generated method stub
		
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
