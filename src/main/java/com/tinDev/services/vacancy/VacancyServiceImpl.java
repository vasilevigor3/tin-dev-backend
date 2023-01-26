package com.tinDev.services.vacancy;

import com.tinDev.models.vanancy.Vacancy;
import com.tinDev.repository.vacancy.VacancyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Optional<Vacancy> findById(long id) {
        return vacancyRepository.findById(id);
    }

    @Override
    public List<Vacancy> findAll() {
        return vacancyRepository.findAll();
    }

    @Override
    public Vacancy updateVacancy(long id, Vacancy vacancy) {
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
    public void deleteVacancy(long id) {
        vacancyRepository.deleteById(id);
    }
}
