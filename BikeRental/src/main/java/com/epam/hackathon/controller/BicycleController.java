package com.epam.hackathon.controller;

import com.epam.hackathon.entity.Bicycle;
import com.epam.hackathon.entity.BicycleList;
import com.epam.hackathon.entity.User;
import com.epam.hackathon.entity.UserRole;
import com.epam.hackathon.service.BicycleService;
import com.epam.hackathon.service.UserService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;


@RestController
@RequestMapping("/bicycle")
public class BicycleController {

    @Autowired
    BicycleService bicycleService;

    @Autowired
    UserService userService;

    @RequestMapping("/getAll")
    public BicycleList getAll() {
        BicycleList bicycles = new BicycleList();
        bicycles.addAll(bicycleService.getAllBicycles());
        return bicycles;
    }

    @RequestMapping("/get")
    public Bicycle get(@RequestParam(value = "id") Long id) {
        return bicycleService.findBicycleById(id);
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Bicycle addUser(@RequestParam(value = "type") String type,
                           @RequestParam(value = "name") String name,
                           @RequestParam(value = "price") Long price,
                           @RequestParam(value = "user_id") Long userId,
                           @RequestParam(value = "x") Float x,
                           @RequestParam(value = "y") Float y,
                           @RequestParam(value = "image") String image) {
        Bicycle bicycle = new Bicycle();
        bicycle.setName(name);
        bicycle.setPrice(price);
        bicycle.setType(type);
        bicycle.setX(x);
        bicycle.setY(y);
        bicycle.setImage(image);
        bicycle.setUser(userService.findUserById(userId));


        bicycleService.add(bicycle);
        System.out.println("Bicycle added");
        return bicycle;
    }

    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public Boolean addUser(@RequestParam(value = "bicycle_id") Long id) {
        Bicycle b = bicycleService.findBicycleById(id);
        bicycleService.delete(bicycleService.findBicycleById(id));
        return bicycleService.findBicycleById(id) == null;
    }
}
