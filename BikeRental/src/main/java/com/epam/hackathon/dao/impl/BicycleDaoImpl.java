package com.epam.hackathon.dao.impl;

import com.epam.hackathon.dao.BicycleDao;
import com.epam.hackathon.dao.UserDao;
import com.epam.hackathon.entity.Bicycle;
import com.epam.hackathon.entity.User;
import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import static org.hibernate.criterion.Restrictions.eq;


@Repository
@Transactional
public class BicycleDaoImpl extends GenericDAOImpl<Bicycle, Long> implements BicycleDao {

    @Autowired
    @Override
    public void setSessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

}
