package com.tinDev.models.stack;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tinDev.models.vanancy.Vacancy;
import com.tinDev.models.user.User;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tech_stack")
public class TechStack {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        @OneToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "back_stack_id", referencedColumnName = "id")
        private BackStack backStack;

        @OneToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "front_stack_id", referencedColumnName = "id")
        private FrontStack frontStack;

        @OneToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "qa_stack_id", referencedColumnName = "id")
        private QAStack qaStack;

        @OneToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "designer_stack_id", referencedColumnName = "id")
        private DesignerStack designerStack;

        @ManyToOne
        @JoinColumn(name = "vacancy_id")
        private Vacancy vacancy;

        @ManyToOne
        @JoinColumn(name = "user_id")
        @JsonIgnore
        private User user;
}

