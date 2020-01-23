package com.capgemini.room;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BedTest {

	@Test
	public void bedTypesTest() {
		Bed bedSingle = Bed.SINGLE;
		Bed bedDouble = Bed.DOUBLE;
		Bed bedBaby = Bed.BABY;
		Bed bedChild = Bed.CHILD;

		assertEquals(Bed.BABY, bedBaby);
		assertEquals(Bed.CHILD, bedChild);
		assertEquals(Bed.SINGLE, bedSingle);
		assertEquals(Bed.DOUBLE, bedDouble);
	}
}
