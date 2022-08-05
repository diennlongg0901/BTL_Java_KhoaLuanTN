/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "quantri")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Quantri.findAll", query = "SELECT q FROM Quantri q"),
    @NamedQuery(name = "Quantri.findByMaQT", query = "SELECT q FROM Quantri q WHERE q.maQT = :maQT"),
    @NamedQuery(name = "Quantri.findByChucVu", query = "SELECT q FROM Quantri q WHERE q.chucVu = :chucVu")})
public class Quantri implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "maQT")
    private String maQT;
    @Size(max = 45)
    @Column(name = "chucVu")
    private String chucVu;
    @JoinColumn(name = "nguoidung_maND", referencedColumnName = "maND")
    @ManyToOne(optional = false)
    private Nguoidung nguoidungmaND;

    public Quantri() {
    }

    public Quantri(String maQT) {
        this.maQT = maQT;
    }

    public String getMaQT() {
        return maQT;
    }

    public void setMaQT(String maQT) {
        this.maQT = maQT;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public Nguoidung getNguoidungmaND() {
        return nguoidungmaND;
    }

    public void setNguoidungmaND(Nguoidung nguoidungmaND) {
        this.nguoidungmaND = nguoidungmaND;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maQT != null ? maQT.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Quantri)) {
            return false;
        }
        Quantri other = (Quantri) object;
        if ((this.maQT == null && other.maQT != null) || (this.maQT != null && !this.maQT.equals(other.maQT))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.demo.pojo.Quantri[ maQT=" + maQT + " ]";
    }
    
}
