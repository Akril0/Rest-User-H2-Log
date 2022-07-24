package com.example.app.RestUserH2Log.controllers;

import com.example.app.RestUserH2Log.entity.User;
import com.example.app.RestUserH2Log.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/users")
public class UserController {
    

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);


    @Autowired
    UserService service;


    @GetMapping
    public List<User> getAllUsers() {
        LOGGER.debug("Inside UserController.getAllUsers() ");
        return service.getAllEmployees();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") int id) {
        LOGGER.debug("Inside UserController.getUser(int id) ");
        return service.getUserById(id);
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        LOGGER.debug("Inside UserController.addUser(User user) added " +
               user.getName());
        return service.saveOrUpdate(user);
    }

    @PutMapping
    public User updateUser(@RequestBody User user) {
        LOGGER.debug("Inside UserController.updateUser(User user) updated " +
                user.getName());
        return service.saveOrUpdate(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") int id) {
        LOGGER.debug("Inside UserController.deleteUser(int id) ");
        service.deleteUserById(id);
    }
}
