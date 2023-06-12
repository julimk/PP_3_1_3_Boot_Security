package ru.kata.spring.boot_security.demo.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import ru.kata.spring.boot_security.demo.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {



    @PersistenceContext
    private EntityManager em;


    @Override
    public User findByUsername(String username) {
        return em.createQuery("select u FROM User u JOIn fETCH u.roles WHERe u.username = :id", User.class)
                .setParameter("id", username)
                .getResultList().stream().findAny().orElse(null);
    }

    @Override
    public  void deleteById(Long id) {
        User us = em.find(User.class, id);
        em.remove(us);
    }

    @Override
    public void update(User user) {
        em.merge(user);
    }

    @Override
    public void deleteByUsername(String username) {
        User user = findByUsername(username);
        em.remove(user);
    }

    @Override
    public void save(User user) {
        em.persist(user);
    }

    @Override
    public List<User> findAll() {
        return em.createQuery("select s from User s", User.class).getResultList();
    }

    @Override
    public User getById(long id){
        return em.find(User.class, id);
    }

}
