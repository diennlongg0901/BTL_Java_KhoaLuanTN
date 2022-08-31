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
    @Size(min = 1, max = 10)
    @Column(name = "maGV")
    private String maGV;
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
    @Column(name = "maKL")
    private int maKL;
    @Basic(optional = false)
    @NotNull
    @Column(name = "maTC")
    private int maTC;

    public DiemPK() {
    }

    public DiemPK(String maGV, String maND, String maCV, int maKL, int maTC) {
        this.maGV = maGV;
        this.maND = maND;
        this.maCV = maCV;
        this.maKL = maKL;
        this.maTC = maTC;
    }

    public String getMaGV() {
        return maGV;
    }

    public void setMaGV(String maGV) {
        this.maGV = maGV;
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

    public int getMaKL() {
        return maKL;
    }

    public void setMaKL(int maKL) {
        this.maKL = maKL;
    }

    public int getMaTC() {
        return maTC;
    }

    public void setMaTC(int maTC) {
        this.maTC = maTC;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maGV != null ? maGV.hashCode() : 0);
        hash += (maND != null ? maND.hashCode() : 0);
        hash += (maCV != null ? maCV.hashCode() : 0);
        hash += (int) maKL;
        hash += (int) maTC;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiemPK)) {
            return false;
        }
        DiemPK other = (DiemPK) object;
        if ((this.maGV == null && other.maGV != null) || (this.maGV != null && !this.maGV.equals(other.maGV))) {
            return false;
        }
        if ((this.maND == null && other.maND != null) || (this.maND != null && !this.maND.equals(other.maND))) {
            return false;
        }
        if ((this.maCV == null && other.maCV != null) || (this.maCV != null && !this.maCV.equals(other.maCV))) {
            return false;
        }
        if (this.maKL != other.maKL) {
            return false;
        }
        if (this.maTC != other.maTC) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.demo.pojo.DiemPK[ maGV=" + maGV + ", maND=" + maND + ", maCV=" + maCV + ", maKL=" + maKL + ", maTC=" + maTC + " ]";
    }
    
}
