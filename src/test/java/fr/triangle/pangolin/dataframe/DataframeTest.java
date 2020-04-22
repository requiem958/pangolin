package fr.triangle.pangolin.dataframe;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.io.FileNotFoundException;

import org.junit.Test;
import org.junit.Test.None;

public class DataframeTest{

	protected Dataframe d;
	protected static Object[][] GoodData = { {"nom","age"}, {"Robert", (Integer) 10}, {"Marc", (Integer) 11} };
	protected static Object[][] GoodDataDouble = { {"nom","age"}, {"Robert", (Double) 10.1}, {"Marc", (Double) 11.1} };
	protected static Object[][] DataWithSameNameColumn = { {"nom","age","age"}, {"Robert", (Integer) 10,(Integer) 10}, {"Marc", (Integer) 11,(Integer) 10} };
	protected static Object[][] BadData = { {"nom","age"}, {"Robert", (Integer) 10}, {"Marc", "11"} };
    
	private void goodDataAttributes() {
		assertEquals(2, d.lines.size());
		assertEquals(2, d.columns.size());
		assertEquals(2, d.labelsToInt.keySet().size());
		assertEquals("nom",d.columns.get(0).label);
		assertEquals("age",d.columns.get(1).label);
		assertEquals(String.class,d.columns.get(0).type);
		assertEquals(Integer.class,d.columns.get(1).type);
	}
	
    @Test(expected = None.class)
    public void testDataframeLoadFromGoodCSV() throws FileNotFoundException {
		d = new Dataframe("./annexes/testGoodCSV.csv");
		goodDataAttributes();
    }
    
    @Test(expected = FileNotFoundException.class)
    public void testDataframeNoFile() throws FileNotFoundException{
		d = new Dataframe("./annexes/nonExistent.csv");
		goodDataAttributes();
    }
    
    @Test
	public void testDataframeFromGoodData() {
		d = new Dataframe(GoodData);
		goodDataAttributes();
	}
    /*
    @Test
	public void testDataframeFromBadData() {
		d = new Dataframe(BadData);
		goodDataAttributes();
	}
	*/
    @Test
	public void testDataframeFromGoodDataDouble() {
		d = new Dataframe(GoodDataDouble);
		assertEquals(2, d.lines.size());
		assertEquals(2, d.columns.size());
		assertEquals(2, d.labelsToInt.keySet().size());
		assertEquals("nom",d.columns.get(0).label);
		assertEquals("age",d.columns.get(1).label);
		assertEquals(String.class,d.columns.get(0).type);
		assertEquals(Double.class,d.columns.get(1).type);
	}
    /*
    @Test
	public void testNameColumsEqual() {
		d = new Dataframe(DataWithSameNameColumn);
		goodDataAttributes();
	}
*/
    @Test
	public void testView() {
		d = new Dataframe(GoodData);
		assertNotNull(d.view());
	}

    @Test
	public void testFromLines() {
		d = new Dataframe(GoodData);
		int[] lines = {0};
		Dataframe d2 = d.fromLines(lines);
		assertNotNull(d2);
		assertEquals(1, d2.lines.size());
		assertEquals(2, d2.columns.size());
		assertEquals(2, d2.labelsToInt.keySet().size());
		assertEquals("nom",d2.columns.get(0).label);
		assertEquals("age",d2.columns.get(1).label);
		assertEquals(String.class,d2.columns.get(0).type);
		assertEquals(Integer.class,d2.columns.get(1).type);
		
	}
    @Test
	public void testFromLinesBad() {
		d = new Dataframe(GoodData);
		int[] lines = {0,1,20};
		Dataframe d2 = d.fromLines(lines);
		assertNotNull(d2);
		assertNotEquals(3, d2.lines.size());
		assertEquals(2, d2.columns.size());
		assertEquals(2, d2.labelsToInt.keySet().size());
		assertEquals("nom",d2.columns.get(0).label);
		assertEquals("age",d2.columns.get(1).label);
		assertEquals(String.class,d2.columns.get(0).type);
		assertEquals(Integer.class,d2.columns.get(1).type);
		
	}
    @Test
	public void testFromColumns() {
    	d = new Dataframe(GoodData);
		String[] columns = {"nom"};
		Dataframe d2 = d.fromColumns(columns);
		assertNotNull(d2);
		assertEquals(2, d2.lines.size());
		assertEquals(1, d2.columns.size());
		assertEquals(1, d2.labelsToInt.keySet().size());
		assertEquals("nom",d2.columns.get(0).label);
		assertEquals(String.class,d2.columns.get(0).type);
	}
    @Test
	public void testDataFrameEquals() {
    	d = new Dataframe(GoodData);
    	Dataframe d2 = new Dataframe(GoodData);
    	Dataframe d3 = new Dataframe(GoodDataDouble);
    	assertEquals(d, d);
    	assertNotEquals(d, d3);
    	assertEquals(d, d2);
	}
    
}
