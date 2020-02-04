package com.capgemini.molvenoresort.room;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class RoomTest {
	Room room;

	@Before
	public void before() {
		room = new Room("Suite 02", 400, 101, RoomType.SINGLE);
	}

	@Test
	public void createRoomTest() {
		// Happy Path
		room = new Room("Suite 01", 400, 101, RoomType.SINGLE);
		assertEquals("Suite 01", room.getName());
		assertEquals(400, room.getPrice());
		assertEquals(101, room.getId());
		assertEquals(RoomType.SINGLE, room.getType());

		// TODO: Unhappy Path
	}

	@Test
	public void roomTypesTest() {
		// Single
		assertEquals(RoomType.SINGLE, room.getType());

		// Double
		room.setType(RoomType.DOUBLE);
		assertEquals(RoomType.DOUBLE, room.getType());

		// Doublex2
		room.setType(RoomType.DOUBLEX_2);
		assertEquals(RoomType.DOUBLEX_2, room.getType());

		// Penthouse
		room.setType(RoomType.PENTHOUSE);
		assertEquals(RoomType.PENTHOUSE, room.getType());
	}

	@Test
	public void roomStatusTest() {
		// Available
		assertEquals(RoomStatus.AVAILABLE, room.getStatus());

		// Unavailable
		room.setStatus(RoomStatus.UNAVAILABLE);
		assertEquals(RoomStatus.UNAVAILABLE, room.getStatus());

		// InCleaning
		room.setStatus(RoomStatus.IN_CLEANING);
		assertEquals(RoomStatus.IN_CLEANING, room.getStatus());
	}

	@Test
	public void roomIdTest() {
		room.setName("Suite 99");
		assertEquals("Suite 99", room.getName());

		room.setName("@#$ 99");
		assertEquals("@#$ 99", room.getName());

		room.setName("-jlk12");
		assertEquals("-jlk12", room.getName());
	}

	@Test
	public void roomBedsTest() {
		List<Bed> beds = new ArrayList<>();
		beds.add(new Bed(BedType.SINGLE));

		room.setBeds(beds);
		assertEquals(beds, room.getBeds());
		assertEquals(1, room.getBeds().size());

		beds.add(new Bed(BedType.SINGLE));
		room.setBeds(beds);
		assertEquals(beds, room.getBeds());
		assertEquals(2, room.getBeds().size());

		beds.add(new Bed(BedType.DOUBLE));
		room.setBeds(beds);
		assertEquals(beds, room.getBeds());
		assertEquals(3, room.getBeds().size());

		beds.remove(2);
		room.setBeds(beds);
		assertEquals(beds, room.getBeds());
		assertEquals(2, room.getBeds().size());
	}

	@Test
	public void roomGettersAndSettersTest(){
		// Price
		room.setPrice(5000);
		assertEquals(5000, room.getPrice());

		room.setPrice(0);
		assertEquals(0, room.getPrice());

		room.setPrice(-5000);
		assertEquals(0, room.getPrice());

		// Number
		room.setId(304);
		assertEquals(304, room.getId());

		room.setId(0);
		assertEquals(304, room.getId());

		room.setId(-304);
		assertEquals(304, room.getId());

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

//		// Facilities
//	//	List<Facilities> facilities = new ArrayList<>();
//	//	facilities.add(Facilities.AIRCO);
//	//	facilities.add(Facilities.MINIBAR);
//		room.setFacilities(facilities);
//		assertEquals(facilities, room.getFacilities());
	}
}
