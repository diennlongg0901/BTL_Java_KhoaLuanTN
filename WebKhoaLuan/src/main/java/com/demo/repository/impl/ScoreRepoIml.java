/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.repository.impl;

import com.demo.pojo.Detai;
import com.demo.pojo.Diem;
import com.demo.pojo.Hoidong;
import com.demo.pojo.Khoaluan;
import com.demo.pojo.Sinhvien;
import com.demo.pojo.Tieuchi;
import com.demo.repository.ScoreRepo;
import java.util.ArrayList;
import java.util.Date;
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
        CriteriaBuilder b =session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        
//        Root sv = q.from(Sinhvien.class);
//        Root sv2 = q.from(Sinhvien.class);
        Root kl = q.from(Khoaluan.class);
        Root diem = q.from(Diem.class);
        Root dt = q.from(Detai.class);
        
        List<Predicate> predicates = new ArrayList<>();
//        predicates.add(b.equal(sv.get("sinhvienPK.maSV"), kl.get("maSV")));
//        predicates.add(b.equal(sv.get("sinhvienPK.maSV"), kl.get("maSV2")));
//        predicates.add(b.equal(kl.get("maKL"), diem.get("DiemPK.maKL")));
//        predicates.add(b.equal(dt.get("maDT"), kl.get("maDT")));
        
        q.multiselect(kl.get("maKL"), kl.get("maSV2"));
        
        q.where(predicates.toArray(new Predicate[] {}));
        
        if(kw != null)
            predicates.add(b.like(kl.get("nam"), kw));
       
        
        q.groupBy(kl.get("maKL"));
        
        Query query = session.createQuery(q);
        
        return query.getResultList();
    }
}
