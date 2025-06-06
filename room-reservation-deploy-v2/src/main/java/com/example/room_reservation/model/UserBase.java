package com.example.room_reservation.model;

import jakarta.persistence.*;
import com.example.room_reservation.model.UserBase;  // Menambahkan import untuk UserBase


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "role", discriminatorType = DiscriminatorType.STRING)
public abstract class UserBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;
    private String email;
    private String password;

    @Column(insertable=false, updatable=false)  // Kolom role tidak akan disisipkan atau diperbarui oleh Hibernate
    private String role;

    // Konstruktor dengan parameter
    public UserBase(String username, String email, String password, String role) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    // Getter dan setter untuk id, username, email, password, role
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // Metode abstract untuk addBookingToHistory
    public abstract void addBookingToHistory(Booking booking);
}
