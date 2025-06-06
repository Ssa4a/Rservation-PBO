package com.example.room_reservation.model;

import com.example.room_reservation.repository.BookingRepository;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingManager {

    @Autowired
    private BookingRepository bookingRepository;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "bookingManager")
    private List<Booking> managedBookings;

    @OneToMany
    private List<Room> rooms;  // Daftar ruangan yang dikelola oleh BookingManager

    // Getter dan Setter untuk id, name, managedBookings, dan rooms
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Booking> getManagedBookings() {
        return managedBookings;
    }

    public void setManagedBookings(List<Booking> managedBookings) {
        this.managedBookings = managedBookings;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    // Method untuk mendapatkan booking berdasarkan user
    public List<Booking> getBookingsForUser(UserBase user) {
        return managedBookings.stream()
                .filter(booking -> booking.getUser().equals(user))
                .collect(Collectors.toList());
    }

    // Method untuk mendapatkan daftar semua ruangan
    public List<Room> getAllRooms() {
        return rooms;
    }

    // Menambahkan booking baru ke dalam database
    public void submitBooking(Booking booking) {
        bookingRepository.save(booking);
    }

    // Method untuk membatalkan booking
    public boolean cancelBooking(int bookingId) {
        Booking booking = bookingRepository.findById((long) bookingId).orElse(null);
        if (booking != null) {
            bookingRepository.delete(booking);
            return true;
        }
        return false;
    }

    // Method untuk mendapatkan ruangan berdasarkan tipe
    public List<Room> getRoomsByType(String type) {
        return rooms.stream()
                .filter(room -> room.getType().equalsIgnoreCase(type))
                .collect(Collectors.toList());
    }

    // Method untuk mendapatkan bookings berdasarkan roomId dan status
    public List<Booking> getBookingsByRoomAndStatus(Long roomId, BookingStatus status) {
        return bookingRepository.findByRoomIdAndStatus(roomId, status);
    }

    // Method untuk mendapatkan bookings berdasarkan status
    public List<Booking> getBookingsByStatus(BookingStatus status) {
        return bookingRepository.findByStatus(status);
    }
}
