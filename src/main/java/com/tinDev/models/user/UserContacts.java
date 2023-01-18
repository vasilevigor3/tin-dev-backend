package com.tinDev.models.user;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "user_contacts")
public class UserContacts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;
}
