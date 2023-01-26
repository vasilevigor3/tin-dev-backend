package com.tinDev.repository.userVacancyMatch;

import com.tinDev.models.userVacancyMatch.UserVacancyMatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserVacancyMatchRepository extends JpaRepository<UserVacancyMatch, Long> {
    @Query("FROM UserVacancyMatch uvm JOIN uvm.user u WHERE u.userId = :userId")
    List<UserVacancyMatch> findCustomMatchesForCurrentUser(final long userId);


}
