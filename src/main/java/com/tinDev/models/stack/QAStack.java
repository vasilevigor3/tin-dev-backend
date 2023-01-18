package com.tinDev.models.stack;

import jakarta.persistence.*;
import lombok.Data;

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
