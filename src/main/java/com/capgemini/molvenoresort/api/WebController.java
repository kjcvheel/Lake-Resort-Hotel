package com.capgemini.molvenoresort.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping
    public String loadHomepage(){
        return "index";
    }

    @GetMapping("booking")
    public String loadBookingPage() {
        return "booking";
    }

    @GetMapping("BookingGuestForm")
    public String loadGuestFormPage() {
        return "BookingGuestForm";
    }

    @GetMapping("employeePortalRooms")
    public String loadEmployeePortalRooms() {
        return "employeePortalRooms";
    }

    @GetMapping("employeePortalGuests")
    public String loadEmployeePortalGuests() {
        return "employeePortalGuests";
    }
}
