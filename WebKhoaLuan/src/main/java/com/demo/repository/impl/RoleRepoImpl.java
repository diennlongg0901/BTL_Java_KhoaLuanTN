/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.repository.impl;

import com.demo.pojo.Chucvu;
import com.demo.pojo.Khoa;
import com.demo.pojo.Nganh;
import com.demo.repository.RoleRepo;
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
public class RoleRepoImpl implements RoleRepo{
    @Autowired
    private LocalSessionFactoryBean sessionFactoryBean;

    //  Lấy danh sách chức vụ
    @Override
    public List<Chucvu> getChucvu() {
        Session s = this.sessionFactoryBean.getObject().getCurrentSession();
        Query q = s.createQuery("FROM Chucvu");
        return q.getResultList();
    }

    //  Lấy danh sách ngành
    @Override
    public List<Nganh> getNganh() {
        Session s = this.sessionFactoryBean.getObject().getCurrentSession();
        Query q = s.createQuery("FROM Nganh");
        return q.getResultList();
    }

    //  Lấy danh sách khoa
    @Override
    public List<Khoa> getKhoa() {
        Session s = this.sessionFactoryBean.getObject().getCurrentSession();
        Query q = s.createQuery("FROM Khoa");
        return q.getResultList();
    }
    
    
}
