package fr.triangle.pangolin.dataframe;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class ColumnTest {

	@Test
	public void testColumn() {
		Column<Integer> c = Column.integerColumn("col");
		assertEquals("col",c.label);
		assertEquals(Integer.class,c.type);
	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	@Test(expected = ClassCastException.class)
	public void testBadAdd() {
		Column<Integer> c = Column.integerColumn("col");
		((Column)c).add("coucou");
	}
	
	@Test
	public void testGoodAdd() {
		Column<Integer> c = Column.integerColumn("col");
		c.add(10);
		assertEquals(1, c.liste.size());
	}
	
	@Test
	public void testGoodAddString() {
		Column<String> c = Column.stringColumn("col");
		c.add("test");
		assertEquals(1, c.liste.size());
	}
	
	@Test
	public void testEqual() {
		Column<Integer> c = Column.integerColumn("col");
		Column<Integer> c2 = Column.integerColumn("col");
		c.add(10);
		c2.add(10);
		
		assertEquals(c, c2);
	}
	
	@Test
	public void testNotEqualType() {
		Column<Integer> c = Column.integerColumn("colNotEqT");
		Column<Double> c2 = Column.doubleColumn("colNotEqT");
		
		assertNotEquals(c, c2);
	}
	
	@Test
	public void testNotEqualName() {
		Column<Integer> c = Column.integerColumn("col1");
		Column<Integer> c2 = Column.integerColumn("col2");
		
		assertNotEquals(c, c2);
	}
	
	@Test
	public void testNotEqualContent() {
		Column<Integer> c = Column.integerColumn("colNotEqE");
		Column<Integer> c2 = Column.integerColumn("colNotEqE");
		c.add(10);
		assertNotEquals(c, c2);
	}

}
