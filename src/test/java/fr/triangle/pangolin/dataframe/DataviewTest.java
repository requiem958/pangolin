package fr.triangle.pangolin.dataframe;

import static org.junit.Assert.*;

import org.junit.Test;

public class DataviewTest{

	Dataframe d;
	View v;
	public void setUp() {
		d = new Dataframe(DataframeTest.GoodData);
	}
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
