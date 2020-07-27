package com.example.test2.service;

import com.example.test2.dto.UserDto;
import com.example.test2.model.User;
import com.example.test2.repository.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDate;
import java.util.List;

@Service
@Data
public class UserService {
    @Autowired
    private final UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUserEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User getUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    public User saveNewUser(UserDto user) {
        User newUser = new User();
        newUser.setEmail (user.getEmail());
        newUser.setPassword(user.getPassword());
        newUser.setAdress(user.getAddress());
        newUser.setCreationDate(LocalDate.now());
        return userRepository.save(newUser);
    }

    public User updateUser(Integer id, UserDto updateUser) {
        User user = userRepository.findById(id)
                .orElseThrow(()->
                        new EntityNotFoundException("User not found in DB"));
        user.setEmail (updateUser.getEmail());
        user.setPassword(updateUser.getPassword());
        user.setAdress(updateUser.getAddress());
        return userRepository.save(user);
    }

    public void deleteUser (Integer id) {

        userRepository.deleteById(id);
    }
}
