package com.tinDev.controllers.vacancy;

import com.tinDev.models.vanancy.Vacancy;
import com.tinDev.services.vacancy.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vacancies")
public class VacancyController {
    @Autowired
    private VacancyService vacancyService;


    @GetMapping("/{id}")
    public ResponseEntity<Vacancy> findById(@PathVariable int id) {
        Optional<Vacancy> vacancy = vacancyService.findById(id);
        return vacancy.map(v -> ResponseEntity.ok().body(v))
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping
    public List<Vacancy> findAllVacancies() {
        return vacancyService.findAll();
    }
    @PostMapping
    public Vacancy createVacancy(@RequestBody Vacancy vacancy) {
        return vacancyService.createVacancy(vacancy);
    }
    @PutMapping("/{id}")
    public Vacancy updateVacancy(@PathVariable int id, @RequestBody Vacancy vacancy) {
        return vacancyService.updateVacancy(id, vacancy);
    }
    @DeleteMapping("/vacancies/{id}")
    public void deleteVacancy(@PathVariable int id) {
        vacancyService.deleteVacancy(id);
    }
}
