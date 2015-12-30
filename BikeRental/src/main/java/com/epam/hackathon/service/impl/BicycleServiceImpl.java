package com.epam.hackathon.service.impl;

import com.epam.hackathon.dao.BicycleDao;
import com.epam.hackathon.dao.UserDao;
import com.epam.hackathon.entity.Bicycle;
import com.epam.hackathon.entity.RoleEnum;
import com.epam.hackathon.entity.User;
import com.epam.hackathon.service.BicycleService;
import com.epam.hackathon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BicycleServiceImpl implements BicycleService {

    @Autowired
    private BicycleDao bicycleDao;

    @Override
    public void add(Bicycle bicycle) {
        System.out.println("Service bicycle adding");
        bicycleDao.save(bicycle);
    }

    @Override
    public void update(Bicycle bicycle) {
        bicycleDao.save(bicycle);
    }

    @Override
    public void delete(Bicycle bicycle) {
        bicycleDao.remove(bicycle);
    }

    @Override
    public Bicycle findBicycleById(Long id) {
        return bicycleDao.find(id);
    }

    @Override
    public List<Bicycle> getAllBicycles() {
        return bicycleDao.findAll();
    }
}
