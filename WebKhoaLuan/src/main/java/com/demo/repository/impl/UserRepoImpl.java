/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.repository.impl;

import com.demo.pojo.Giangvien;
import com.demo.pojo.Giaovu;
import com.demo.pojo.Nguoidung;
import com.demo.pojo.Quantri;
import com.demo.pojo.Sinhvien;
import com.demo.repository.UserRepo;
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
 * @author PC
 */
@Repository
@Transactional
public class UserRepoImpl implements UserRepo {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    //LẤY DANH SÁCH NGƯỜI DÙNG
    //  Lấy danh sách tài khoản người dùng
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
    
    //  Lấy tài khoản ngời dùng theo username
    @Override
    public Nguoidung getUserbyID(String id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("FROM Nguoidung WHERE username = (:id)");
        q.setParameter("id", id);
        return (Nguoidung) q.setMaxResults(1).getSingleResult();
    }
    
    //  Lấy tài khoản ngời dùng theo username
    @Override
    public Sinhvien getSVbyID(String id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("FROM Sinhvien WHERE maSV = (:id)");
        q.setParameter("id", id);
        return (Sinhvien) q.setMaxResults(1).getSingleResult();
    }
    
    // Lấy danh sách tất cả tài khoản người dùng
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
    
    // Lấy danh sách tài khoản giảng viên
    @Override
    public List<Nguoidung> getAllGV() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("FROM Nguoidung WHERE maCV = 'ROLE_GV'");
        return q.getResultList();
    }
    
    // Lấy danh sách tài khoản giảng viên từ bảng giảng viên
    @Override
    public List<Giangvien> getListGV() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("FROM Giangvien");
        return q.getResultList();
    }
    
    // Lấy danh sách tài khoản sinh viên
    @Override
    public List<Nguoidung> getAllSV() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("FROM Nguoidung WHERE maCV = 'ROLE_SV'");
        return q.getResultList();
    }
    
    // Lấy danh sách tài khoản giáo vụ
    @Override
    public List<Nguoidung> getAllGVU() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("FROM Nguoidung WHERE maCV = 'ROLE_GVU'");
        return q.getResultList();
    }

    // Lấy danh sách tài khoản quản trị
    @Override
    public List<Nguoidung> getAllQT() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("FROM Nguoidung WHERE maCV = 'ROLE_QT'");
        return q.getResultList();
    }

    //THÊM NGƯỜI DÙNG
    //  Thêm mới tài khoản người dùng
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
  
    //  Thêm mới tài khoản quản trị
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
    
    //  Thêm mới tài khoản giáo vụ
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

    //  Thêm mới tài khoản giảng viên
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

    //  Thêm mới tài khoản sinh viên
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

    //XÓA NGUỜI DÙNG
    //  Xóa tài khoản người dùng
    @Override
    public void deleteUsers(String userID) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("DELETE FROM Nguoidung WHERE username = (:userID)");
        q.setParameter("userID", userID);
        q.executeUpdate();
    }
    
    //  Xóa tài khoản quản trị
    @Override
    public void deleteUsersQT(String userID) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("DELETE FROM Quantri WHERE maQT = (:userID) AND maCV = 'ROLE_QT'");
        q.setParameter("userID", userID);
        q.executeUpdate();
    }
    
    //  Xóa tài khoản giáo vụ
    @Override
    public void deleteUsersGVU(String userID) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("DELETE FROM Giaovu WHERE maGV = (:userID) AND maCV = 'ROLE_GVU'");
        q.setParameter("userID", userID);
        q.executeUpdate();
    }
    
    //  Xóa tài khoản giảng viên
    @Override
    public void deleteUsersGV(String userID) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("DELETE FROM Giangvien WHERE maGV = (:userID) AND maCV = 'ROLE_GV'");
        q.setParameter("userID", userID);
        q.executeUpdate();
    }

    //  Xóa tài khoản sinh viên
    @Override
    public void deleteUsersSV(String userID) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("DELETE FROM Sinhvien WHERE maSV = (:userID) AND maCV = 'ROLE_SV'");
        q.setParameter("userID", userID);
        q.executeUpdate();
    }

    //CẬP NHẬT NGƯỜI DÙNG
    //  Cập nhật thông tin tài khoản người dùng
    @Override
    public void updateUsers(Nguoidung user) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        session.update(user);
    }  

    //  Cập nhật thông tin tài khoản người dùng hiện tại
    @Override
    public void updateParticularUsers(Nguoidung user) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        session.update(user);
    }

    //  Cập nhật thông tin tài khoản sinh viên
    @Override
    public void updateUsersSV(Sinhvien user) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("UPDATE Sinhvien SET nienKhoa = (:nienKhoa), tinhTrang = (:tinhTrang), maKhoa = (:maKhoa), maNganh = (:maNganh) "
                + "WHERE maSV = (:userID) AND maCV = 'ROLE_SV'");
        q.setParameter("userID", user.getSinhvienPK().getMaND());
        q.setParameter("nienKhoa", user.getNienKhoa());
        q.setParameter("tinhTrang", user.getTinhTrang());
        q.setParameter("maKhoa", user.getSinhvienPK().getMaKhoa());
        q.setParameter("maNganh", user.getSinhvienPK().getMaNganh());
        q.executeUpdate();
    }
    
    //  Cập nhật thông tin tài khoản giảng viên
    @Override
    public void updateUsersGV(Giangvien user) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("UPDATE Giangvien SET hocVi = (:hocVi), hocHam = (:hocHam) "
                + "WHERE maGV = (:userID) AND maCV = 'ROLE_GV'");
        q.setParameter("userID", user.getGiangvienPK().getMaND());
        q.setParameter("hocVi", user.getHocVi());
        q.setParameter("hocHam", user.getHocHam());
        q.executeUpdate();
    }
    
    //  Cập nhật thông tin tài khoản giáo vụ
    @Override
    public void updateUsersGVU(Giaovu user) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("UPDATE Giaovu SET phongBan = (:phongBan) "
                + "WHERE maGV = (:userID) AND maCV = 'ROLE_GVU'");
        q.setParameter("userID", user.getGiaovuPK().getMaND());
        q.setParameter("phongBan", user.getPhongBan());
        q.executeUpdate();
    } 

    @Override
    public Giangvien getGVbyID(String id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("FROM Giangvien WHERE maGV = (:id)");
        q.setParameter("id", id);
        return (Giangvien) q.setMaxResults(1).getSingleResult();
    }
}
