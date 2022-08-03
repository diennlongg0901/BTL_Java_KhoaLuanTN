/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.repository.impl;

import com.demo.pojo.Quantri;
import com.demo.repository.UserRepo;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author PC
 */
@Repository
@Transactional
public class UserRepoImpl implements UserRepo {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Quantri> getUsersQT(String username) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery<Quantri> query = builder.createQuery(Quantri.class);
        Root r = query.from(Quantri.class);
        query = query.select(r);
        if (!username.isEmpty())
        {
            Predicate p = (Predicate) builder.equal(r.get("usernamQT").as(String.class), username.trim());
            query = query.where(p);
        }
        
        Query q = s.createQuery(query);
        return q.getResultList();
    }
}
