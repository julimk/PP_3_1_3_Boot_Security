package ru.kata.spring.boot_security.demo.dao;

import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.NoSuchElementException;

@Repository
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Role> findAll() {
        return entityManager.createQuery("SELECT r FROM Role r", Role.class).getResultList();

    }

    @Override
    public Role findByName(String name) throws NoSuchElementException {
        return entityManager.createQuery("SELECT role FROM Role role WHERE role.name = :name", Role.class)
                .setParameter("name", name)
                .getSingleResult();
    }

    @Override
    public Role getById(Long id) {
        return entityManager.createQuery("SELECT role FROM Role role WHERE role.id = :id", Role.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public void save(Role role) {
        entityManager.persist(role);
    }
}
