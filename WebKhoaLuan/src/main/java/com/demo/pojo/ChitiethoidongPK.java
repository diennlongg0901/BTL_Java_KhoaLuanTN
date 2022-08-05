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
public class ChitiethoidongPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "hoidong_maHD")
    private int hoidongmaHD;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "nguoidung_maND")
    private String nguoidungmaND;

    public ChitiethoidongPK() {
    }

    public ChitiethoidongPK(int hoidongmaHD, String nguoidungmaND) {
        this.hoidongmaHD = hoidongmaHD;
        this.nguoidungmaND = nguoidungmaND;
    }

    public int getHoidongmaHD() {
        return hoidongmaHD;
    }

    public void setHoidongmaHD(int hoidongmaHD) {
        this.hoidongmaHD = hoidongmaHD;
    }

    public String getNguoidungmaND() {
        return nguoidungmaND;
    }

    public void setNguoidungmaND(String nguoidungmaND) {
        this.nguoidungmaND = nguoidungmaND;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) hoidongmaHD;
        hash += (nguoidungmaND != null ? nguoidungmaND.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChitiethoidongPK)) {
            return false;
        }
        ChitiethoidongPK other = (ChitiethoidongPK) object;
        if (this.hoidongmaHD != other.hoidongmaHD) {
            return false;
        }
        if ((this.nguoidungmaND == null && other.nguoidungmaND != null) || (this.nguoidungmaND != null && !this.nguoidungmaND.equals(other.nguoidungmaND))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.demo.pojo.ChitiethoidongPK[ hoidongmaHD=" + hoidongmaHD + ", nguoidungmaND=" + nguoidungmaND + " ]";
    }
    
}
