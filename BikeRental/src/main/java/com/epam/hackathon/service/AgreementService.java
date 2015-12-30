package com.epam.hackathon.service;

import com.epam.hackathon.entity.Agreement;
import com.epam.hackathon.entity.Bicycle;

import java.util.List;

public interface AgreementService {

    void add(Agreement agreement);

    void update(Agreement agreement);

    void delete(Agreement agreement);

    Agreement findAgreementById(Long id);

    List<Agreement> getAllAgreements();

}
