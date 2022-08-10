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
public class DiemPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "khoaluan_maKL")
    private int khoaluanmaKL;
    @Basic(optional = false)
    @NotNull
    @Column(name = "khoaluan_hoidong_maHD")
    private int khoaluanhoidongmaHD;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "khoaluan_maSV")
    private String khoaluanmaSV;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "khoaluan_maND")
    private String khoaluanmaND;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "khoaluan_maChucVu")
    private String khoaluanmaChucVu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "khoaluan_maNganh")
    private int khoaluanmaNganh;
    @Basic(optional = false)
    @NotNull
    @Column(name = "khoaluan_maKhoa")
    private int khoaluanmaKhoa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tieuchi_maTC")
    private int tieuchimaTC;

    public DiemPK() {
    }

    public DiemPK(int khoaluanmaKL, int khoaluanhoidongmaHD, String khoaluanmaSV, String khoaluanmaND, String khoaluanmaChucVu, int khoaluanmaNganh, int khoaluanmaKhoa, int tieuchimaTC) {
        this.khoaluanmaKL = khoaluanmaKL;
        this.khoaluanhoidongmaHD = khoaluanhoidongmaHD;
        this.khoaluanmaSV = khoaluanmaSV;
        this.khoaluanmaND = khoaluanmaND;
        this.khoaluanmaChucVu = khoaluanmaChucVu;
        this.khoaluanmaNganh = khoaluanmaNganh;
        this.khoaluanmaKhoa = khoaluanmaKhoa;
        this.tieuchimaTC = tieuchimaTC;
    }

    public int getKhoaluanmaKL() {
        return khoaluanmaKL;
    }

    public void setKhoaluanmaKL(int khoaluanmaKL) {
        this.khoaluanmaKL = khoaluanmaKL;
    }

    public int getKhoaluanhoidongmaHD() {
        return khoaluanhoidongmaHD;
    }

    public void setKhoaluanhoidongmaHD(int khoaluanhoidongmaHD) {
        this.khoaluanhoidongmaHD = khoaluanhoidongmaHD;
    }

    public String getKhoaluanmaSV() {
        return khoaluanmaSV;
    }

    public void setKhoaluanmaSV(String khoaluanmaSV) {
        this.khoaluanmaSV = khoaluanmaSV;
    }

    public String getKhoaluanmaND() {
        return khoaluanmaND;
    }

    public void setKhoaluanmaND(String khoaluanmaND) {
        this.khoaluanmaND = khoaluanmaND;
    }

    public String getKhoaluanmaChucVu() {
        return khoaluanmaChucVu;
    }

    public void setKhoaluanmaChucVu(String khoaluanmaChucVu) {
        this.khoaluanmaChucVu = khoaluanmaChucVu;
    }

    public int getKhoaluanmaNganh() {
        return khoaluanmaNganh;
    }

    public void setKhoaluanmaNganh(int khoaluanmaNganh) {
        this.khoaluanmaNganh = khoaluanmaNganh;
    }

    public int getKhoaluanmaKhoa() {
        return khoaluanmaKhoa;
    }

    public void setKhoaluanmaKhoa(int khoaluanmaKhoa) {
        this.khoaluanmaKhoa = khoaluanmaKhoa;
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
        hash += (int) khoaluanhoidongmaHD;
        hash += (khoaluanmaSV != null ? khoaluanmaSV.hashCode() : 0);
        hash += (khoaluanmaND != null ? khoaluanmaND.hashCode() : 0);
        hash += (khoaluanmaChucVu != null ? khoaluanmaChucVu.hashCode() : 0);
        hash += (int) khoaluanmaNganh;
        hash += (int) khoaluanmaKhoa;
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
        if (this.khoaluanhoidongmaHD != other.khoaluanhoidongmaHD) {
            return false;
        }
        if ((this.khoaluanmaSV == null && other.khoaluanmaSV != null) || (this.khoaluanmaSV != null && !this.khoaluanmaSV.equals(other.khoaluanmaSV))) {
            return false;
        }
        if ((this.khoaluanmaND == null && other.khoaluanmaND != null) || (this.khoaluanmaND != null && !this.khoaluanmaND.equals(other.khoaluanmaND))) {
            return false;
        }
        if ((this.khoaluanmaChucVu == null && other.khoaluanmaChucVu != null) || (this.khoaluanmaChucVu != null && !this.khoaluanmaChucVu.equals(other.khoaluanmaChucVu))) {
            return false;
        }
        if (this.khoaluanmaNganh != other.khoaluanmaNganh) {
            return false;
        }
        if (this.khoaluanmaKhoa != other.khoaluanmaKhoa) {
            return false;
        }
        if (this.tieuchimaTC != other.tieuchimaTC) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.demo.pojo.DiemPK[ khoaluanmaKL=" + khoaluanmaKL + ", khoaluanhoidongmaHD=" + khoaluanhoidongmaHD + ", khoaluanmaSV=" + khoaluanmaSV + ", khoaluanmaND=" + khoaluanmaND + ", khoaluanmaChucVu=" + khoaluanmaChucVu + ", khoaluanmaNganh=" + khoaluanmaNganh + ", khoaluanmaKhoa=" + khoaluanmaKhoa + ", tieuchimaTC=" + tieuchimaTC + " ]";
    }
    
}
