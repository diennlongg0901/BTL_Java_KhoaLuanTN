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

    //THÊM HỘI ĐỒNG
    //  Thêm vào bảng hội đồng
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

    //  Thêm vào bảng chi tiết hội đồng
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

    //LẤY THÔNG TIN HỘI ĐỒNG
    //  Lấy thông tin hội đồng mới thêm vào
    @Override
    public Object getNewCouncil() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("FROM Hoidong ORDER BY maHD DESC");
        return q.setMaxResults(1).getSingleResult();
    }

    //  Tìm thông tin chi tiết hội đồng
    @Override
    public List<Chitiethoidong> getCouncilDetail(String tenHD) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("FROM Chitiethoidong WHERE tenHD = (:tenHD)");
        q.setParameter("tenHD", tenHD);
        return q.getResultList();
    }

    //  Lấy danh sách thông tin chi tiết hội đồng
    @Override
    public List<Chitiethoidong> getListCouncilDetail() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("FROM Chitiethoidong ORDER BY maHD DESC");
        return q.getResultList();
    }
    
    //  Lấy danh sách các hội đồng
    @Override
    public List<Hoidong> getCouncils() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("FROM Hoidong ORDER BY maHD DESC");
        return q.getResultList();
    }

    //  Lấy thông tin chi tiết hội đồng theo giảng viên
    @Override
    public List<Chitiethoidong> getCouncilByGV(String idGV) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("FROM Chitiethoidong WHERE maGV = (:idGV) ORDER BY maHD DESC");
        q.setParameter("idGV", idGV);
        return q.getResultList();
    }

    //  Đếm thành viên một hội đồng
    @Override
    public Integer countMember(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        int total = 0;
        Query q = session.createQuery("FROM Chitiethoidong WHERE maHD = (:id)");
        q.setParameter("id", id);
        total = q.getResultList().size();
        return total;
    }

    //XÓA HỘI ĐỒNG, THÀNH VIÊN HỘI ĐỒNG
    //  Xóa thành viên hội đồng
    @Override
    public void deleteMember(String userID) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("DELETE FROM Chitiethoidong WHERE maGV = (:userID) AND maND = (:userID) AND maCV = 'ROLE_GV'");
        q.setParameter("userID", userID);
        q.executeUpdate();
    }

    //  Lấy thông tin hội đồng theo mã hội đồng
    @Override
    public Hoidong getCouncil(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("FROM Hoidong WHERE maHD = (:id)");
        q.setParameter("id", id);
        return (Hoidong) q.getSingleResult();
    }

    //  Khóa hội đồng theo mã hội đồng
    @Override
    public void blockCouncil(int id) {
         Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("UPDATE Hoidong SET hoatDong = 0 WHERE maHD = (:id)");
        q.setParameter("id", id);
        q.executeUpdate();
    }
}
