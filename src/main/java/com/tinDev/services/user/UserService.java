package com.tinDev.services.user;

import com.tinDev.models.user.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> findById(Long id);
    List<User> findAll();
    User save(User user);
    void deleteById(long id);
}
