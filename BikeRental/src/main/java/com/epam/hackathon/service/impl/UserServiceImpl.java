package com.epam.hackathon.service.impl;

import com.epam.hackathon.dao.UserDao;
import com.epam.hackathon.entity.RoleEnum;
import com.epam.hackathon.entity.User;
import com.epam.hackathon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void add(User user) {
        userDao.save(user);
    }

    @Override
    public User login(String email, String password) {
        User res = userDao.findByEmail(email);
        if (res == null) {
            return null;
        }
        if (res.getPassword().equals(password) && res.getRole().getId() == RoleEnum.USER.getRoleId()) {
            return res;
        }
        return null;
    }

    @Override
    public void update(User user) {
        userDao.save(user);
    }

    @Override
    public void delete(User user) {
        userDao.remove(user);
    }

    @Override
    public User findUserById(Long id) {
        return userDao.find(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    @Override
    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public Boolean authenticate(String email, String password) {
        return userDao.authenticate(email, password);
    }
}
