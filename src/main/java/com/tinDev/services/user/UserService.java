package com.tinDev.services.user;

import com.tinDev.models.user.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();
    Optional<User> findById(int id);
    User save(User user);
    void deleteById(int id);
}
