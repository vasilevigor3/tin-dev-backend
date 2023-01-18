package com.tinDev.repository.vacancy;

import com.tinDev.models.vanancy.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacancyRepository extends JpaRepository<Vacancy, Integer> {
}
