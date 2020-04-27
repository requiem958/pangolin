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
	protected static Object[][] GoodDataLinePlus = { {"nom","age", "prenom"}, {"Robert", (Integer) 10, "george"}, {"Marc", (Integer) 11,"george"} };
	protected static Object[][] GoodDataBis = { {"nom","nbEnfants"}, {"Robert", (Integer) 10}, {"Marc", (Integer) 11} };
	protected static Object[][] GoodDataDouble = { {"nom","age"}, {"Robert", (Double) 10.1}, {"Marc", (Double) 11.1} };
	protected static Object[][] DataWithSameNameColumn = { {"nom","age","age"}, {"Robert", (Integer) 10,(Integer) 10}, {"Marc", (Integer) 11,(Integer) 10} };
	protected static Object[][] BadData = { {"nom","age"}, {"Robert", (Integer) 10}, {"Marc", "11"} };
	protected static Object[][] BadTypeDataCheckOk = { {"nom","age"}, {"Robert", (Integer) 10}, {"Marc", (Boolean) true} };
	protected static Object[][] BadTypeDataCheckNotOk = { {"nom","age"}, {"Robert", (Boolean) true}, {"Marc", (Boolean) true} };
    
	private void goodDataAttributes() {
		assertEquals(2, d.lines.size());
		assertEquals(2, d.getColumns().size());
		assertEquals(2, d.labelsToInt.keySet().size());
		assertEquals("nom",d.getColumns().get(0).label);
		assertEquals("age",d.getColumns().get(1).label);
		assertEquals(String.class,d.getColumns().get(0).getType());
		assertEquals(Integer.class,d.getColumns().get(1).getType());
	}
	
    @Test(expected = None.class)
    public void testDataframeLoadFromGoodCSV() throws FileNotFoundException {
		d = new Dataframe("./annexes/testGoodCSV.csv");
		goodDataAttributes();
    }
    @Test(expected = None.class)
    public void testDataframeLoadFromGoodDoubleCSV() throws FileNotFoundException {
		d = new Dataframe("./annexes/testGoodDoubleCSV.csv");
		assertEquals(2, d.lines.size());
		assertEquals(2, d.getColumns().size());
		assertEquals(2, d.labelsToInt.keySet().size());
		assertEquals("nom",d.getColumns().get(0).label);
		assertEquals("age",d.getColumns().get(1).label);
		assertEquals(String.class,d.getColumns().get(0).getType());
		assertEquals(Double.class,d.getColumns().get(1).getType());
    }
    
    @Test(expected = FileNotFoundException.class)
    public void testDataframeNoFile() throws FileNotFoundException{
		d = new Dataframe("./annexes/nonExistent.csv");
    }
    @Test
    public void testDataframeEmptyFile() throws FileNotFoundException{
		d = new Dataframe("./annexes/empty.csv");
		assertEquals(0, d.lines.size());
		assertEquals(0, d.getColumns().size());
		assertEquals(0, d.labelsToInt.keySet().size());
    }
    
    @Test
	public void testDataframeFromGoodData() {
		d = new Dataframe(GoodData);
		goodDataAttributes();
	}
    
    @Test
	public void testDataframeFromBadData() {
		d = new Dataframe(BadData);
		assertEquals(0, d.lines.size());
		assertEquals(0, d.getColumns().size());
		assertEquals(0, d.labelsToInt.keySet().size());
	}
    
    @Test
	public void testDataframeFromBadTypeDataCheckOk() {
		d = new Dataframe(BadTypeDataCheckOk);
		assertEquals(0, d.lines.size());
		assertEquals(0, d.getColumns().size());
		assertEquals(0, d.labelsToInt.keySet().size());
	}
    
    @Test
	public void testDataframeFromBadTypeDataCheckNotOk() {
		d = new Dataframe(BadTypeDataCheckNotOk);
		assertEquals(0, d.lines.size());
		assertEquals(0, d.getColumns().size());
		assertEquals(0, d.labelsToInt.keySet().size());
	}
	
    @Test
	public void testDataframeFromGoodDataDouble() {
		d = new Dataframe(GoodDataDouble);
		assertEquals(2, d.lines.size());
		assertEquals(2, d.getColumns().size());
		assertEquals(2, d.labelsToInt.keySet().size());
		assertEquals("nom",d.getColumns().get(0).label);
		assertEquals("age",d.getColumns().get(1).label);
		assertEquals(String.class,d.getColumns().get(0).getType());
		assertEquals(Double.class,d.getColumns().get(1).getType());
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
		assertEquals(2, d2.getColumns().size());
		assertEquals(2, d2.labelsToInt.keySet().size());
		assertEquals("nom",d2.getColumns().get(0).label);
		assertEquals("age",d2.getColumns().get(1).label);
		assertEquals(String.class,d2.getColumns().get(0).getType());
		assertEquals(Integer.class,d2.getColumns().get(1).getType());
		
	}
    @Test
	public void testFromLinesBad() {
		d = new Dataframe(GoodData);
		int[] lines = {0,1,20};
		Dataframe d2 = d.fromLines(lines);
		assertNotNull(d2);
		assertNotEquals(3, d2.lines.size());
		assertEquals(2, d2.getColumns().size());
		assertEquals(2, d2.labelsToInt.keySet().size());
		assertEquals("nom",d2.getColumns().get(0).label);
		assertEquals("age",d2.getColumns().get(1).label);
		assertEquals(String.class,d2.getColumns().get(0).getType());
		assertEquals(Integer.class,d2.getColumns().get(1).getType());
		
	}
    @Test
	public void testFromColumns() {
    	d = new Dataframe(GoodData);
		String[] columns = {"nom"};
		Dataframe d2 = d.fromColumns(columns);
		assertNotNull(d2);
		assertEquals(2, d2.lines.size());
		assertEquals(1, d2.getColumns().size());
		assertEquals(1, d2.labelsToInt.keySet().size());
		assertEquals("nom",d2.getColumns().get(0).label);
		assertEquals(String.class,d2.getColumns().get(0).getType());
	}
    @Test
	public void testDataFrameEquals() {
    	d = new Dataframe(GoodData);
    	Dataframe d2 = new Dataframe(GoodData);
    	Dataframe d3 = new Dataframe(GoodDataDouble);
    	GoodData[0][0] = "NOM";
    	Dataframe d4 = new Dataframe(GoodData);
    	assertEquals(d, d);
    	assertNotEquals(d, null);
    	assertNotEquals(d, d3);
    	assertNotEquals(d, d4);
    	assertEquals(d, d2);
    	GoodData[0][0] = "nom";
	}
    @Test
	public void testLine() {
    	d = new Dataframe(GoodData);
    	Dataframe d2 = new Dataframe(GoodData);
    	Dataframe d3 = new Dataframe(GoodDataDouble);
    	Dataframe d4 = new Dataframe(GoodDataLinePlus);
    	assertEquals(d.lines.get(0), d.lines.get(0));
    	assertNotEquals(d.lines.get(0), null);
    	assertNotEquals(d.lines.get(0), d3.lines.get(0));
    	assertNotEquals(d.lines.get(0), d4.lines.get(0));
    	assertEquals(d.lines.get(0), d2.lines.get(0));
	}
    
}
