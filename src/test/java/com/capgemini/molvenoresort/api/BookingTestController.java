/*
package com.capgemini.molvenoresort.api;
import com.capgemini.molvenoresort.models.Booking;
import com.capgemini.molvenoresort.models.Guest;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@AutoConfigureMockMvc
public class BookingTestController {


    @InjectMocks
    private BookingController testController;

    @Mock
    private bookingRepository bookingRepository;

    private MockMvc mockMvc;

    private Booking booking;

    private Guest dummy1 = new Guest(4);
    private Guest dummy2 = new Guest(3);
    LocalDate dummyDate1 = LocalDate.of(4,2,1);
    LocalDate dummyDate2 = LocalDate.of(6,3,2);

    @Before
    public void setup(){
        System.out.println("HELOOOOOOOOOOOOOOOO");
        this.mockMvc = MockMvcBuilders.standaloneSetup(testController).build();
    }

    @Test
    public void testGetAllBookings() throws Exception {
        List<Booking> dummyBookings = new ArrayList<Booking>();
        dummyBookings.add(new Booking(1, dummy1, dummyDate1, dummyDate2 ));
        dummyBookings.add(new Booking(2, dummy2, dummyDate1, dummyDate2));

        when(bookingRepository.findAll()).thenReturn(dummyBookings);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/bookings"))
                .andDo(MockMvcResultHandlers.print())
                //.andExpect(MockMvcResultMatchers.jsonPath("$.[0].id").value(dummyBookings.get(0).getId()))
                .andExpect(MockMvcResultMatchers.status().isOk());
//        System.out.println("HELLO2");
    }
}
*/
