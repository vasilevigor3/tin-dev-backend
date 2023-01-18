package com.tinDev.controllers.userVacancyMatch;

import com.tinDev.models.userVacancyMatch.UserVacancyMatch;
import com.tinDev.services.userVacancyMatch.UserVacancyMatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-vacancy-matches")
public class UserVacancyMatchController {
    @Autowired
    private final UserVacancyMatchService userVacancyMatchService;

    public UserVacancyMatchController(UserVacancyMatchService userVacancyMatchService) {
        this.userVacancyMatchService = userVacancyMatchService;
    }

    @GetMapping
    public List<UserVacancyMatch> getAllUserVacancyMatches() {
        return userVacancyMatchService.findAll();
    }

    @GetMapping("/{id}")
    public UserVacancyMatch getUserVacancyMatchById(@PathVariable Long id) {
        return userVacancyMatchService.findById(id);
    }

    @PostMapping
    public UserVacancyMatch createUserVacancyMatch(@RequestBody UserVacancyMatch userVacancyMatch) {
        return userVacancyMatchService.save(userVacancyMatch);
    }

    @PutMapping("/{id}")
    public UserVacancyMatch updateUserVacancyMatch(@PathVariable Long id, @RequestBody UserVacancyMatch userVacancyMatch) {
        return userVacancyMatchService.update(id, userVacancyMatch);
    }

    @DeleteMapping("/{id}")
    public void deleteUserVacancyMatch(@PathVariable Long id) {
        userVacancyMatchService.deleteById(id);
    }
}

