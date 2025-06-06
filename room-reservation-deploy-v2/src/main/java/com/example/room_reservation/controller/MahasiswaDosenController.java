package com.example.room_reservation.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.room_reservation.model.Booking;
import com.example.room_reservation.model.BookingManager;
import com.example.room_reservation.model.UserBase;

@Controller
@RequestMapping("/MAHASISWA")
public class MahasiswaDosenController {

    @Autowired
    private BookingManager bookingManager;

    // Fungsi untuk melihat riwayat booking
    @GetMapping("/booking-history")
    public String viewBookingHistory(Model model, UserBase user) {
        // Mendapatkan riwayat booking untuk user yang login
        List<Booking> bookings = bookingManager.getBookingsForUser(user);
        model.addAttribute("bookings", bookings);
        return "bookingHistory";  // Menampilkan riwayat booking
    }

    @GetMapping("/request-booking")
    public String requestBooking(Model model) {
        // Menampilkan form untuk membuat pemesanan baru
        model.addAttribute("rooms", bookingManager.getAllRooms());  // Mengambil semua ruangan yang tersedia
        return "requestBooking";  // Halaman untuk melakukan pemesanan ruangan
    }
}
