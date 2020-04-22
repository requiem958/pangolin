package fr.triangle.pangolin;

import java.io.FileNotFoundException;

import fr.triangle.pangolin.dataframe.Dataframe;
import fr.triangle.pangolin.dataframe.Dataview;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	try {
        Dataframe d = new Dataframe("./annexes/testGoodCSV.csv");
        Dataview dv = new Dataview(d);
        dv.printAll(System.out);
    	} catch(FileNotFoundException e) {
    		
    	}
    }
}
