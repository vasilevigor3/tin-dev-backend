package com.tinDev.services.user;

import com.tinDev.models.user.User;
import com.tinDev.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    @Transactional
    public User save(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long userId, User updatedUser) {
        User user = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("User not found"));

        user.setUserName(updatedUser.getUserName());
        user.setUserLastName(updatedUser.getUserLastName());
        user.setUserContacts(updatedUser.getUserContacts());
        user.setWorkType(updatedUser.getWorkType());
        user.setSalaryExpectations(updatedUser.getSalaryExpectations());
        user.setExperience(updatedUser.getExperience());
        user.setLanguages(updatedUser.getLanguages());
        user.setPositions(updatedUser.getPositions());
        user.setTechStack(updatedUser.getTechStack());
        return userRepository.save(user);
    }

    @Override
    public void deleteById(long id) {
        userRepository.deleteById(id);
    }
}
