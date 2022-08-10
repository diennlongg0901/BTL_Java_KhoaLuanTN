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
public class QuantriPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "maQT")
    private String maQT;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "nguoidung_maND")
    private String nguoidungmaND;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "nguoidung_chucvu_maChucVu")
    private String nguoidungchucvumaChucVu;

    public QuantriPK() {
    }

    public QuantriPK(String maQT, String nguoidungmaND, String nguoidungchucvumaChucVu) {
        this.maQT = maQT;
        this.nguoidungmaND = nguoidungmaND;
        this.nguoidungchucvumaChucVu = nguoidungchucvumaChucVu;
    }

    public String getMaQT() {
        return maQT;
    }

    public void setMaQT(String maQT) {
        this.maQT = maQT;
    }

    public String getNguoidungmaND() {
        return nguoidungmaND;
    }

    public void setNguoidungmaND(String nguoidungmaND) {
        this.nguoidungmaND = nguoidungmaND;
    }

    public String getNguoidungchucvumaChucVu() {
        return nguoidungchucvumaChucVu;
    }

    public void setNguoidungchucvumaChucVu(String nguoidungchucvumaChucVu) {
        this.nguoidungchucvumaChucVu = nguoidungchucvumaChucVu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maQT != null ? maQT.hashCode() : 0);
        hash += (nguoidungmaND != null ? nguoidungmaND.hashCode() : 0);
        hash += (nguoidungchucvumaChucVu != null ? nguoidungchucvumaChucVu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QuantriPK)) {
            return false;
        }
        QuantriPK other = (QuantriPK) object;
        if ((this.maQT == null && other.maQT != null) || (this.maQT != null && !this.maQT.equals(other.maQT))) {
            return false;
        }
        if ((this.nguoidungmaND == null && other.nguoidungmaND != null) || (this.nguoidungmaND != null && !this.nguoidungmaND.equals(other.nguoidungmaND))) {
            return false;
        }
        if ((this.nguoidungchucvumaChucVu == null && other.nguoidungchucvumaChucVu != null) || (this.nguoidungchucvumaChucVu != null && !this.nguoidungchucvumaChucVu.equals(other.nguoidungchucvumaChucVu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.demo.pojo.QuantriPK[ maQT=" + maQT + ", nguoidungmaND=" + nguoidungmaND + ", nguoidungchucvumaChucVu=" + nguoidungchucvumaChucVu + " ]";
    }
    
}
