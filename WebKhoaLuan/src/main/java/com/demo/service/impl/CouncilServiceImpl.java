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
    
    @Override
    public boolean addCouncil(Hoidong council) {
        return this.councilRepo.addCouncil(council);
    }

    @Override
    public boolean addDetailCouncil(Chitiethoidong detailCouncil) {
        Hoidong h = new Hoidong();
        h = (Hoidong)this.councilRepo.getNewCouncil();
        ChitiethoidongPK cthdPK = new ChitiethoidongPK();
        cthdPK.setGiangvienmaND(detailCouncil.getChitiethoidongPK().getGiangvienmaGV());
        cthdPK.setGiangvienmaGV(detailCouncil.getChitiethoidongPK().getGiangvienmaGV());
        cthdPK.setGiangvienmaChucVu("ROLE_GV");
        cthdPK.setHoidongmaHD(h.getMaHD());
//        Chitiethoidong cthd = new Chitiethoidong();
//        detailCouncil.setHoidongmaHD(h.getMaHD());
//        detailCouncil.setGiangvienmaChucVu("ROLE_GV");
//        cthd.setChitiethoidongPK(detailCouncil);      
        detailCouncil.setChitiethoidongPK(cthdPK);
        return this.councilRepo.addDetailCouncil(detailCouncil);
    }

    @Override
    public Object getNewCouncil() {
        return this.councilRepo.getNewCouncil();
    }
    
}
