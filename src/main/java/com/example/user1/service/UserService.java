package com.example.user1.service;

import com.example.user1.model.User;
import com.example.user1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;


    public List<User> findAll(){
        return userRepository.findAll();
    }
    public User findById(int userId){
        return userRepository.findById(userId).get();
    }

    public void addUser(User user){
        userRepository.save(user);
    }

    public void deleteUser(int userId){
        userRepository.deleteById(userId);
    }
    public void updateTodo(int userId, User newUser){
        User user = userRepository.findById(userId).get();
        user.setUserId(newUser.getUserId());
        user.setUserName(newUser.getUserName());
        user.setDateOfBirth(newUser.getDateOfBirth());
        user.setEmail(newUser.getEmail());
        user.setPhoneNumber(newUser.getPhoneNumber());
        user.setDate(newUser.getDate());
        user.setTime(newUser.getTime());

        userRepository.save(user);
    }


}
