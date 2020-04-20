package fr.triangle.pangolin.dataframe;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;

public class DataviewTest{

	Dataframe d = new Dataframe(DataframeTest.GoodData);
	View v;
	
	@Test
	public void testDataview() {
		v = new Dataview(d);
		assertNotNull(v);
		
		assertEquals(d, v.getData());
	}

	public void testPrintAll() {
		fail("Not yet implemented");
	}

	public void testPrintFirstPrintStream() {
		fail("Not yet implemented");
	}

	public void testPrintFirstPrintStreamInt() {
		fail("Not yet implemented");
	}

	public void testPrintLastPrintStream() {
		fail("Not yet implemented");
	}

	public void testPrintLastPrintStreamInt() {
		fail("Not yet implemented");
	}

}
