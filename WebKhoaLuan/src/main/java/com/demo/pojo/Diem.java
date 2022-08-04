/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "diem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Diem.findAll", query = "SELECT d FROM Diem d"),
    @NamedQuery(name = "Diem.findByKhoaluanmaKL", query = "SELECT d FROM Diem d WHERE d.diemPK.khoaluanmaKL = :khoaluanmaKL"),
    @NamedQuery(name = "Diem.findByTieuchimaTC", query = "SELECT d FROM Diem d WHERE d.diemPK.tieuchimaTC = :tieuchimaTC"),
    @NamedQuery(name = "Diem.findByDiem", query = "SELECT d FROM Diem d WHERE d.diem = :diem")})
public class Diem implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DiemPK diemPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "diem")
    private BigDecimal diem;
    @JoinColumn(name = "khoaluan_maKL", referencedColumnName = "maKL", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Khoaluan khoaluan;
    @JoinColumn(name = "tieuchi_maTC", referencedColumnName = "maTC", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Tieuchi tieuchi;

    public Diem() {
    }

    public Diem(DiemPK diemPK) {
        this.diemPK = diemPK;
    }

    public Diem(int khoaluanmaKL, int tieuchimaTC) {
        this.diemPK = new DiemPK(khoaluanmaKL, tieuchimaTC);
    }

    public DiemPK getDiemPK() {
        return diemPK;
    }

    public void setDiemPK(DiemPK diemPK) {
        this.diemPK = diemPK;
    }

    public BigDecimal getDiem() {
        return diem;
    }

    public void setDiem(BigDecimal diem) {
        this.diem = diem;
    }

    public Khoaluan getKhoaluan() {
        return khoaluan;
    }

    public void setKhoaluan(Khoaluan khoaluan) {
        this.khoaluan = khoaluan;
    }

    public Tieuchi getTieuchi() {
        return tieuchi;
    }

    public void setTieuchi(Tieuchi tieuchi) {
        this.tieuchi = tieuchi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (diemPK != null ? diemPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Diem)) {
            return false;
        }
        Diem other = (Diem) object;
        if ((this.diemPK == null && other.diemPK != null) || (this.diemPK != null && !this.diemPK.equals(other.diemPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.demo.pojo.Diem[ diemPK=" + diemPK + " ]";
    }
    
}
