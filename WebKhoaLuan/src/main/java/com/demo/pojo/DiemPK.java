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
public class DiemPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "maTC")
    private int maTC;
    @Basic(optional = false)
    @NotNull
    @Column(name = "maKL")
    private int maKL;

    public DiemPK() {
    }

    public DiemPK(int maTC, int maKL) {
        this.maTC = maTC;
        this.maKL = maKL;
    }

    public int getMaTC() {
        return maTC;
    }

    public void setMaTC(int maTC) {
        this.maTC = maTC;
    }

    public int getMaKL() {
        return maKL;
    }

    public void setMaKL(int maKL) {
        this.maKL = maKL;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) maTC;
        hash += (int) maKL;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiemPK)) {
            return false;
        }
        DiemPK other = (DiemPK) object;
        if (this.maTC != other.maTC) {
            return false;
        }
        if (this.maKL != other.maKL) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.demo.pojo.DiemPK[ maTC=" + maTC + ", maKL=" + maKL + " ]";
    }
    
}
