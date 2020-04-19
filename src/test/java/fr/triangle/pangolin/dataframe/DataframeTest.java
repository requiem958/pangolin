package fr.triangle.pangolin.dataframe;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;

public class DataframeTest{

	protected Dataframe d;
	protected Object[][] GoodData = { {"nom","age"}, {"Robert", (Integer) 10}, {"Marc", (Integer) 11} };
	protected Object[][] BadData = { {"nom","age"}, {"Robert", (Integer) 10}, {"Marc", "11"} };
    
    @Test
    public void testDataframeLoadFromGoodCSV() {
		d = new Dataframe("./annexes/testGoodCSV.csv");
		assertNotNull(d);
		assertEquals(2, d.lines.size());
		assertEquals(2, d.columns.size());
		assertEquals(2, d.labelsToInt.keySet().size());
		assertEquals("nom",d.columns.get(0).label);
		assertEquals("age",d.columns.get(1).label);
    }
    
    @Test
	public void testDataframeFromGoodData() {
		d = new Dataframe(GoodData);
		assertEquals(2, d.lines.size());
		assertEquals(2, d.columns.size());
		assertEquals(2, d.labelsToInt.keySet().size());
		assertEquals("nom",d.columns.get(0).label);
		assertEquals("age",d.columns.get(1).label);
		assertEquals("string",d.columns.get(0).type);
		assertEquals("int",d.columns.get(1).type);
	}

    @Test
	public void testView() {
		fail("Not yet implemented");
	}

    @Test
	public void testFromLines() {
		fail("Not yet implemented");
	}
    @Test
	public void testFromColumns() {
		fail("Not yet implemented");
	}

}
