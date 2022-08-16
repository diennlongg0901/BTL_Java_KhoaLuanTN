/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.repository.impl;

import com.demo.pojo.Chitiethoidong;
import com.demo.pojo.Hoidong;
import com.demo.repository.CouncilRepo;
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
