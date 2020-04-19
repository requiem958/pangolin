package fr.triangle.pangolin.dataframe;

import static org.junit.Assert.*;

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

}
