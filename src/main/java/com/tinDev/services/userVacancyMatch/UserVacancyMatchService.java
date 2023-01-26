package com.tinDev.services.userVacancyMatch;

import com.tinDev.models.userVacancyMatch.UserVacancyMatch;

import java.util.List;
import java.util.Optional;

public interface UserVacancyMatchService {

    List<UserVacancyMatch> findAll();
    Optional<UserVacancyMatch> findById(Long id);
    List<UserVacancyMatch> findByUserId(Long id);
    UserVacancyMatch save(UserVacancyMatch userVacancyMatch);
    UserVacancyMatch update(Long id, UserVacancyMatch userVacancyMatch);
    void deleteById(Long id);
}
