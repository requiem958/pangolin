package fr.triangle.pangolin;

import static org.junit.Assert.assertArrayEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

import fr.triangle.pangolin.dataframe.Dataframe;
import fr.triangle.pangolin.dataframe.Dataview;
import fr.triangle.pangolin.math.Comparison;
import fr.triangle.pangolin.math.Max;
import fr.triangle.pangolin.math.Mean;
import fr.triangle.pangolin.math.Min;
import fr.triangle.pangolin.math.Sum;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
    	Dataframe dbase;
    	Dataframe dprime;
    	Dataview dv;
    	PrintStream ps;
    	
    	File fileColum, fileMath, fileWhere;
    	fileColum = new File("./annexes/fileColum.txt");
    	if(!fileColum.exists()) {
    		fileColum.createNewFile();
    	}
    	fileMath = new File("./annexes/fileMath.txt");
    	if(!fileMath.exists()) {
    		fileMath.createNewFile();
    	}
    	fileWhere = new File("./annexes/fileWhere.txt");
    	if(!fileWhere.exists()) {
    		fileWhere.createNewFile();
    	}
    	
    	
    	
    	
    	ps = new PrintStream(fileColum); 	
    	dbase = new Dataframe("./annexes/appCSV.csv");
    	
    	String[] columns = {"nom","age"};
    	dprime = dbase.fromColumns(columns);
    	dv = new Dataview(dprime);
    	dv.printBeatifull(System.out);
    	dv.printAll(ps);
    	
    	ps = new PrintStream(fileMath);
    	String[] labels = {"taille"};
    	Number[] value = {0};
    	ps.println("Differentes valeurs de Taille :");
    	value = dbase.operation(new Min(), labels);
    	ps.println("Minimum : " + value[0]);
    	value = dbase.operation(new Max(), labels);
    	ps.println("Maximum : " + value[0]);
    	value = dbase.operation(new Mean(), labels);
    	ps.println("Moyenne : " + value[0]);
    	value = dbase.operation(new Sum(), labels);
    	ps.println("Somme : " + value[0]);
    	ps.close(); 
    	
    	ps = new PrintStream(fileWhere);
    	ps.println("Differentes valeurs de Taille :");
    	ps.println();
    	dprime = dbase.where("taille", 130.0, Comparison.STRICT_INF);
    	ps.println("Taille inferieure a 130 : ");
    	ps.println();
    	dv = new Dataview(dprime);
    	dv.printAll(ps);
    	ps.println();

    	dprime = dbase.where("taille", 130.0, Comparison.STRICT_SUP);
    	ps.println("Taille superieur a 130 : ");
    	ps.println();
    	dv = new Dataview(dprime);
    	dv.printAll(ps);
    	ps.println();
    	
    	dprime = dbase.where("taille", 130.0, Comparison.EQUAL);
    	ps.println("Taille inferieure a 130 : ");
    	ps.println();
    	dv = new Dataview(dprime);
    	dv.printAll(ps);
    	ps.println();
    	
    	ps.close();
    	
    }
}
