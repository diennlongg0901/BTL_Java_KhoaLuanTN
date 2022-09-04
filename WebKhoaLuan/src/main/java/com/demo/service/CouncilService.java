/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.demo.service;

import com.demo.pojo.Chitiethoidong;
import com.demo.pojo.Hoidong;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface CouncilService {
    //THÊM HỘI ĐỒNG, CHI TIẾT HỘI ĐỒNG
    boolean addCouncil(Hoidong council);
    boolean addDetailCouncil (Chitiethoidong detailCouncil);
    
    //LẤY THÔNG TIN HỘI ĐỒNG
    Object getNewCouncil();
    List<Hoidong> getCouncils();
    List<Chitiethoidong> getListCouncilDetail();
    List<Chitiethoidong> getCouncilDetail(String tenHD);
    List<Chitiethoidong> getCouncilByGV(String idGV);
    Integer countMember(int id);
    Hoidong getCouncil(int id);
    void blockCouncil(int id);
    
    //XÓA HỘI ĐỒNG, THÀNH VIÊN HỘI ĐỒNG
    void deleteMember(String userID);
}
