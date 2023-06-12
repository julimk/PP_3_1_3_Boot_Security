package ru.kata.spring.boot_security.demo.dao;


import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.Role;

import java.util.List;
import java.util.NoSuchElementException;

@Repository
public interface RoleDao {

    List<Role> findAll();

    Role findByName(String name) throws NoSuchElementException;

    Role getById(Long id);

    void save(Role role);
}
