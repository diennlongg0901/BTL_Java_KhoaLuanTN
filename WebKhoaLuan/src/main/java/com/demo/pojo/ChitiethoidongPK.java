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
public class ChitiethoidongPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "giangvien_maGV")
    private String giangvienmaGV;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hoidong_maHD")
    private int hoidongmaHD;

    public ChitiethoidongPK() {
    }

    public ChitiethoidongPK(String giangvienmaGV, int hoidongmaHD) {
        this.giangvienmaGV = giangvienmaGV;
        this.hoidongmaHD = hoidongmaHD;
    }

    public String getGiangvienmaGV() {
        return giangvienmaGV;
    }

    public void setGiangvienmaGV(String giangvienmaGV) {
        this.giangvienmaGV = giangvienmaGV;
    }

    public int getHoidongmaHD() {
        return hoidongmaHD;
    }

    public void setHoidongmaHD(int hoidongmaHD) {
        this.hoidongmaHD = hoidongmaHD;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (giangvienmaGV != null ? giangvienmaGV.hashCode() : 0);
        hash += (int) hoidongmaHD;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChitiethoidongPK)) {
            return false;
        }
        ChitiethoidongPK other = (ChitiethoidongPK) object;
        if ((this.giangvienmaGV == null && other.giangvienmaGV != null) || (this.giangvienmaGV != null && !this.giangvienmaGV.equals(other.giangvienmaGV))) {
            return false;
        }
        if (this.hoidongmaHD != other.hoidongmaHD) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.demo.pojo.ChitiethoidongPK[ giangvienmaGV=" + giangvienmaGV + ", hoidongmaHD=" + hoidongmaHD + " ]";
    }
    
}
