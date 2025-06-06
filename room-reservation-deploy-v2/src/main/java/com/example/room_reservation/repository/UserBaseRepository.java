package com.example.room_reservation.repository;

import com.example.room_reservation.model.UserBase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;  // Add this import

@Repository
public interface UserBaseRepository extends JpaRepository<UserBase, Integer> {

    // Mencari User berdasarkan email
    UserBase findByEmail(String email);

    // Pencarian berdasarkan role
    List<UserBase> findByRole(String role);  // Now this should work fine
}
