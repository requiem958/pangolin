package fr.triangle.pangolin.dataframe;

import java.io.PrintStream;

public interface View {
	public void printAll(PrintStream ps);
	public void printFirst(PrintStream ps);
	public void printFirst(PrintStream ps, int n);
	public void printLast(PrintStream ps);
	public void printLast(PrintStream ps, int n);
}