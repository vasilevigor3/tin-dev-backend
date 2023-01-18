package com.tinDev.models.stack;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "languages")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;
}
