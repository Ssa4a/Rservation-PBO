package com.example.room_reservation.model;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("PELANGGAN")
public class UserPelanggan extends UserBase {

    // Konstruktor default tanpa parameter (dibutuhkan oleh JPA)
    public UserPelanggan() {
        super("default_username", "default_email@example.com", "default_password", "PELANGGAN");  // Memanggil konstruktor superclass UserBase dengan nilai default
    }

    // Konstruktor dengan parameter
    public UserPelanggan(String username, String email, String password) {
        super(username, email, password, "PELANGGAN");  // Memanggil konstruktor superclass UserBase dengan nilai valid
    }

    // Implementasi metode addBookingToHistory di UserPelanggan
    @Override
    public void addBookingToHistory(Booking booking) {
        // Implementasi kosong, karena UserPelanggan tidak menyimpan riwayat booking
    }
}
