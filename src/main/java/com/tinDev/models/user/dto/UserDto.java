package com.tinDev.models.user.dto;

import com.tinDev.models.userVacancyMatch.UserVacancyMatch;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {
    private Long userId;
    private List<UserVacancyMatch> matches;
}
