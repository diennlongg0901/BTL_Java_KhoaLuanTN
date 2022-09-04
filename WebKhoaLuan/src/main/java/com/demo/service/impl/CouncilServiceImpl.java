/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.service.impl;

import com.demo.pojo.Chitiethoidong;
import com.demo.pojo.ChitiethoidongPK;
import com.demo.pojo.Hoidong;
import com.demo.repository.CouncilRepo;
import com.demo.service.CouncilService;
import java.util.Calendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ADMIN
 */
@Service
public class CouncilServiceImpl implements CouncilService{
    @Autowired
    private CouncilRepo councilRepo;
    
    //THÊM HỘI ĐỒNG
    //  Thêm hội đồng mới
    @Override
    public boolean addCouncil(Hoidong council) {
        
        council.setTinhTrangHD("Khóa luận " + String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
        council.setHoatDong(Short.parseShort("1"));
        return this.councilRepo.addCouncil(council);
    }

    //  Thêm chi tiết hội đồng
    @Override
    public boolean addDetailCouncil(Chitiethoidong detailCouncil) {
        Hoidong h = (Hoidong)this.councilRepo.getNewCouncil();
        ChitiethoidongPK cthdPK = new ChitiethoidongPK();
        cthdPK.setMaND(detailCouncil.getChitiethoidongPK().getMaGV());
        cthdPK.setMaGV(detailCouncil.getChitiethoidongPK().getMaGV());
        cthdPK.setMaCV("ROLE_GV");
        cthdPK.setMaHD(h.getMaHD());   
        detailCouncil.setChitiethoidongPK(cthdPK);
        return this.councilRepo.addDetailCouncil(detailCouncil);
    }

    //LẤY HỘI ĐỒNG
    //  Lấy thông tin hội đồng mới
    @Override
    public Object getNewCouncil() {
        return this.councilRepo.getNewCouncil();
    }

    //  Tìm thông tin chi tiêt hội đồng theo tên hội đồng
    @Override
    public List<Chitiethoidong> getCouncilDetail(String tenHD) {
        return this.councilRepo.getCouncilDetail(tenHD);
    }

    //  Lấy danh sách chi tiết hội đồng
    @Override
    public List<Chitiethoidong> getListCouncilDetail() {
        return this.councilRepo.getListCouncilDetail();
    }
    
    //XÓA HỘI ĐỒNG, THÀNH VIÊN HỘI ĐỒNG
    //  Xóa thành viên hội đồng
    @Override
    public void deleteMember(String userID) {
        this.councilRepo.deleteMember(userID);
    }

    //  Lấy danh sách thông tin hội đồng
    @Override
    public List<Hoidong> getCouncils() {
        return this.councilRepo.getCouncils();
    }

    //  Lấy danh sách chi tiết hội đồng theo tên giảng viên
    @Override
    public List<Chitiethoidong> getCouncilByGV(String idGV) {
        return this.councilRepo.getCouncilByGV(idGV);
    }

    //  Đếm danh sách thành viên hội đồng
    @Override
    public Integer countMember(int id) {
        return this.councilRepo.countMember(id);
    }

    //  Lấy thông tin hội đồng theo mã hội đồng
    @Override
    public Hoidong getCouncil(int id) {
        return this.councilRepo.getCouncil(id);
    }

    //  Khóa hội đồng theo mã hội đồng
    @Override
    public void blockCouncil(int id) {
        this.councilRepo.blockCouncil(id);
    }
}
