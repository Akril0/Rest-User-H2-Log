package com.example.app.RestUserH2Log.service;

import com.example.app.RestUserH2Log.entity.User;
import com.example.app.RestUserH2Log.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    // Добавим регистратор slf4j, а также операторы отладки.
    // Эти операторы отладки печатаются в консоли.

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    // @Autowired репозиторий EmployeeRepository.
    // Он используется для внедрения зависимостей, поскольку
    // класс репозитория здесь является зависимостью.
    @Autowired
    UserRepository repository;

    public List<User> getAllEmployees() {
        LOGGER.debug("Inside EmployeeService.getAllEmployees() ");
        return new ArrayList<>(repository.findAll());
    }

    public ResponseEntity<User> getUserById(int id) {
        LOGGER.debug("Inside EmployeeService.getEmployeeById(int id) ");
        Optional<User> employee = repository.findById(id);
        return employee.map(value ->
                ResponseEntity.ok().body(value)).orElseGet(() ->
                ResponseEntity.notFound().build());
    }

    public User saveOrUpdate(User user) {
        LOGGER.debug("Inside EmployeeService.saveOrUpdate(Employee employee) saved " +
                user.getName());
        return repository.save(user);
    }

    public void deleteUserById(int id) {
        LOGGER.debug("Inside EmployeeService.deleteEmployeeById(int id) ");
        repository.deleteById(id);
    }
}
