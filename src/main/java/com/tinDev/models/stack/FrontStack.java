package com.tinDev.models.stack;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "front_stack")
public class FrontStack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne(mappedBy = "frontStack")
    private TechStack techStack;
}
