package fr.triangle.pangolin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import fr.triangle.pangolin.dataframe.Dataframe;
import fr.triangle.pangolin.dataframe.Dataview;

public class App 
{
    public static void main( String[] args ) throws FileNotFoundException
    {
    	Dataframe dbase;
    	Dataframe dprime;
    	Dataview dv;
    	PrintStream ps;
    	
    	File fileColum, fileMeans, fileMDix;
    	fileColum = new File("./annexes/fileColum.txt");
    	ps = new PrintStream(fileColum);
    	
    	dbase = new Dataframe("./annexes/appCSV.csv");
    	String[] columns = {"nom","age"};
    	dprime = dbase.fromColumns(columns);
    	dv = new Dataview(dbase);
    	dv.printBeatifull(System.out);
    	dv.printAll(ps);
    	ps.close();
    	
    	
    	
    }
}
