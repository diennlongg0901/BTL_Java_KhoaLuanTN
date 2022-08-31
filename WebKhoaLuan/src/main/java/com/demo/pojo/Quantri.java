/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.pojo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
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
    @NamedQuery(name = "Quantri.findByMaQT", query = "SELECT q FROM Quantri q WHERE q.quantriPK.maQT = :maQT"),
    @NamedQuery(name = "Quantri.findByNhiemVu", query = "SELECT q FROM Quantri q WHERE q.nhiemVu = :nhiemVu"),
    @NamedQuery(name = "Quantri.findByMaND", query = "SELECT q FROM Quantri q WHERE q.quantriPK.maND = :maND"),
    @NamedQuery(name = "Quantri.findByMaCV", query = "SELECT q FROM Quantri q WHERE q.quantriPK.maCV = :maCV")})
public class Quantri implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected QuantriPK quantriPK;
    @Size(max = 100)
    @Column(name = "nhiemVu")
    private String nhiemVu;
    @JoinColumns({
        @JoinColumn(name = "maND", referencedColumnName = "maND", insertable = false, updatable = false),
        @JoinColumn(name = "maCV", referencedColumnName = "maCV", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Nguoidung nguoidung;

    public Quantri() {
    }

    public Quantri(QuantriPK quantriPK) {
        this.quantriPK = quantriPK;
    }

    public Quantri(String maQT, String maND, String maCV) {
        this.quantriPK = new QuantriPK(maQT, maND, maCV);
    }

    public QuantriPK getQuantriPK() {
        return quantriPK;
    }

    public void setQuantriPK(QuantriPK quantriPK) {
        this.quantriPK = quantriPK;
    }

    public String getNhiemVu() {
        return nhiemVu;
    }

    public void setNhiemVu(String nhiemVu) {
        this.nhiemVu = nhiemVu;
    }

    public Nguoidung getNguoidung() {
        return nguoidung;
    }

    public void setNguoidung(Nguoidung nguoidung) {
        this.nguoidung = nguoidung;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (quantriPK != null ? quantriPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Quantri)) {
            return false;
        }
        Quantri other = (Quantri) object;
        if ((this.quantriPK == null && other.quantriPK != null) || (this.quantriPK != null && !this.quantriPK.equals(other.quantriPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.demo.pojo.Quantri[ quantriPK=" + quantriPK + " ]";
    }
    
}
