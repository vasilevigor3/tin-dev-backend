package com.tinDev.services.vacancy;

import java.util.List;
import java.util.Optional;

import com.tinDev.models.vanancy.Vacancy;
import com.tinDev.repository.vacancy.VacancyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VacancyServiceImpl implements VacancyService {
    private final VacancyRepository vacancyRepository;

    @Autowired
    public VacancyServiceImpl(VacancyRepository vacancyRepository) {
        this.vacancyRepository = vacancyRepository;
    }

    @Override
    public Vacancy createVacancy(Vacancy vacancy) {
        return vacancyRepository.save(vacancy);
    }

    @Override
    public Vacancy getVacancy(int id) {
        Optional<Vacancy> result = vacancyRepository.findById(id);
        return result.orElse(null);
    }

    @Override
    public List<Vacancy> getAllVacancies() {
        return vacancyRepository.findAll();
    }

    @Override
    public Vacancy updateVacancy(int id, Vacancy vacancy) {
        Optional<Vacancy> result = vacancyRepository.findById(id);
        if (result.isPresent()) {
            Vacancy existingVacancy = result.get();
            existingVacancy.setTitle(vacancy.getTitle());
            existingVacancy.setCompanyName(vacancy.getCompanyName());
            existingVacancy.setDescription(vacancy.getDescription());
            existingVacancy.setRequiredSeniority(vacancy.getRequiredSeniority());
            existingVacancy.setJobTitle(vacancy.getJobTitle());
            existingVacancy.setTechStack(vacancy.getTechStack());
            return vacancyRepository.save(existingVacancy);
        }
        return null;
    }

    @Override
    public void deleteVacancy(int id) {
        vacancyRepository.deleteById(id);
    }
}
