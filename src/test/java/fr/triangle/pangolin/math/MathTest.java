package fr.triangle.pangolin.math;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fr.triangle.pangolin.dataframe.Column;
public class MathTest {

	Column<Integer> cInt;
	Column<Double> cDouble;
	Column<String> cS;
	Max max;
	Min min;
	Mean mean;
	Sum sum;
	@Before
	public void initialize() {
		cInt = Column.integerColumn("colInt");
		cDouble = Column.doubleColumn("colDbl");
		cS = Column.stringColumn("colS");
		max = new Max();
		min = new Min();
		mean = new Mean();
		sum = new Sum();
		for (int i = 0; i <= 10; i++) {
			cInt.add(i);
			cDouble.add(Double.valueOf(i));
			cS.add(""+i);
		}
	}
	@Test
	public void maxOkTest() {
		assertEquals(10,max.op(cInt));
		assertEquals(10.0,max.op(cDouble));
	}
	
	@Test
	public void minOkTest() {
		assertEquals(0, min.op(cInt));
		assertEquals(0.0, min.op(cDouble));
	}
	
	@Test
	public void sumOkTest() {
		assertEquals(55, sum.op(cInt));
		assertEquals(55.0, sum.op(cDouble));
	}
	
	@Test
	public void meanOkTest() {
		assertEquals(5, mean.op(cInt));
		assertEquals(5.0, mean.op(cDouble));
	}
	
	@Test(expected = ClassCastException.class)
	public void maxOnString() {
		max.op((Column) cS);
	}
	
	@Test(expected = ClassCastException.class)
	public void minOnString() {
		min.op((Column) cS);
	}
	
	@Test(expected = ClassCastException.class)
	public void sumOnString() {
		sum.op((Column) cS);
	}
	
	@Test(expected = ClassCastException.class)
	public void meanOnString() {
		mean.op((Column) cS);
	}
	
	
	
	

}
