package com.epam.hackathon.config;

import com.epam.hackathon.dao.AgreementDao;
import com.epam.hackathon.dao.BicycleDao;
import com.epam.hackathon.dao.UserDao;
import com.epam.hackathon.dao.impl.AgreementDaoImpl;
import com.epam.hackathon.dao.impl.BicycleDaoImpl;
import com.epam.hackathon.dao.impl.UserDaoImpl;
import com.epam.hackathon.entity.User;
import com.epam.hackathon.entity.UserRole;
import com.epam.hackathon.service.AgreementService;
import com.epam.hackathon.service.BicycleService;
import com.epam.hackathon.service.UserService;
import com.epam.hackathon.service.impl.AgreementServiceImpl;
import com.epam.hackathon.service.impl.BicycleServiceImpl;
import com.epam.hackathon.service.impl.UserServiceImpl;
import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.inject.Inject;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class DBConfig {


    @Inject
    private Environment environment;

//    @Value("classpath:schema-userrole.sql")
//    private Resource schemaScript;

    private Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", environment.getProperty("hibernate.dialect"));
        properties.setProperty("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
        properties.setProperty("hibernate.hbm2ddl.auto",
                environment.getProperty("hibernate.hbm2ddl.auto"));
        return properties;
    }

//    @Bean
//    public DataSourceInitializer dataSourceInitializer(final DataSource dataSource) {
//        final DataSourceInitializer initializer = new DataSourceInitializer();
//        initializer.setDataSource(dataSource);
//        initializer.setDatabasePopulator(databasePopulator());
//        return initializer;
//    }

//    private DatabasePopulator databasePopulator() {
//        final ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
//        populator.addScript(schemaScript);
//        return populator;
//    }

    @Autowired
    @Bean(name = "hibernateTemplate")
    @Scope(WebApplicationContext.SCOPE_REQUEST)
    public HibernateTemplate getHibernateTemplate(SessionFactory sessionFactory) {
        return new HibernateTemplate(sessionFactory);
    }


    @Autowired
    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(DataSource dataSource) {
        LocalSessionFactoryBuilder localSessionFactoryBuilder = new LocalSessionFactoryBuilder(
                dataSource);
        localSessionFactoryBuilder.addAnnotatedClasses(new Class[]{User.class, UserRole.class});
        localSessionFactoryBuilder.addProperties(getHibernateProperties());
        localSessionFactoryBuilder.scanPackages("com.epam.hackathon.entity");
        return localSessionFactoryBuilder.buildSessionFactory();
    }

    @Bean(name = "dataSource")
    public DataSource getDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(environment.getProperty("driverClassName"));
        dataSource.setUrl(environment.getProperty("url"));
        dataSource.setUsername(environment.getProperty("username1"));
        dataSource.setPassword(environment.getProperty("password1"));
        return dataSource;
    }

    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver getCommonsMultipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(20971520);   // 20MB
        multipartResolver.setMaxInMemorySize(1048576);  // 1MB
        return multipartResolver;
    }

//    @Autowired
//    @Bean(name = "transactionManager")
////    @Scope(WebApplicationContext.SCOPE_REQUEST)
//    public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
//        HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
//        hibernateTransactionManager.setSessionFactory(sessionFactory);
//        return hibernateTransactionManager;
//    }


    @Bean(name = "userDao")
    public UserDao getUserDao() {
        return new UserDaoImpl();
    }

    @Bean(name = "userService")
    public UserService getUserService() {
        return new UserServiceImpl();
    }

    @Bean(name = "bicycleDao")
    public BicycleDao getBicycleDao() {
        return new BicycleDaoImpl();
    }

    @Bean(name = "bicycleService")
    public BicycleService getBicycleService() {
        return new BicycleServiceImpl();
    }

    @Bean(name = "agreementDao")
    public AgreementDao getAgreementDao() {
        return new AgreementDaoImpl();
    }

    @Bean(name = "agreementService")
    public AgreementService getAgreementService() {
        return new AgreementServiceImpl();
    }


}


