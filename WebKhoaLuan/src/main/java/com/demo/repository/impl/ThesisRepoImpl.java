/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.repository.impl;

import com.demo.pojo.Dangkykhoaluan;
import com.demo.pojo.Detai;
import com.demo.pojo.Khoaluan;
import com.demo.repository.ThesisRepo;
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
public class ThesisRepoImpl implements ThesisRepo {
    
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    //ĐỀ TÀI KHÓA LUẬN
    //  Thêm mới đề tài khóa luận
    @Override
    public boolean addTopic(Detai topic) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(topic);
            return true;
        } catch (HibernateException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    //   Lấy danh sách đế tài khóa luận
    @Override
    public List<Detai> getTopics() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("FROM Detai");
        return q.getResultList();
    }

    // Xóa đề tài khóa luận
    @Override
    public boolean deleteTopic(int topicID) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            Query q = session.createQuery("DELETE FROM Detai WHERE maDT = (:topicID)");
            q.setParameter("topicID", topicID);
            q.executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
    }
    
    //KHÓA LUẬN
    //  Thêm mới khóa luận
    @Override
    public boolean addThesis(Khoaluan thesis) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(thesis);
            return true;
        } catch (HibernateException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }
    
    //  Thêm mới đăng ký khóa luận
    @Override
    public boolean addRegistration(Dangkykhoaluan dangkykhoaluan) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(dangkykhoaluan);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    //  Lấy danh sách khóa luận
    @Override
    public List<Khoaluan> getThesis() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("FROM Khoaluan");
        return q.getResultList();
    }

    //  Lấy danh sách đăng ký khóa luận
    @Override
    public List<Dangkykhoaluan> getRegistedThesises() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query query = session.createQuery("FROM Dangkykhoaluan");
        return query.getResultList();
    }

    //  Lấy thông tin đăng khóa luận theo mã đăng ký
    @Override
    public Dangkykhoaluan getRegistedThesisByID(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query query = session.createQuery("FROM Dangkykhoaluan WHERE maDK = (:id)");
        query.setParameter("id", id);
        return (Dangkykhoaluan) query.getSingleResult();
    }

    //  Lấy thông tin khóa luận theo mã sinh viên
    @Override
    public Khoaluan getThesisBySV(String id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query query = session.createQuery("FROM Khoaluan WHERE maSV = (:id)");
        query.setParameter("id", id);
        return (Khoaluan) query.getSingleResult();
    }
    
    //  Lấy danh sách khóa luận theo mã giảng viên hướng dẫn
    @Override
    public List<Khoaluan> getThesisByGV(String idGV) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("FROM Khoaluan WHERE maGV = (:idGV) OR maGV2 = (:idGV)");
        q.setParameter("idGV", idGV);
        return q.getResultList();
    }

    //  Cập nhật thông tin khóa luận
    @Override
    public boolean updateThesis(Khoaluan khoaluan) {
        try{
        Session session = this.sessionFactory.getObject().getCurrentSession();
        session.update(khoaluan);
        return true;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    //  Lấy danh sách khóa luận có chung mã hội đồng 
    @Override
    public List<Khoaluan> getThesisByIDCouncil(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("FROM Khoaluan WHERE maHD = (:id)");
        q.setParameter("id", id);
        return q.getResultList();
    }
    
    //  Lấy thông tin khóa theo mã khóa luận
    @Override
    public Khoaluan getThesisbyID(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("FROM Khoaluan WHERE maKL = (:id)");
        q.setParameter("id", id);
        return (Khoaluan) q.getSingleResult();
    }

    @Override
    public void deleteRegistedThesis(int idTopic) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("DELETE FROM Dangkykhoaluan WHERE maDT = (:idTopic)");
        q.setParameter("idTopic", idTopic);
        q.executeUpdate();
    }
}
