package com.tinDev.services.user;

import com.tinDev.models.user.User;
import com.tinDev.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, EntityManager entityManager) {
        this.userRepository = userRepository;
        this.entityManager = entityManager;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(int id) {
        return userRepository.findById(id);
    }

    @Override
    @Transactional
    public User save(User user) {
        return userRepository.save(user);
    }

    public User updateUser(int userId, User updatedUser) {
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
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }
}
