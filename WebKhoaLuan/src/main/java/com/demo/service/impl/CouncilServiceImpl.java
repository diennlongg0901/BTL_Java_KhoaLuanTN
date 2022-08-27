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
    @Override
    public boolean addCouncil(Hoidong council) {
        council.setTinhTrangHD("Khóa luận" + String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
        return this.councilRepo.addCouncil(council);
    }

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
    @Override
    public Object getNewCouncil() {
        return this.councilRepo.getNewCouncil();
    }

    @Override
    public List<Chitiethoidong> getCouncilDetail(String tenHD) {
        return this.councilRepo.getCouncilDetail(tenHD);
    }

    @Override
    public List<Chitiethoidong> getListCouncilDetail() {
        return this.councilRepo.getListCouncilDetail();
    }
    
    //XÓA HỘI ĐỒNG, THÀNH VIÊN HỘI ĐỒNG
    @Override
    public void deleteMember(String userID) {
        this.councilRepo.deleteMember(userID);
    }
}
