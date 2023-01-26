package com.tinDev.models.userVacancyMatch;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.tinDev.models.user.User;
import com.tinDev.models.vanancy.Vacancy;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class UserVacancyMatch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference(value="user-reference")
    private User user;

    @ManyToOne
    @JoinColumn(name = "vacancy_id")
    @JsonBackReference(value="vacancy-reference")
    private Vacancy vacancy;

    private LocalDateTime matchDate;
}