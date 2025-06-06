package com.example.room_reservation.controller;

import com.example.room_reservation.model.Booking;
import com.example.room_reservation.model.BookingManager;
import com.example.room_reservation.model.UserBase;  // Menambahkan import UserBase
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BookingController {

    @Autowired
    private BookingManager bookingManager;

    @GetMapping("/booking/history")
    public String viewBookingHistory(Model model, UserBase user) {
        List<Booking> bookings = bookingManager.getBookingsForUser(user);
        model.addAttribute("bookings", bookings);
        return "bookingHistory";  // Menampilkan riwayat booking
    }

    @PostMapping("/booking/cancel")
    public String cancelBooking(@RequestParam("bookingId") int bookingId, Model model) {
        boolean success = bookingManager.cancelBooking(bookingId);
        if (success) {
            model.addAttribute("message", "Booking berhasil dibatalkan.");
        } else {
            model.addAttribute("error", "Booking ID tidak ditemukan.");
        }
        return "home";  // Redirect ke halaman home setelah pembatalan
    }
}
