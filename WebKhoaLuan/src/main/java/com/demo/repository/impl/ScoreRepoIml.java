/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.repository.impl;

import com.demo.pojo.Diem;
import com.demo.pojo.Tieuchi;
import com.demo.repository.ScoreRepo;
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
public class ScoreRepoIml implements ScoreRepo{

    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public Tieuchi getCriteria(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("FROM Tieuchi ");
        q.setParameter("id", id);
        return (Tieuchi) q.setMaxResults(1).getSingleResult();
    }

//    WHERE maTC = (:id)
//    (Tieuchi) q.getSingleResult()
    
    @Override
    public boolean addScore(Diem score) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(score);
            return true;
        } catch (HibernateException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }  

    @Override
    public List<Diem> getScore(int thesisID, int criteriaID) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("FROM Diem WHERE maKL = (:thesisID) AND maTC (:criteriaID) ");
        q.setParameter("thesisID", thesisID);
        q.setParameter("criteriaID", criteriaID);
        return q.getResultList();
    }

    @Override
    public double calculation(double scoreHD, double scoreGVHD) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
