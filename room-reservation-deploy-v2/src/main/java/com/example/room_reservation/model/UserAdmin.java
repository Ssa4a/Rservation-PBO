package com.example.room_reservation.model;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("ADMIN")
public class UserAdmin extends UserBase {

    // Konstruktor default tanpa parameter (dibutuhkan oleh JPA)
    public UserAdmin() {
        super("default_username", "default_email@example.com", "default_password", "ADMIN");  // Memanggil konstruktor superclass UserBase dengan nilai default
    }

    // Konstruktor dengan parameter
    public UserAdmin(String username, String email, String password) {
        super(username, email, password, "ADMIN");  // Memanggil konstruktor superclass UserBase dengan nilai valid
    }

    // Implementasi metode addBookingToHistory di UserAdmin
    @Override
    public void addBookingToHistory(Booking booking) {
        // Implementasi kosong, karena UserAdmin tidak menyimpan riwayat booking
    }
}
