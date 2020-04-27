package fr.triangle.pangolin.dataframe;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import org.junit.Test;

public class DataViewTest{

	protected Dataframe d;
	protected Dataview dv;
	protected static Object[][] GoodData = { {"nom","age"}, {"Robert", (Integer) 10}, {"Marc", (Integer) 11} }; 

	
    @Test
	public void testPrintAll() throws FileNotFoundException {
    	d = new Dataframe(GoodData);
		dv = new Dataview(d);
		PrintStream ps = new PrintStream(new File("./annexes/tampon.txt"));
		dv.printAll(ps);
		d = new Dataframe("./annexes/tampon.txt");
		assertEquals(2, d.lines.size());
		assertEquals(2, d.getColumns().size());
		assertEquals(2, d.labelsToInt.keySet().size());
		assertEquals("nom",d.getColumns().get(0).label);
		assertEquals("age",d.getColumns().get(1).label);
		assertEquals(String.class,d.getColumns().get(0).getType());
		assertEquals(Integer.class,d.getColumns().get(1).getType());
	}
    @Test
	public void testPrintFirst() throws FileNotFoundException {
    	
    	d = new Dataframe("./annexes/testGoodCSVLong.csv");
		dv = new Dataview(d);
		PrintStream ps = new PrintStream(new File("./annexes/tampon.txt"));
		dv.printFirst(ps);
		d = new Dataframe("./annexes/tampon.txt");
		
		assertEquals(10, d.lines.size());
		assertEquals(2, d.getColumns().size());
		assertEquals(2, d.labelsToInt.keySet().size());
		assertEquals("nom",d.getColumns().get(0).label);
		assertEquals("age",d.getColumns().get(1).label);
		assertEquals(String.class,d.getColumns().get(0).getType());
		assertEquals(Integer.class,d.getColumns().get(1).getType());
	
	}
    @Test
	public void testPrintFirstn() throws FileNotFoundException {
    	d = new Dataframe("./annexes/testGoodCSVLong.csv");
    	dv = new Dataview(d);
		PrintStream ps = new PrintStream(new File("./annexes/tampon.txt"));
		dv.printFirst(ps, 12);
		d = new Dataframe("./annexes/tampon.txt");
		
		assertEquals(12, d.lines.size());
		assertEquals(2, d.getColumns().size());
		assertEquals(2, d.labelsToInt.keySet().size());
		assertEquals("nom",d.getColumns().get(0).label);
		assertEquals("age",d.getColumns().get(1).label);
		assertEquals(String.class,d.getColumns().get(0).getType());
		assertEquals(Integer.class,d.getColumns().get(1).getType());
	
	}
    @Test
	public void testPrintLast() throws FileNotFoundException {
    	d = new Dataframe("./annexes/testGoodCSVLong.csv");
    	dv = new Dataview(d);
		PrintStream ps = new PrintStream(new File("./annexes/tampon.txt"));
		dv.printLast(ps);
		d = new Dataframe("./annexes/tampon.txt");
		
		assertEquals(10, d.lines.size());
		assertEquals(2, d.getColumns().size());
		assertEquals(2, d.labelsToInt.keySet().size());
		assertEquals("nom",d.getColumns().get(0).label);
		assertEquals("age",d.getColumns().get(1).label);
		assertEquals(String.class,d.getColumns().get(0).getType());
		assertEquals(Integer.class,d.getColumns().get(1).getType());
	
	}
    @Test
	public void testPrintLastn() throws FileNotFoundException {
    	d = new Dataframe("./annexes/testGoodCSVLong.csv");
    	dv = new Dataview(d);
		PrintStream ps = new PrintStream(new File("./annexes/tampon.txt"));
		dv.printLast(ps,12);
		d = new Dataframe("./annexes/tampon.txt");
		
		assertEquals(12, d.lines.size());
		assertEquals(2, d.getColumns().size());
		assertEquals(2, d.labelsToInt.keySet().size());
		assertEquals("nom",d.getColumns().get(0).label);
		assertEquals("age",d.getColumns().get(1).label);
		assertEquals(String.class,d.getColumns().get(0).getType());
		assertEquals(Integer.class,d.getColumns().get(1).getType());
	
	}
	    
}
