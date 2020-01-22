package com.capgemini.Room;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BedTest {

	@Test
	public void BedTypesTest() {
		Bed bedSingle = Bed.Single;
		Bed bedDouble = Bed.Double;
		Bed bedBaby = Bed.Baby;
		Bed bedChild = Bed.Child;

		assertEquals(Bed.Baby, bedBaby);
		assertEquals(Bed.Child, bedChild);
		assertEquals(Bed.Single, bedSingle);
		assertEquals(Bed.Double, bedDouble);
	}
}
