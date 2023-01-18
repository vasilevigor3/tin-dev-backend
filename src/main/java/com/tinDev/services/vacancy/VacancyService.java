package com.tinDev.services.vacancy;

import com.tinDev.models.vanancy.Vacancy;

import java.util.List;


public interface VacancyService {
    Vacancy createVacancy(Vacancy vacancy);
    Vacancy getVacancy(int id);
    List<Vacancy> getAllVacancies();
    Vacancy updateVacancy(int id, Vacancy vacancy);
    void deleteVacancy(int id);
}



