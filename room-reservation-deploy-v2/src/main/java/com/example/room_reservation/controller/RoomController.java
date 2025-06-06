package com.example.room_reservation.controller;

import com.example.room_reservation.model.BookingManager;
import com.example.room_reservation.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class RoomController {

    @Autowired
    private BookingManager bookingManager;

    @GetMapping("/rooms")
    public String listRooms(Model model) {
        List<Room> rooms = bookingManager.getAllRooms();
        model.addAttribute("rooms", rooms);
        return "rooms"; // Menampilkan daftar ruangan
    }
}
