package ru.kata.spring.boot_security.demo.dao;

import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

@Repository
public interface UserDao {


    List<User> findAll();

    User getById(long id);

    User findByUsername(String username);


    void save(User user);

    void update(User user);

    void deleteByUsername(String username);

    void deleteById(Long id);

}
