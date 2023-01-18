package com.tinDev.models.vanancy;

import com.tinDev.models.stack.TechStack;
import com.tinDev.models.userVacancyMatch.UserVacancyMatch;
import com.tinDev.models.user.enums.Carrier;
import com.tinDev.models.user.enums.Seniority;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "vacancies")
public class Vacancy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "required_seniority")
    private Seniority requiredSeniority;

    @Enumerated(EnumType.STRING)
    @Column(name = "job_title")
    private Carrier jobTitle;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "vacancy_tech_stack",
            joinColumns = @JoinColumn(name = "vacancy_id"),
            inverseJoinColumns = @JoinColumn(name = "tech_stack_id")
    )
    private List<TechStack> techStack;

    @OneToMany(mappedBy = "vacancy", cascade = CascadeType.ALL)
    private Set<UserVacancyMatch> matches;
}