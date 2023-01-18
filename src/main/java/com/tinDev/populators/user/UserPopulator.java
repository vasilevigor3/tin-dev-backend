package com.tinDev.populators.user;

import com.tinDev.models.user.User;
import com.tinDev.models.user.dto.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserPopulator {
    @Autowired
    private ModelMapper modelMapper;

    public UserDto populate(final User user) {
        final UserDto userDto = modelMapper.map(user, UserDto.class);
//        final Set<Vacancy> vacancies = user.getVacancies();

//        userDto.setPendingVacancies(getVacanciesByStatus(vacancies,VacancyEnumStatus.PENDING));
//        userDto.setAcceptedVacancies(getVacanciesByStatus(vacancies,VacancyEnumStatus.ACCEPTED));
//        userDto.setRejectedVacancies(getVacanciesByStatus(vacancies,VacancyEnumStatus.REJECTED));
//        userDto.setInterviewVacancies(getVacanciesByStatus(vacancies,VacancyEnumStatus.INTERVIEW));
//        userDto.setTestAssignmentVacancies(getVacanciesByStatus(vacancies,VacancyEnumStatus.TEST_ASSIGNMENT));
        return userDto;
    }

//    private Set<Vacancy> getVacanciesByStatus(final Set<Vacancy> vacancies,
//                                               final VacancyEnumStatus vacancyEnumStatus) {
//        return vacancies.stream()
//                .filter(it -> it.getVacancyStatus()..getVacancyEnumStatus()
//                        .equals(vacancyEnumStatus))
//                .collect(Collectors.toSet());
//    }
}
