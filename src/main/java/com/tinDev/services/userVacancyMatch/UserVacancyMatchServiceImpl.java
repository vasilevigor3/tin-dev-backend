package com.tinDev.services.userVacancyMatch;

import com.tinDev.models.user.User;
import com.tinDev.models.userVacancyMatch.UserVacancyMatch;
import com.tinDev.models.vanancy.Vacancy;
import com.tinDev.repository.user.UserRepository;
import com.tinDev.repository.userVacancyMatch.UserVacancyMatchRepository;
import com.tinDev.repository.vacancy.VacancyRepository;
import com.tinDev.services.user.UserService;
import com.tinDev.services.vacancy.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserVacancyMatchServiceImpl implements UserVacancyMatchService {

    @Autowired
    private final UserVacancyMatchRepository userVacancyMatchRepository;
    @Autowired
    private final UserService userService;
    @Autowired
    private final VacancyService vacancyService;

    public UserVacancyMatchServiceImpl(UserVacancyMatchRepository userVacancyMatchRepository, UserRepository userRepository, VacancyRepository vacancyRepository, UserService userService, VacancyService vacancyService) {
        this.userVacancyMatchRepository = userVacancyMatchRepository;
        this.userService = userService;
        this.vacancyService = vacancyService;
    }

    @Override
    public List<UserVacancyMatch> findAll() {
        return userVacancyMatchRepository.findAll();
    }

    @Override
    public Optional<UserVacancyMatch> findById(Long id) {
        return userVacancyMatchRepository.findById(id);
    }

    @Override
    public List<UserVacancyMatch> findByUserId(Long id) {
        return userVacancyMatchRepository.findCustomMatchesForCurrentUser(id);
    }

    @Override
    public UserVacancyMatch save(UserVacancyMatch userVacancyMatch) {
        final User user = userService.findById(userVacancyMatch.getUser().getUserId()).get();
        final Vacancy vacancy = vacancyService.findById(userVacancyMatch.getVacancy().getId()).get();
        user.setMatches(Collections.singletonList(userVacancyMatch));
        vacancy.setMatches(Collections.singletonList(userVacancyMatch));

        return userVacancyMatchRepository.save(userVacancyMatch);
    }

    @Override
    public UserVacancyMatch update(Long id, UserVacancyMatch userVacancyMatch) {
        UserVacancyMatch existingUserVacancyMatch = findById(id).get();
        existingUserVacancyMatch.setUser(userVacancyMatch.getUser());
        existingUserVacancyMatch.setVacancy(userVacancyMatch.getVacancy());
        existingUserVacancyMatch.setMatchDate(userVacancyMatch.getMatchDate());
        return userVacancyMatchRepository.save(existingUserVacancyMatch);
    }

    @Override
    public void deleteById(Long id) {
        userVacancyMatchRepository.deleteById(id);
    }
}
