package com.tinDev.models.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import com.tinDev.models.user.enums.Carrier;
import com.tinDev.models.user.enums.Seniority;

import javax.persistence.*;

@Data
@Entity
@Table(name = "positions")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(name = "carrier")
    private Carrier carrier;

    @Enumerated(EnumType.STRING)
    @Column(name = "seniority")
    private Seniority seniority;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;
}

