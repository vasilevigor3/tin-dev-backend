package com.tinDev.models.user.dto;

import com.tinDev.models.userVacancyMatch.UserVacancyMatch;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {
    private int userId;
    private Set<UserVacancyMatch> matches;
}
