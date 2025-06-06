package com.example.room_reservation.repository;

import com.example.room_reservation.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> findByType(String type);  // Mengambil ruangan berdasarkan tipe
}
