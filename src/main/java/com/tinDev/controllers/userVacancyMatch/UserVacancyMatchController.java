package com.tinDev.controllers.userVacancyMatch;

import com.tinDev.models.userVacancyMatch.UserVacancyMatch;
import com.tinDev.services.userVacancyMatch.UserVacancyMatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user-vacancy-matches")
public class UserVacancyMatchController {
    @Autowired
    private UserVacancyMatchService userVacancyMatchService;


    @GetMapping("/{id}")
    public ResponseEntity<UserVacancyMatch> getUserVacancyMatchById(@PathVariable Long id) {
        Optional<UserVacancyMatch> match = userVacancyMatchService.findById(id);

        return match.map(m -> ResponseEntity.ok().body(m))
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping
    public List<UserVacancyMatch> finaAllUserVacancyMatches() {
        return userVacancyMatchService.findAll();
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

