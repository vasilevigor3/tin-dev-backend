package com.tinDev.models.stack;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "designer_stack")
public class DesignerStack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(mappedBy = "designerStack")
    private TechStack techStack;
}

