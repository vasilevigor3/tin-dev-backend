package com.tinDev.controllers.vacancy;

import com.tinDev.models.vanancy.Vacancy;
import com.tinDev.services.vacancy.VacancyServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class VacancyController {

    private final VacancyServiceImpl vacancyServiceImpl;

    public VacancyController(VacancyServiceImpl vacancyServiceImpl) {
        this.vacancyServiceImpl = vacancyServiceImpl;
    }

    @PostMapping(value = "/vacancies", consumes = "application/json")
    public Vacancy createVacancy(@RequestBody Vacancy vacancy) {
        return vacancyServiceImpl.createVacancy(vacancy);
    }
//    @GetMapping("/vacancies/{id}")
//    public Vacancy getVacancy(@PathVariable int id) {
//        return vacancyServiceImpl.getVacancy(id);
//    }

    @GetMapping("/vacancies")
    public List<Vacancy> getAllVacancies() {
        return vacancyServiceImpl.getAllVacancies();
    }

    @PutMapping("/vacancies/{id}")
    public Vacancy updateVacancy(@PathVariable int id, @RequestBody Vacancy vacancy) {
        return vacancyServiceImpl.updateVacancy(id, vacancy);
    }

    @DeleteMapping("/vacancies/{id}")
    public void deleteVacancy(@PathVariable int id) {
        vacancyServiceImpl.deleteVacancy(id);
    }
}
