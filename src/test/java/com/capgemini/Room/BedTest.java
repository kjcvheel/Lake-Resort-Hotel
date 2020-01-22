package com.capgemini.Room;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BedTest {

	@Test
	public void BedTypesTest() {
		Bed bedSingle = new Bed(BedType.Single);
		Bed bedDouble = new Bed(BedType.Double);
		Bed bedBaby = new Bed(BedType.Baby);
		Bed bedChild = new Bed(BedType.Child);

		assertEquals(BedType.Baby, bedBaby.getType());
		assertEquals(BedType.Child, bedChild.getType());
		assertEquals(BedType.Single, bedSingle.getType());
		assertEquals(BedType.Double, bedDouble.getType());
	}
}
