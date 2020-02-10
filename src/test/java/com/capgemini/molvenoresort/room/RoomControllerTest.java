package com.capgemini.molvenoresort.room;

import com.capgemini.molvenoresort.api.RoomController;
import com.capgemini.molvenoresort.enums.RoomType;
import com.capgemini.molvenoresort.models.Room;
import com.capgemini.molvenoresort.repositories.RoomRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.hasSize;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;






@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RoomControllerTest {
    @InjectMocks
    private RoomController roomController;

    @Mock
    private RoomRepository roomRepository;

    private MockMvc mockMvc;

    @Before
    public void setup(){this.mockMvc = MockMvcBuilders.standaloneSetup(roomController).build();}


    @Test
    public void getRoomsTest() throws Exception {
        List<Room> rooms = new ArrayList<>();

        rooms.add(new Room("Room 1", 500, 101, RoomType.DOUBLE));
        rooms.add(new Room("Room 2", 900, 102, RoomType.PENTHOUSE));

        when(roomRepository.findAll()).thenReturn((Iterable)rooms);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/rooms"))
                .andDo(print())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$.[0].name").value(rooms.get(0).getName()))
                .andExpect(jsonPath("$.[0].price").value(rooms.get(0).getPrice()))
                .andExpect(jsonPath("$.[1].name").value(rooms.get(1).getName()))
                .andExpect(jsonPath("$.[1].price").value(rooms.get(1).getPrice()))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    public void getRoomByIdTest() throws Exception {
        Room room = new Room("Room 1", 500, 101, RoomType.DOUBLE);

        when(roomRepository.findById(101L)).thenReturn(Optional.of(room));

        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/rooms/101"))
                .andDo(print())
                .andExpect(jsonPath("$.name").value(room.getName()))
                .andExpect(jsonPath("$.id").value(room.getId()))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    public void addRoomTest() throws Exception {
        Room room = new Room("Klaas", 500, 501, RoomType.SINGLE);

        when(roomRepository.save(room)).thenReturn(room);

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(room);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/rooms/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andDo(print())
                .andExpect(jsonPath("$.name").value(room.getName()))
                .andExpect(jsonPath("$.id").value(room.getId()))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    /*@Test
    public void roomsUnderTest() {
        Iterable<Room> rooms;
        int[] amountsToTest = new int[] {580, 300, 99999, -500};
        int[] roomsPerAmount = new int[] {2, 0, 5, 0};
        for (int i = 0; i < amountsToTest.length; i++) {
            rooms = roomController.roomsUnder(amountsToTest[i]);
            assertEquals(roomsPerAmount[i], ((Collection<?>) rooms).size());
            for (Room room:rooms) {
                assertTrue(room.getPrice() <= amountsToTest[i]);
            }
        }
    }

    @Test
    public void singleRoomsUnderTest() {
        Iterable<Room> rooms;
        int[] amountsToTest = new int[] {710, 690, 300, -500};
        int[] roomsPerAmount = new int[] {3, 2, 0, 0};
        for (int i = 0; i < amountsToTest.length; i++) {
            rooms = roomController.singleRoomsUnder(amountsToTest[i]);
            assertEquals(roomsPerAmount[i], ((Collection<?>) rooms).size());
            for (Room room:rooms) {
                assertEquals(RoomType.SINGLE, room.getType());
                assertTrue(room.getPrice() <= amountsToTest[i]);
            }
        }
    }*/
}
