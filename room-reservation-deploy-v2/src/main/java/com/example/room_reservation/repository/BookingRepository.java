package com.example.room_reservation.repository;

import com.example.room_reservation.model.Booking;
import com.example.room_reservation.model.BookingStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByStatus(BookingStatus status);  // Menambahkan pencarian berdasarkan status
    List<Booking> findByRoomIdAndStatus(Long roomId, BookingStatus status);  // Pencarian berdasarkan roomId dan status
}
