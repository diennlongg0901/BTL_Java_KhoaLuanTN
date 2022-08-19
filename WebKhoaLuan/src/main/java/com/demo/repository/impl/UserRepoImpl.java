/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.repository.impl;

import com.demo.pojo.Giangvien;
import com.demo.pojo.Giaovu;
import com.demo.pojo.Nguoidung;
import com.demo.pojo.NguoidungPK;
import com.demo.pojo.Quantri;
import com.demo.pojo.Sinhvien;
import com.demo.repository.UserRepo;
import java.util.List;
import javax.persistence.Entity;

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
 * @author PC
 */
@Repository
@Transactional
public class UserRepoImpl implements UserRepo {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Nguoidung> getUsers(String username) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery<Nguoidung> query = builder.createQuery(Nguoidung.class);
        Root r = query.from(Nguoidung.class);
        query = query.select(r);
        if (!username.isEmpty()) {
            Predicate p = builder.equal(r.get("username").as(String.class), username.trim());
            query = query.where(p);
        }

        Query q = s.createQuery(query);
        return q.getResultList();
    }

    @Override
    public boolean addUser(Nguoidung user) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(user);
            return true;
        } catch (HibernateException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public List<Nguoidung> getAllUsers() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Nguoidung> query = builder.createQuery(Nguoidung.class);
        Root r = query.from(Nguoidung.class);
        query = query.select(r);
        Query q = session.createQuery(query);
        return q.getResultList();
    }

    @Override
    public boolean addUserQT(Quantri userQT) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(userQT);
            return true;
        } catch (HibernateException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean addUserSV(Sinhvien userSV) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(userSV);
            return true;
        } catch (HibernateException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean addUserGV(Giangvien userGV) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(userGV);
            return true;
        } catch (HibernateException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean addUserGVU(Giaovu userGVU) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(userGVU);
            return true;
        } catch (HibernateException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean deleteUsers(String userID) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        NguoidungPK pk = new NguoidungPK();
        pk.setMaND(userID);
        Nguoidung p = (Nguoidung) session.load(Nguoidung.class, pk.getMaND());
        if (null != p) {
            session.delete(p);
            return true;
        }
        return false;
    }

    @Override
    public List<Giangvien> getAllGV() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("FROM Giangvien");
        return q.getResultList();
    }

    @Override
    public void updateUsers(Nguoidung user) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        session.update(user);
    }

    @Override
    public Nguoidung getNguoidungbyID(String id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Nguoidung.class, id);
        
    }

    
}
