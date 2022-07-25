/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author ADMIN
 */
@Embeddable
public class DiemPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "khoaluan_maKL")
    private int khoaluanmaKL;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tieuchi_maTC")
    private int tieuchimaTC;

    public DiemPK() {
    }

    public DiemPK(int khoaluanmaKL, int tieuchimaTC) {
        this.khoaluanmaKL = khoaluanmaKL;
        this.tieuchimaTC = tieuchimaTC;
    }

    public int getKhoaluanmaKL() {
        return khoaluanmaKL;
    }

    public void setKhoaluanmaKL(int khoaluanmaKL) {
        this.khoaluanmaKL = khoaluanmaKL;
    }

    public int getTieuchimaTC() {
        return tieuchimaTC;
    }

    public void setTieuchimaTC(int tieuchimaTC) {
        this.tieuchimaTC = tieuchimaTC;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) khoaluanmaKL;
        hash += (int) tieuchimaTC;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiemPK)) {
            return false;
        }
        DiemPK other = (DiemPK) object;
        if (this.khoaluanmaKL != other.khoaluanmaKL) {
            return false;
        }
        if (this.tieuchimaTC != other.tieuchimaTC) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.demo.pojo.DiemPK[ khoaluanmaKL=" + khoaluanmaKL + ", tieuchimaTC=" + tieuchimaTC + " ]";
    }
    
}
