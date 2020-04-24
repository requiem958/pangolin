package fr.triangle.pangolin.dataframe;

import static org.junit.Assert.*;

import org.junit.Test;

public class LineTest {

	Object[] o1 = {(Integer) 10, (Double) 10.0, (String) "coucou"};
	Object[] o2 = {(Integer) 10, (Double) 10.0, (String) "nop"};
	Object[] o3 = {(Integer) 10, (Double) 10.0};
	
	@Test
	public void testEquality() {
		Line l1 = new Line(o1);
		Line l1bis = new Line(o1);
		Line l2 = new Line(o2);
		Line l3 = new Line(o3);
		
		assertEquals(l1, l1);
		assertEquals(l1, l1bis);
		assertNotEquals(l1, l2);
		assertNotEquals(l1, l3);
		assertNotEquals(l1, o1);
	}
	
	@Test
	public void testHash() {
		Line l1 = new Line(o1);
		Line l1bis = new Line(o1);
		Line l2 = new Line(o2);
		assertEquals(l1.hashCode(), l1bis.hashCode());
		assertNotEquals(l1.hashCode(), l2.hashCode());
	}
	
	@Test
	public void testGet() {
		Line l1 = new Line(o1);
		for (int i = 0; i < o1.length; i++) {
			assertEquals(l1.get(i), o1[i]);
		}
	}

}
