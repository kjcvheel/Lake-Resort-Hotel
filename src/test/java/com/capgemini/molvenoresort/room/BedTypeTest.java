package com.capgemini.molvenoresort.room;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BedTypeTest {

	@Test
	public void bedTypesTest() {
		BedType bedTypeSingle = BedType.SINGLE;
		BedType bedTypeDouble = BedType.DOUBLE;
		BedType bedTypeBaby = BedType.BABY;
		BedType bedTypeChild = BedType.CHILD;

		assertEquals(BedType.BABY, bedTypeBaby);
		assertEquals(BedType.CHILD, bedTypeChild);
		assertEquals(BedType.SINGLE, bedTypeSingle);
		assertEquals(BedType.DOUBLE, bedTypeDouble);
	}
}
