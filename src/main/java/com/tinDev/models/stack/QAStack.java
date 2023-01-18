package com.tinDev.models.stack;


import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "qa_stack")
public class QAStack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(mappedBy = "qaStack")
    private TechStack techStack;
}
