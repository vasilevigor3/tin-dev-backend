package com.tinDev.services.userVacancyMatch;

import com.tinDev.models.userVacancyMatch.UserVacancyMatch;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UserVacancyMatchService {

    List<UserVacancyMatch> findAll();
    Optional<UserVacancyMatch> findById(Long id);
    UserVacancyMatch save(UserVacancyMatch userVacancyMatch);
    UserVacancyMatch update(Long id, UserVacancyMatch userVacancyMatch);
    void deleteById(Long id);
    Set<UserVacancyMatch> findAllMatchesForCurrentUser(final String userId);

}
