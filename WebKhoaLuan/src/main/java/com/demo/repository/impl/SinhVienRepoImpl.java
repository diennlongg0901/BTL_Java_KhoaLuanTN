/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.repository.impl;

import com.demo.pojo.Sinhvien;
import com.demo.repository.SinhVienRepo;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author PC
 */
@Repository
@Transactional
public class SinhVienRepoImpl implements SinhVienRepo{
    @Autowired
    private LocalSessionFactoryBean s;
    
    @Override
    public List<Sinhvien> getSinhvien(String kw) {
        Session session = this.s.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Sinhvien> query = builder.createQuery(Sinhvien.class);
        Root root = query.from(Sinhvien.class);
        query =query.select(root);
        
        if (!kw.isEmpty())
        {
            Predicate p = builder.equal(root.get("nameSV").as(String.class), kw.trim());
            query = query.where(p);
        }
        
        Query q = session.createQuery(query);
        return q.getResultList();
    }
    
}
