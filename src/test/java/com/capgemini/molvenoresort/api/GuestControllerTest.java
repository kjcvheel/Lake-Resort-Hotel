package com.capgemini.molvenoresort.api;

import com.capgemini.molvenoresort.models.Guest;
import com.capgemini.molvenoresort.repositories.GuestRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class GuestControllerTest {

    @InjectMocks
    private GuestController guestController;

    @Mock
    private GuestRepository guestRepository;

    private MockMvc mockMvc;

    private List<Guest> guests;

    @BeforeEach
    public void fillGuestTable() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(guestController).build();
        System.out.println("inti ocasj");
        guests = new ArrayList<>();
        guests.add(createDummyGuest(0, "Joey", "de Groot"));
        guests.add(createDummyGuest(1, "Kevin", "van Heel"));
        guests.add(createDummyGuest(2, "Noortje", "Wittink"));
    }

    private Guest createDummyGuest(long id, String firstname, String lastname) {
        Guest guest = new Guest(id, "password", firstname, lastname, null, null, null, null, null, null, null, "0", null);
        return guest;
    }

    @Test
    void getGuests() throws Exception {
        when(guestRepository.findAll()).thenReturn(guests);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/guests"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].id").value(guests.get(0).getGuestId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].firstName").value(guests.get(0).getFirstName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[1].id").value(guests.get(1).getGuestId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[1].firstName").value(guests.get(1).getFirstName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[2].id").value(guests.get(2).getGuestId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[2].firstName").value(guests.get(2).getFirstName()))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getGuestById() throws Exception {
        when(guestRepository.findById((long)0)).thenReturn(Optional.of(guests.get(0)));

        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/guests/0"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(guests.get(0).getGuestId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value(guests.get(0).getFirstName()))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void addGuest() throws Exception {
        Guest newGuest = createDummyGuest(3, "Boris", "Boef");
        when(guestRepository.save(any( Guest.class))).thenReturn(newGuest);

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(newGuest);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/guests/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(newGuest.getGuestId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value(newGuest.getFirstName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.lastName").value(newGuest.getLastName()))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void updateGuest() {

    }

    @Test
    void deleteGuest() {
    }
}