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
    @Column(name = "hoidong_maHD")
    private int hoidongmaHD;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "maSV")
    private String maSV;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "maND")
    private String maND;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "maChucVu")
    private String maChucVu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "maNganh")
    private int maNganh;
    @Basic(optional = false)
    @NotNull
    @Column(name = "maKhoa")
    private int maKhoa;

    public KhoaluanPK() {
    }

    public KhoaluanPK(int maKL, int hoidongmaHD, String maSV, String maND, String maChucVu, int maNganh, int maKhoa) {
        this.maKL = maKL;
        this.hoidongmaHD = hoidongmaHD;
        this.maSV = maSV;
        this.maND = maND;
        this.maChucVu = maChucVu;
        this.maNganh = maNganh;
        this.maKhoa = maKhoa;
    }

    public int getMaKL() {
        return maKL;
    }

    public void setMaKL(int maKL) {
        this.maKL = maKL;
    }

    public int getHoidongmaHD() {
        return hoidongmaHD;
    }

    public void setHoidongmaHD(int hoidongmaHD) {
        this.hoidongmaHD = hoidongmaHD;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getMaND() {
        return maND;
    }

    public void setMaND(String maND) {
        this.maND = maND;
    }

    public String getMaChucVu() {
        return maChucVu;
    }

    public void setMaChucVu(String maChucVu) {
        this.maChucVu = maChucVu;
    }

    public int getMaNganh() {
        return maNganh;
    }

    public void setMaNganh(int maNganh) {
        this.maNganh = maNganh;
    }

    public int getMaKhoa() {
        return maKhoa;
    }

    public void setMaKhoa(int maKhoa) {
        this.maKhoa = maKhoa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) maKL;
        hash += (int) hoidongmaHD;
        hash += (maSV != null ? maSV.hashCode() : 0);
        hash += (maND != null ? maND.hashCode() : 0);
        hash += (maChucVu != null ? maChucVu.hashCode() : 0);
        hash += (int) maNganh;
        hash += (int) maKhoa;
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
        if (this.hoidongmaHD != other.hoidongmaHD) {
            return false;
        }
        if ((this.maSV == null && other.maSV != null) || (this.maSV != null && !this.maSV.equals(other.maSV))) {
            return false;
        }
        if ((this.maND == null && other.maND != null) || (this.maND != null && !this.maND.equals(other.maND))) {
            return false;
        }
        if ((this.maChucVu == null && other.maChucVu != null) || (this.maChucVu != null && !this.maChucVu.equals(other.maChucVu))) {
            return false;
        }
        if (this.maNganh != other.maNganh) {
            return false;
        }
        if (this.maKhoa != other.maKhoa) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.demo.pojo.KhoaluanPK[ maKL=" + maKL + ", hoidongmaHD=" + hoidongmaHD + ", maSV=" + maSV + ", maND=" + maND + ", maChucVu=" + maChucVu + ", maNganh=" + maNganh + ", maKhoa=" + maKhoa + " ]";
    }
    
}
