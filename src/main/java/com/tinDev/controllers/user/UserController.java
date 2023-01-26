package com.tinDev.controllers.user;

import com.tinDev.convertrs.user.UserDtoModelConverter;
import com.tinDev.models.user.User;
import com.tinDev.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserDtoModelConverter userDtoModelConverter;


    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable int id) {
        Optional<User> user = userService.findById(id);
        return user.map(c -> ResponseEntity.ok().body(c))
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping
    public List<User> findAllUsers() {
        return userService.findAll();
    }
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.save(user);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        userService.deleteById(id);
    }
}