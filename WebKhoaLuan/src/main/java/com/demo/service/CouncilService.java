/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.demo.service;

import com.demo.pojo.Chitiethoidong;
import com.demo.pojo.ChitiethoidongPK;
import com.demo.pojo.Hoidong;

/**
 *
 * @author ADMIN
 */
public interface CouncilService {
    boolean addCouncil(Hoidong council);
    Object getNewCouncil();
    boolean addDetailCouncil (Chitiethoidong detailCouncil);
}
