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
public class DangkykhoaluanPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "maDK")
    private int maDK;
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
    @Column(name = "maKhoa")
    private String maKhoa;

    public DangkykhoaluanPK() {
    }

    public DangkykhoaluanPK(int maDK, int maDT, String sinhvienmaSV, String maND, String maCV, String maNganh, String maKhoa) {
        this.maDK = maDK;
        this.maDT = maDT;
        this.sinhvienmaSV = sinhvienmaSV;
        this.maND = maND;
        this.maCV = maCV;
        this.maNganh = maNganh;
        this.maKhoa = maKhoa;
    }

    public int getMaDK() {
        return maDK;
    }

    public void setMaDK(int maDK) {
        this.maDK = maDK;
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

    public String getMaKhoa() {
        return maKhoa;
    }

    public void setMaKhoa(String maKhoa) {
        this.maKhoa = maKhoa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) maDK;
        hash += (int) maDT;
        hash += (sinhvienmaSV != null ? sinhvienmaSV.hashCode() : 0);
        hash += (maND != null ? maND.hashCode() : 0);
        hash += (maCV != null ? maCV.hashCode() : 0);
        hash += (maNganh != null ? maNganh.hashCode() : 0);
        hash += (maKhoa != null ? maKhoa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DangkykhoaluanPK)) {
            return false;
        }
        DangkykhoaluanPK other = (DangkykhoaluanPK) object;
        if (this.maDK != other.maDK) {
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
        if ((this.maKhoa == null && other.maKhoa != null) || (this.maKhoa != null && !this.maKhoa.equals(other.maKhoa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.demo.pojo.DangkykhoaluanPK[ maDK=" + maDK + ", maDT=" + maDT + ", sinhvienmaSV=" + sinhvienmaSV + ", maND=" + maND + ", maCV=" + maCV + ", maNganh=" + maNganh + ", maKhoa=" + maKhoa + " ]";
    }
    
}
