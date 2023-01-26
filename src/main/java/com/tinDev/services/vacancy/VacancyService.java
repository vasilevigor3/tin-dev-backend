package com.tinDev.services.vacancy;

import com.tinDev.models.vanancy.Vacancy;

import java.util.List;
import java.util.Optional;


public interface VacancyService {
    Optional< Vacancy> findById(int id);
    List<Vacancy> findAll();
    Vacancy createVacancy(Vacancy vacancy);
    Vacancy updateVacancy(int id, Vacancy vacancy);
    void deleteVacancy(int id);
}



