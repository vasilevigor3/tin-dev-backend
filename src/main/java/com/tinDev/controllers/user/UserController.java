package com.tinDev.controllers.user;

import com.tinDev.convertrs.user.UserDtoModelConverter;
import com.tinDev.models.user.User;
import com.tinDev.models.user.dto.UserDto;
import com.tinDev.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private UserService userService;
    @Autowired private UserDtoModelConverter userDtoModelConverter;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public UserDto findById(@PathVariable int id) {
        Optional<User> byId = userService.findById(id);
        User user = byId.get();

        return userDtoModelConverter.convertToEntity(user);
    }

    @PostMapping
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        userService.deleteById(id);
    }
}