package com.epam.hackathon.controller;

import com.epam.hackathon.entity.Agreement;
import com.epam.hackathon.entity.Bicycle;
import com.epam.hackathon.entity.BicycleList;
import com.epam.hackathon.service.AgreementService;
import com.epam.hackathon.service.BicycleService;
import com.epam.hackathon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;


@RestController
@RequestMapping("/agreement")
public class AgreementController {

    @Autowired
    AgreementService agreementService;
    @Autowired
    BicycleService bicycleService;
    @Autowired
    UserService userService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Agreement addUser(@RequestParam(value = "bikeId") Long bikeId,
                             @RequestParam(value = "fromDate") Date fromDate,
                             @RequestParam(value = "toDate") Date toDate,
                             @RequestParam(value = "userId") Long userId) {

        Agreement agreement = new Agreement();
        agreement.setBicycle(bicycleService.findBicycleById(bikeId));
        agreement.setFromDate(fromDate);
        agreement.setToDate(toDate);
        agreement.setUser(userService.findUserById(userId));


        agreementService.add(agreement);
        System.out.println("agreement added");
        return agreement;
    }
}
