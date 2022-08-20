/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.repository.impl;

import com.demo.pojo.Chitiethoidong;
import com.demo.pojo.Hoidong;
import com.demo.repository.CouncilRepo;
import java.util.List;
import javax.persistence.Query;
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
public class CouncilRepoImpl implements CouncilRepo {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public boolean addCouncil(Hoidong council) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(council);
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean addDetailCouncil(Chitiethoidong detailCouncil) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(detailCouncil);
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public Object getNewCouncil() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("FROM Hoidong ORDER BY maHD DESC");
        return q.setMaxResults(1).getSingleResult();
    }

//    @Override
//    public List<Chitiethoidong> getCouncilDetail(int id) {
//        Session session = this.sessionFactory.getObject().getCurrentSession();
//        Query q = session.createQuery("FROM Chitiethoidong WHERE hoidong_maHD (:id)");
//        q.setParameter("id", id);
//        return q.getResultList();
//    }

    @Override
    public List<Chitiethoidong> getListCouncilDetail() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("FROM Chitiethoidong ORDER BY hoidong_maHD ASC");
        return q.getResultList();
    }
}
