package com.kata_3_1_2.PP.service;

import com.kata_3_1_2.PP.dao.UserDao;
import com.kata_3_1_2.PP.entitys.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final RoleService roleService;

    private final UserDao userDao;

    public UserServiceImpl(RoleService roleService, UserDao userDao) {
        this.roleService = roleService;
        this.userDao = userDao;
    }

    @Override
    public void addUser(User user, String[] roles) {
        user.setRoles(roleService.getByName(roles));
        userDao.addUser(user);
    }

    @Override
    public void removeUser(Long id) {
        userDao.removeUser(id);
    }

    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    @Override
    public void updateUser(User user, String[] roles) {
        user.setRoles(roleService.getByName(roles));
        userDao.addUser(user);
    }

    @Override
    public User getByName(String name) {
        return userDao.getByName(name);
    }

}
