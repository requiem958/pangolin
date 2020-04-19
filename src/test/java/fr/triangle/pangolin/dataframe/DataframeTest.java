package fr.triangle.pangolin.dataframe;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class DataframeTest extends TestCase {

	protected Dataframe d;
	protected Object[][] GoodData = { {"nom","age"}, {"Robert", (Integer) 10}, {"Marc", (Integer) 11} };
	protected Object[][] BadData = { {"nom","age"}, {"Robert", (Integer) 10}, {"Marc", "11"} };
	
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public DataframeTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( DataframeTest.class );
    }
	
    public void testDataframeFromCSV() {
    	fail("Not yet implemented");
    }
    
	public void testDataframeFromGoodData() {
		d = new Dataframe(GoodData);
		assertEquals(2, d.lines.size());
		assertEquals(2, d.columns.size());
		assertEquals(2, d.labelsToInt.keySet().size());
		assertEquals("nom",d.columns.get(0).label);
		assertEquals("age",d.columns.get(1).label);
	}

	public void testView() {
		fail("Not yet implemented");
	}

	public void testFromLines() {
		fail("Not yet implemented");
	}

	public void testFromColumns() {
		fail("Not yet implemented");
	}

}
