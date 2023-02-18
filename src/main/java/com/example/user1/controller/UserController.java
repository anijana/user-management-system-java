package com.example.user1.controller;

import com.example.user1.model.User;
import com.example.user1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user-app")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/add-user")
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }
    @GetMapping("/get-user/id/{id}")
    public User findUserById(@PathVariable int userId){
        return userService.findById(userId);
    }

    @GetMapping("/get-all-user")
    public List<User> findAllUser(){
        return userService.findAll();
    }
    @PutMapping("/update-user/id/{id}")
    public void updateUser(@PathVariable int userId, @RequestBody User user){
        userService.updateTodo(userId,user);
    }
    @DeleteMapping("/delete-user/id/{id}")
    public void deleteTodo(@PathVariable int userId){
        userService.deleteUser(userId);
    }
}
