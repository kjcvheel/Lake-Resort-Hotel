package com.capgemini.Room;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

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
	public void RoomStatusTest() {
		// Available
		assertEquals(RoomStatus.Available, room.getStatus());

		// Unavailable
		room.setStatus(RoomStatus.Unavailable);
		assertEquals(RoomStatus.Unavailable, room.getStatus());

		// InCleaning
		room.setStatus(RoomStatus.InCleaning);
		assertEquals(RoomStatus.InCleaning, room.getStatus());
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

	@Test
	public void RoomBedsTest() {
		List<Bed> beds = new ArrayList<>();
		beds.add(Bed.Single);

		room.setBeds(beds);
		assertEquals(beds, room.getBeds());
		assertEquals(1, room.getBeds().size());

		beds.add(Bed.Single);
		room.setBeds(beds);
		assertEquals(beds, room.getBeds());
		assertEquals(2, room.getBeds().size());

		beds.add(Bed.Double);
		room.setBeds(beds);
		assertEquals(beds, room.getBeds());
		assertEquals(3, room.getBeds().size());

		beds.remove(2);
		room.setBeds(beds);
		assertEquals(beds, room.getBeds());
		assertEquals(2, room.getBeds().size());
	}

	@Test
	public void RoomGettersAndSettersTest(){
		// Price
		room.setPrice(5000);
		assertEquals(5000, room.getPrice());

		room.setPrice(0);
		assertEquals(0, room.getPrice());

		room.setPrice(-5000);
		assertEquals(0, room.getPrice());

		// Number
		room.setNumber(304);
		assertEquals(304, room.getNumber());

		room.setNumber(0);
		assertEquals(304, room.getNumber());

		room.setNumber(-304);
		assertEquals(304, room.getNumber());

		// Adult
		room.setAdult(1);
		assertEquals(1, room.getAdult());

		room.setAdult(0);
		assertEquals(1, room.getAdult());

		room.setAdult(-1);
		assertEquals(1, room.getAdult());

		// Children
		room.setChildren(2);
		assertEquals(2, room.getChildren());

		room.setChildren(0);
		assertEquals(0, room.getChildren());

		room.setChildren(-1);
		assertEquals(0, room.getChildren());

		// Disabled
		room.setDisabled(true);
		assertTrue(room.isDisabled());

		room.setDisabled(false);
		assertFalse(room.isDisabled());

		// Smoking

		room.setSmoking(true);
		assertTrue(room.isSmoking());

		room.setSmoking(false);
		assertFalse(room.isSmoking());
	}
}
