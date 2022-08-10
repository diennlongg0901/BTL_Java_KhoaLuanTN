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
public class GiaovuPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "maGV")
    private String maGV;
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

    public GiaovuPK() {
    }

    public GiaovuPK(String maGV, String nguoidungmaND, String nguoidungchucvumaChucVu) {
        this.maGV = maGV;
        this.nguoidungmaND = nguoidungmaND;
        this.nguoidungchucvumaChucVu = nguoidungchucvumaChucVu;
    }

    public String getMaGV() {
        return maGV;
    }

    public void setMaGV(String maGV) {
        this.maGV = maGV;
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
        hash += (maGV != null ? maGV.hashCode() : 0);
        hash += (nguoidungmaND != null ? nguoidungmaND.hashCode() : 0);
        hash += (nguoidungchucvumaChucVu != null ? nguoidungchucvumaChucVu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GiaovuPK)) {
            return false;
        }
        GiaovuPK other = (GiaovuPK) object;
        if ((this.maGV == null && other.maGV != null) || (this.maGV != null && !this.maGV.equals(other.maGV))) {
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
        return "com.demo.pojo.GiaovuPK[ maGV=" + maGV + ", nguoidungmaND=" + nguoidungmaND + ", nguoidungchucvumaChucVu=" + nguoidungchucvumaChucVu + " ]";
    }
    
}
