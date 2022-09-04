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

    //TIÊU CHÍ CHẤM ĐIỂM
    //  Lấy danh sách tiêu chí chấm điểm
    @Override
    public Tieuchi getCriteria(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("FROM Tieuchi ");
        q.setParameter("id", id);
        return (Tieuchi) q.setMaxResults(1).getSingleResult();
    }

    //THÊM ĐIỂM KHÓA LUẬN
    //   Thêm điểm khóa luận
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
    
    //  Thêm điểm tổng kết khóa luận
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

    //LẤY ĐIỂM KHÓA LUẬN
    //  Lấy danh sách điểm theo mã khóa luận, mã tiêu chí
    @Override
    public List<Diem> getScore(int thesisID, int criteriaID) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("FROM Diem WHERE maKL = (:thesisID) AND maTC = (:criteriaID) ");
        q.setParameter("thesisID", thesisID);
        q.setParameter("criteriaID", criteriaID);
        return q.getResultList();
    }

    //  Lấy điểm khóa luận theo mã khóa luận
    @Override
    public List<Diem> getThesisScores(int thesisID) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("FROM Diem WHERE maKL = (:thesisID)");
        q.setParameter("thesisID", thesisID);
        return q.getResultList();
    }
    
    //  Lấy tất điểm theo mã khóa luận
    @Override
    public List<Diem> getAllScore(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("FROM Diem WHERE maKL = (:id)");
        q.setParameter("id", id);
        return q.getResultList();
    }
    
    //  Lấy kết quả khóa luận theo mã sinh viên
    @Override
    public boolean getResult(String id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("FROM Tongketkhoaluan WHERE maSV = (:id)");
        q.setParameter("id", id);
        if (q.getResultList().size() > 0) {
            return false;
        } else {
            return true;
        }
    }

    //THỐNG KÊ ĐIỂM
    //  Thống kê điểm khóa luận theo năm
    @Override
    public List<Object> scoreStats(String kw) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
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

    //  Thống kê tần suất sinh viên làm khóa luận theo ngành
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
    public Tongketkhoaluan getResultScore(String id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("FROM Tongketkhoaluan WHERE maSV = (:id)");
        q.setParameter("id", id);
        return (Tongketkhoaluan) q.setMaxResults(1).getSingleResult();
    }
}
