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
 * @author PC
 */
@Embeddable
public class NguoidungPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "maND")
    private String maND;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "chucvu_maChucVu")
    private String chucvumaChucVu;

    public NguoidungPK() {
    }

    public NguoidungPK(String maND, String chucvumaChucVu) {
        this.maND = maND;
        this.chucvumaChucVu = chucvumaChucVu;
    }

    public String getMaND() {
        return maND;
    }

    public void setMaND(String maND) {
        this.maND = maND;
    }

    public String getChucvumaChucVu() {
        return chucvumaChucVu;
    }

    public void setChucvumaChucVu(String chucvumaChucVu) {
        this.chucvumaChucVu = chucvumaChucVu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maND != null ? maND.hashCode() : 0);
        hash += (chucvumaChucVu != null ? chucvumaChucVu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NguoidungPK)) {
            return false;
        }
        NguoidungPK other = (NguoidungPK) object;
        if ((this.maND == null && other.maND != null) || (this.maND != null && !this.maND.equals(other.maND))) {
            return false;
        }
        if ((this.chucvumaChucVu == null && other.chucvumaChucVu != null) || (this.chucvumaChucVu != null && !this.chucvumaChucVu.equals(other.chucvumaChucVu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.demo.pojo.NguoidungPK[ maND=" + maND + ", chucvumaChucVu=" + chucvumaChucVu + " ]";
    }
    
}
