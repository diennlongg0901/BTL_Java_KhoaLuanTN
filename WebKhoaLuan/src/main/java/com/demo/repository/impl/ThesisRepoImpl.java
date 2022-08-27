/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.repository.impl;

import com.demo.pojo.Dangkykhoaluan;
import com.demo.pojo.Detai;
import com.demo.pojo.Khoaluan;
import com.demo.repository.ThesisRepo;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ADMIN
 */
@Repository
@Transactional
public class ThesisRepoImpl implements ThesisRepo {
    
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    //ĐỀ TÀI KHÓA LUẬN
    @Override
    public boolean addTopic(Detai topic) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(topic);
            return true;
        } catch (HibernateException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public List<Detai> getTopics() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("FROM Detai");
        return q.getResultList();
    }

    @Override
    public boolean deleteTopic(int topicID) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            Query q = session.createQuery("DELETE FROM Detai WHERE maDT = (:topicID)");
            q.setParameter("topicID", topicID);
            q.executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
    }
    
    //KHÓA LUẬN
    @Override
    public boolean addThesis(Khoaluan thesis) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(thesis);
            return true;
        } catch (HibernateException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public List<Khoaluan> getThesis() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("FROM Khoaluan");
        return q.getResultList();
    }

    @Override
    public boolean addDK_thesis(Dangkykhoaluan dangkykhoaluan) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(dangkykhoaluan);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Dangkykhoaluan> getDangkykhoaluans() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query query = session.createQuery("FROM dangkykhoaluan");
        return query.getResultList();
    }
}
