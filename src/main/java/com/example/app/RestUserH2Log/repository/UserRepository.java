package com.example.app.RestUserH2Log.repository;

import com.example.app.RestUserH2Log.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    List<User> findAll();

    Optional<User> findById(int id);


    <S extends User> S save(S user);

    void deleteById(int id);
}
