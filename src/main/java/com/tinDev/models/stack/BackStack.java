package com.tinDev.models.stack;


import javax.persistence.*;

@Entity
@Table(name = "back_stack")
public class BackStack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="stack")
    private String stack;

    @OneToOne(mappedBy = "backStack")
    private TechStack techStack;
}
