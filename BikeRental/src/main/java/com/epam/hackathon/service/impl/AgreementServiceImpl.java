package com.epam.hackathon.service.impl;

import com.epam.hackathon.dao.AgreementDao;
import com.epam.hackathon.dao.BicycleDao;
import com.epam.hackathon.entity.Agreement;
import com.epam.hackathon.entity.Bicycle;
import com.epam.hackathon.service.AgreementService;
import com.epam.hackathon.service.BicycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AgreementServiceImpl implements AgreementService {

    @Autowired
    private AgreementDao agreementDao;

    @Override
    public void add(Agreement agreement) {
        agreementDao.save(agreement);
    }

    @Override
    public void update(Agreement agreement) {
        agreementDao.save(agreement);
    }

    @Override
    public void delete(Agreement agreement) {
        agreementDao.remove(agreement);
    }

    @Override
    public Agreement findAgreementById(Long id) {
        return agreementDao.find(id);
    }

    @Override
    public List<Agreement> getAllAgreements() {
        return agreementDao.findAll();
    }
}
