package com.tinDev.models.stack;

import lombok.Data;

import javax.persistence.*;


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

