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
import javax.validation.constraints.Size;

/**
 *
 * @author ADMIN
 */
@Embeddable
public class KhoaluanPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "maKL")
    private int maKL;
    @Basic(optional = false)
    @NotNull
    @Column(name = "maDT")
    private int maDT;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "sinhvien_maSV")
    private String sinhvienmaSV;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "maND")
    private String maND;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "maCV")
    private String maCV;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "maNganh")
    private String maNganh;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "sinhvien_maKhoa")
    private String sinhvienmaKhoa;

    public KhoaluanPK() {
    }

    public KhoaluanPK(int maKL, int maDT, String sinhvienmaSV, String maND, String maCV, String maNganh, String sinhvienmaKhoa) {
        this.maKL = maKL;
        this.maDT = maDT;
        this.sinhvienmaSV = sinhvienmaSV;
        this.maND = maND;
        this.maCV = maCV;
        this.maNganh = maNganh;
        this.sinhvienmaKhoa = sinhvienmaKhoa;
    }

    public int getMaKL() {
        return maKL;
    }

    public void setMaKL(int maKL) {
        this.maKL = maKL;
    }

    public int getMaDT() {
        return maDT;
    }

    public void setMaDT(int maDT) {
        this.maDT = maDT;
    }

    public String getSinhvienmaSV() {
        return sinhvienmaSV;
    }

    public void setSinhvienmaSV(String sinhvienmaSV) {
        this.sinhvienmaSV = sinhvienmaSV;
    }

    public String getMaND() {
        return maND;
    }

    public void setMaND(String maND) {
        this.maND = maND;
    }

    public String getMaCV() {
        return maCV;
    }

    public void setMaCV(String maCV) {
        this.maCV = maCV;
    }

    public String getMaNganh() {
        return maNganh;
    }

    public void setMaNganh(String maNganh) {
        this.maNganh = maNganh;
    }

    public String getSinhvienmaKhoa() {
        return sinhvienmaKhoa;
    }

    public void setSinhvienmaKhoa(String sinhvienmaKhoa) {
        this.sinhvienmaKhoa = sinhvienmaKhoa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) maKL;
        hash += (int) maDT;
        hash += (sinhvienmaSV != null ? sinhvienmaSV.hashCode() : 0);
        hash += (maND != null ? maND.hashCode() : 0);
        hash += (maCV != null ? maCV.hashCode() : 0);
        hash += (maNganh != null ? maNganh.hashCode() : 0);
        hash += (sinhvienmaKhoa != null ? sinhvienmaKhoa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KhoaluanPK)) {
            return false;
        }
        KhoaluanPK other = (KhoaluanPK) object;
        if (this.maKL != other.maKL) {
            return false;
        }
        if (this.maDT != other.maDT) {
            return false;
        }
        if ((this.sinhvienmaSV == null && other.sinhvienmaSV != null) || (this.sinhvienmaSV != null && !this.sinhvienmaSV.equals(other.sinhvienmaSV))) {
            return false;
        }
        if ((this.maND == null && other.maND != null) || (this.maND != null && !this.maND.equals(other.maND))) {
            return false;
        }
        if ((this.maCV == null && other.maCV != null) || (this.maCV != null && !this.maCV.equals(other.maCV))) {
            return false;
        }
        if ((this.maNganh == null && other.maNganh != null) || (this.maNganh != null && !this.maNganh.equals(other.maNganh))) {
            return false;
        }
        if ((this.sinhvienmaKhoa == null && other.sinhvienmaKhoa != null) || (this.sinhvienmaKhoa != null && !this.sinhvienmaKhoa.equals(other.sinhvienmaKhoa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.demo.pojo.KhoaluanPK[ maKL=" + maKL + ", maDT=" + maDT + ", sinhvienmaSV=" + sinhvienmaSV + ", maND=" + maND + ", maCV=" + maCV + ", maNganh=" + maNganh + ", sinhvienmaKhoa=" + sinhvienmaKhoa + " ]";
    }
    
}
