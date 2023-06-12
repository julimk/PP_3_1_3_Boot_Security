package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.dao.RoleDao;
import ru.kata.spring.boot_security.demo.model.Role;

import java.util.List;

@Service
public class RoleServiceImp implements RoleService {

    private final RoleDao roleDao;

    @Autowired
    public RoleServiceImp(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Role> getAllRoles() {
        return roleDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Role getRole(String userRole) {
        return roleDao.findByName(userRole);
    }

    @Override
    @Transactional(readOnly = true)
    public Role getRoleById(Long id) {
        return roleDao.getById(id);
    }

    @Override
    @Transactional
    public void addRole(Role role) {
        roleDao.save(role);
    }

}
