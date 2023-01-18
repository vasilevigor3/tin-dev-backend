package com.tinDev.models.user;

import com.tinDev.models.stack.Language;
import com.tinDev.models.stack.TechStack;
import com.tinDev.models.user.enums.WorkType;
import com.tinDev.models.userVacancyMatch.UserVacancyMatch;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_last_name")
    private String userLastName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_contacts_id", referencedColumnName = "id")
    private UserContacts userContacts;

    @Enumerated(EnumType.STRING)
    @Column(name = "work_type")
    private WorkType workType;

    @Column(name = "salary_expectations")
    private int salaryExpectations;

    @Column(name = "experience")
    private int experience;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "user_languages",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "language_id")
    )
    private Set<Language> languages;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Position> positions;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "user_tech_stack",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "tech_stack_id")
    )
    private Set<TechStack> techStack;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<UserVacancyMatch> matches;
}