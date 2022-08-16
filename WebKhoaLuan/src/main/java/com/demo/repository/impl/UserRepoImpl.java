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
        if (!username.isEmpty())
        {
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
//        try {
            //CÁCH 1 - return true, không xóa dưới db
//            NguoidungPK userPK  = new NguoidungPK();
//            userPK.setMaND(userID);
//            Nguoidung user = new Nguoidung();
//            user.setNguoidungPK(userPK);
//            session.remove(user);

            //CÁCH 2 - return true, không xóa dưới db
//            session.beginTransaction();
//            NguoidungPK userPK  = new NguoidungPK();
//            userPK.setMaND(userID);
//            Nguoidung user = new Nguoidung();
//            user.setNguoidungPK(userPK);
//            session.delete(user);

            //CÁCH 3 - lỗi Unknow entity
//            session.delete(userID, Nguoidung.class);

            //CÁCH 4 - return true, không xóa dưới db
//            Nguoidung user = new Nguoidung();
//            user.setUsername(userID);
//            session.delete(user);

            //CÁCH 5 - return false
//            Nguoidung user = session.load(Nguoidung.class, userID);
//            session.delete(user);

            //CÁCH 6 - return false
            NguoidungPK userPK = session.get(NguoidungPK.class, userID);
            Nguoidung user = session.get(Nguoidung.class, userPK);
            session.delete(user);

            //CÁCH 7 - lỗi Unknow entity            
//            session.delete("delete from Nguoidung user where user.username =: 'GVU004'");
            
            //CÁCH 8
//            Query q = session.createQuery("delete from Nguoidung user where user.username = 'GVU004'");
//            q.executeUpdate();

            //CÁCH 9
//            session.createQuery("delete from Nguoidung user where user.username  =: userID").setString("userID", userID).executeUpdate();
//            return true;
//        } catch (HibernateException e) {
//            System.err.println(e.getMessage());
//        }
        return true;
    }

    @Override
    public List<Giangvien> getAllGV() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("FROM Giangvien");
        return q.getResultList();
    }
}
