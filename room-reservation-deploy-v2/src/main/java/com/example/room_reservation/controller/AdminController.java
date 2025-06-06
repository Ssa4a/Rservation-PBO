package com.example.room_reservation.controller;

import org.springframework.web.bind.annotation.PostMapping;  // Tambahkan import ini
import com.example.room_reservation.model.Booking;
import com.example.room_reservation.model.BookingManager;
import com.example.room_reservation.model.Room;
import com.example.room_reservation.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private BookingManager bookingManager;

    @Autowired
    private BookingService bookingService;

    @GetMapping("/admin/dashboard")
    public String showAdminDashboard() {
        return "admin_dashboard";  // Menampilkan halaman dashboard admin
    }

    @GetMapping("/admin/rooms")
    public String showRoomTypes(Model model) {
        model.addAttribute("roomTypes", List.of("Kelas", "Lab", "Seminar"));
        return "room_types";  // Menampilkan halaman untuk memilih jenis ruangan
    }

    @GetMapping("/admin/rooms/list")
    public String showRoomsByType(@RequestParam("type") String type, Model model) {
        List<Room> rooms = bookingManager.getRoomsByType(type);  // Mendapatkan ruangan berdasarkan jenis
        model.addAttribute("rooms", rooms);  // Menampilkan daftar ruangan
        return "room_list";
    }

//    @GetMapping("/admin/rooms/bookings")
//    public String showRoomBookings(@RequestParam("roomId") Long roomId, Model model) {
////        List<Booking> availableBookings = bookingManager.getAvailableBookingsForRoom(roomId);  // Mendapatkan booking berdasarkan ruangan
//        model.addAttribute("availableBookings", availableBookings);  // Menampilkan daftar booking yang tersedia
//        return "room_bookings";
//    }

    @PostMapping("/admin/approveBooking")
    public String approveBooking(@RequestParam("bookingId") Long bookingId) {
        bookingService.acceptBooking(bookingId, bookingManager);
        return "redirect:/admin/rooms/bookings";  // Redirect setelah approval
    }

    @PostMapping("/admin/rejectBooking")
    public String rejectBooking(@RequestParam("bookingId") Long bookingId) {
        bookingService.rejectBooking(bookingId, bookingManager);
        return "redirect:/admin/rooms/bookings";  // Redirect setelah rejection
    }
}
