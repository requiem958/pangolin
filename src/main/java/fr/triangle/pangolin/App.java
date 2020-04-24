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
        Dataframe d = new Dataframe("./annexes/testGoodCSVLong.csv");
        Dataview dv = new Dataview(d);
        dv.printAll(System.out);
        System.out.println();
        dv.printBeatifull(System.out);
        System.out.println();
        dv.printFirst(System.out);
        System.out.println();
        dv.printFirst(System.out, 12);
        System.out.println();
        dv.printLast(System.out);
        System.out.println();
        dv.printLast(System.out, 13);
        System.out.println();
        dv.printFirst(System.out, 30);
        System.out.println();
        dv.printLast(System.out);
        System.out.println();
        dv.printLast(System.out, 30);
        System.out.println();
    	} catch(FileNotFoundException e) {
    		
    	}
    }
}
