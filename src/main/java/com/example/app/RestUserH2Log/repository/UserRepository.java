package com.example.app.RestUserH2Log.repository;

import com.example.app.RestUserH2Log.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// @Repository — это вариант аннотации @Component,
// которая сообщает Spring, что это компонент,
// которым должен управлять контейнер IoC.
// В частности, репозитории предназначены для определения
// логики для слоя сохраняемости.
//
// Расширение CrudRepository принимает класс сущности,
// а также тип данных id, который он должен использовать
// для запроса.
//
// CrudRepository объявляет методы, которые составляют
// базовую функциональность CRUD репозитория.
// https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    // ВОЗМОЖНО без методов

    List<User> findAll();

    Optional<User> findById(int id);

    // WARNING: Unchecked overriding: return type requires unchecked conversion.
    // Found 'com.example.app.RestEmployeeH2.entity.Employee', required 'S'
//    Employee save(Employee user);
    <S extends User> S save(S user);

    void deleteById(int id);
}
