package com.tinDev.models.userVacancyMatch;

import com.tinDev.models.user.User;
import com.tinDev.models.vanancy.Vacancy;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "testAssignment", schema = "public")
public class TestAssignment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "vacancyStatusId")
    private int vacancyStatusId;
    @Column(name = "date")
    private Date date;
    @Column(name = "linkToAssignment")
    private String linkToAssignment;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "vacancy_id")
    private Vacancy vacancy;

}
