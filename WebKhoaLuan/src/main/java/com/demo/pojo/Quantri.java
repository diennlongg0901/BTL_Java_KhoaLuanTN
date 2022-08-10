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
    @NamedQuery(name = "Quantri.findByChucVu", query = "SELECT q FROM Quantri q WHERE q.chucVu = :chucVu"),
    @NamedQuery(name = "Quantri.findByNguoidungmaND", query = "SELECT q FROM Quantri q WHERE q.quantriPK.nguoidungmaND = :nguoidungmaND"),
    @NamedQuery(name = "Quantri.findByNguoidungchucvumaChucVu", query = "SELECT q FROM Quantri q WHERE q.quantriPK.nguoidungchucvumaChucVu = :nguoidungchucvumaChucVu")})
public class Quantri implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected QuantriPK quantriPK;
    @Size(max = 45)
    @Column(name = "chucVu")
    private String chucVu;
    @JoinColumns({
        @JoinColumn(name = "nguoidung_maND", referencedColumnName = "maND", insertable = false, updatable = false),
        @JoinColumn(name = "nguoidung_chucvu_maChucVu", referencedColumnName = "chucvu_maChucVu", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Nguoidung nguoidung;

    public Quantri() {
    }

    public Quantri(QuantriPK quantriPK) {
        this.quantriPK = quantriPK;
    }

    public Quantri(String maQT, String nguoidungmaND, String nguoidungchucvumaChucVu) {
        this.quantriPK = new QuantriPK(maQT, nguoidungmaND, nguoidungchucvumaChucVu);
    }

    public QuantriPK getQuantriPK() {
        return quantriPK;
    }

    public void setQuantriPK(QuantriPK quantriPK) {
        this.quantriPK = quantriPK;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
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
