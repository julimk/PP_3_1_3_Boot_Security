package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.dao.UserDao;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    private final UserDao userDao;

    private final PasswordEncoder encoder;

    @Autowired
    public UserServiceImp(UserDao userDao, PasswordEncoder encoder) {
        this.userDao = userDao;
        this.encoder = encoder;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAll() {
        return userDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public User getById(long id) {
        return userDao.getById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    @Transactional
    public void save(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        userDao.save(user);
    }

    @Override
    @Transactional
    public void deleteUserByUsername(String username) {
        userDao.deleteByUsername(username);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        userDao.deleteById(id);
    }


    @Override
    @Transactional
    public void update(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        userDao.update(user);
    }

}
