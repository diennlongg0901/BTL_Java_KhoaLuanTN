/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.repository.impl;

import com.demo.pojo.Diem;
import com.demo.pojo.Tieuchi;
import com.demo.pojo.Tongketkhoaluan;
import com.demo.repository.ScoreRepo;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
public class ScoreRepoIml implements ScoreRepo {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public Tieuchi getCriteria(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("FROM Tieuchi ");
        q.setParameter("id", id);
        return (Tieuchi) q.setMaxResults(1).getSingleResult();
    }

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
        Query q = session.createQuery("FROM Diem WHERE maKL = (:thesisID) AND maTC = (:criteriaID) ");
        q.setParameter("thesisID", thesisID);
        q.setParameter("criteriaID", criteriaID);
        return q.getResultList();
    }

    @Override
    public double calculation(double scoreHD, double scoreGVHD) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Diem> getThesisScores(int thesisID) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("FROM Diem WHERE maKL = (:thesisID)");
        q.setParameter("thesisID", thesisID);
        return q.getResultList();
    }

    @Override
    public List<Object> scoreStats(String kw) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

//        Root kl = q.from(Khoaluan.class);
//        Root dkkl = q.from(Dangkykhoaluan.class);
//        Root diem = q.from(Diem.class);
//        Root dt = q.from(Detai.class);
        Root tkkl = q.from(Tongketkhoaluan.class);

        List<Predicate> predicates = new ArrayList<>();

        q.multiselect(tkkl.get("ketQua"), b.countDistinct(tkkl.get("maKQ")));

        if (kw != null && !kw.isEmpty()) {
            predicates.add(b.like(tkkl.get("nam"), String.format("%%%s%%", kw)));
        }

        q.where(predicates.toArray(new Predicate[]{}));

        q.groupBy(tkkl.get("ketQua"));

        Query query = session.createQuery(q);

        return query.getResultList();
    }

    @Override
    public boolean addResult(Tongketkhoaluan result) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(result);
            return true;
        } catch (HibernateException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public List<Object> svStats(String kw) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        
        Root tkkl = q.from(Tongketkhoaluan.class);
        
        List<Predicate> predicates = new ArrayList<>();
        
        
        
        q.multiselect(tkkl.get("maKhoa"),b.countDistinct(tkkl.get("maSV")));
        
        if (kw != null && !kw.isEmpty()) {
            predicates.add(b.like(tkkl.get("maKhoa"), String.format("%%%s%%", kw)));
        }

        q.where(predicates.toArray(new Predicate[]{}));

        q.groupBy(tkkl.get("maKhoa"));

        Query query = session.createQuery(q);

        return query.getResultList();
        
    }

    @Override
    public List<Diem> getAllScore(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("FROM Diem WHERE maKL = (:id)");
        q.setParameter("id", id);
        return q.getResultList();
    }

    @Override
    public Tongketkhoaluan getResult(String id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("FROM Tongketkhoaluan WHERE maSV = (:id)");
        q.setParameter("id", id);
        return (Tongketkhoaluan) q.setMaxResults(1).getSingleResult();
    }
}
