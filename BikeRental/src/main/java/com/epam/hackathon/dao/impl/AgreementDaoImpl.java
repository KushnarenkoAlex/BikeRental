package com.epam.hackathon.dao.impl;

import com.epam.hackathon.dao.AgreementDao;
import com.epam.hackathon.dao.BicycleDao;
import com.epam.hackathon.entity.Agreement;
import com.epam.hackathon.entity.Bicycle;
import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class AgreementDaoImpl extends GenericDAOImpl<Agreement, Long> implements AgreementDao {

    @Autowired
    @Override
    public void setSessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

}
