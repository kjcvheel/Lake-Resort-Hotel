package com.capgemini.Room;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class RoomTest {
	Room room;

	@Before
	public void Before() {
		room = new Room("Suite 02", 400, 101, RoomType.Single);
	}

	@Test
	public void CreateRoomTest() {
		// Happy Path
		room = new Room("Suite 01", 400, 101, RoomType.Single);
		assertEquals("Suite 01", room.getId());
		assertEquals(400, room.getPrice());
		assertEquals(101, room.getNumber());
		assertEquals(RoomType.Single, room.getType());

		// TODO: Unhappy Path
	}

	@Test
	public void RoomTypesTest() {
		// Single
		assertEquals(RoomType.Single, room.getType());

		// Double
		room.setType(RoomType.Double);
		assertEquals(RoomType.Double, room.getType());

		// Doublex2
		room.setType(RoomType.Doublex2);
		assertEquals(RoomType.Doublex2, room.getType());

		// Penthouse
		room.setType(RoomType.Penthouse);
		assertEquals(RoomType.Penthouse, room.getType());
	}

	@Test
	public void RoomIdTest() {
		room.setId("Suite 99");
		assertEquals("Suite 99", room.getId());

		room.setId("@#$ 99");
		assertEquals("@#$ 99", room.getId());

		room.setId("-jlk12");
		assertEquals("-jlk12", room.getId());
	}
}
