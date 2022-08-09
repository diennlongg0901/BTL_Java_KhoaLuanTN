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
public class NganhPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "maNganh")
    private int maNganh;
    @Basic(optional = false)
    @NotNull
    @Column(name = "khoa_maKhoa")
    private int khoamaKhoa;

    public NganhPK() {
    }

    public NganhPK(int maNganh, int khoamaKhoa) {
        this.maNganh = maNganh;
        this.khoamaKhoa = khoamaKhoa;
    }

    public int getMaNganh() {
        return maNganh;
    }

    public void setMaNganh(int maNganh) {
        this.maNganh = maNganh;
    }

    public int getKhoamaKhoa() {
        return khoamaKhoa;
    }

    public void setKhoamaKhoa(int khoamaKhoa) {
        this.khoamaKhoa = khoamaKhoa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) maNganh;
        hash += (int) khoamaKhoa;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NganhPK)) {
            return false;
        }
        NganhPK other = (NganhPK) object;
        if (this.maNganh != other.maNganh) {
            return false;
        }
        if (this.khoamaKhoa != other.khoamaKhoa) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.demo.pojo.NganhPK[ maNganh=" + maNganh + ", khoamaKhoa=" + khoamaKhoa + " ]";
    }
    
}
