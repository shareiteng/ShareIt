package com.transcan.backendtranscan.services;

import com.transcan.backendtranscan.domain.UserInfo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public abstract class UserInfoServiceimp implements UserInfoService{
    @Override
    public List<UserInfo> findByUsername(String username) {

        List<UserInfo> theStudents=null;
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(UserInfo.class)
                .buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

        try {

            // start a transaction
            session.beginTransaction();
             theStudents = session.createQuery("from user_info u where u.email="+username+"").getResultList();



        }
        finally {
            factory.close();
        }
        return theStudents;
    }
}
