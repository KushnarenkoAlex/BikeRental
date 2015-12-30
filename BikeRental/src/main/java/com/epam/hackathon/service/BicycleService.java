package com.epam.hackathon.service;

import com.epam.hackathon.entity.Bicycle;
import com.epam.hackathon.entity.User;

import java.util.List;

public interface BicycleService {

    void add(Bicycle bicycle);

    void update(Bicycle user);

    void delete(Bicycle user);

    Bicycle findBicycleById(Long id);

    List<Bicycle> getAllBicycles();

}
