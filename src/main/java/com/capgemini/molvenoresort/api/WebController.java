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

    @GetMapping("employeePortalBookings")
    public String loadEmployeePortalBookings() {
        return "employeePortalBookings";
    }

    @GetMapping("restaurant")
    public String loadRestaurant() {
        return "restaurant";
    }

    @GetMapping("login")
    public String loadLogin() {
        return "login";
    }
    
    @GetMapping("confirmation")
    public String loadConfirmation() {return "bookingConfirmation";}

    @GetMapping("contact")
    public String loadContact() {
        return "contact";
    }

    @GetMapping("FAQ")
    public String loadFAQ() {
        return "FAQ";
    }

}
