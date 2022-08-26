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
@Table(name = "giaovu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Giaovu.findAll", query = "SELECT g FROM Giaovu g"),
    @NamedQuery(name = "Giaovu.findByMaGVU", query = "SELECT g FROM Giaovu g WHERE g.giaovuPK.maGVU = :maGVU"),
    @NamedQuery(name = "Giaovu.findByPhongBan", query = "SELECT g FROM Giaovu g WHERE g.phongBan = :phongBan"),
    @NamedQuery(name = "Giaovu.findByMaND", query = "SELECT g FROM Giaovu g WHERE g.giaovuPK.maND = :maND"),
    @NamedQuery(name = "Giaovu.findByMaCV", query = "SELECT g FROM Giaovu g WHERE g.giaovuPK.maCV = :maCV")})
public class Giaovu implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GiaovuPK giaovuPK;
    @Size(max = 50)
    @Column(name = "phongBan")
    private String phongBan;
    @JoinColumns({
        @JoinColumn(name = "maND", referencedColumnName = "maND", insertable = false, updatable = false),
        @JoinColumn(name = "maCV", referencedColumnName = "maCV", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Nguoidung nguoidung;

    public Giaovu() {
    }

    public Giaovu(GiaovuPK giaovuPK) {
        this.giaovuPK = giaovuPK;
    }

    public Giaovu(String maGVU, String maND, String maCV) {
        this.giaovuPK = new GiaovuPK(maGVU, maND, maCV);
    }

    public GiaovuPK getGiaovuPK() {
        return giaovuPK;
    }

    public void setGiaovuPK(GiaovuPK giaovuPK) {
        this.giaovuPK = giaovuPK;
    }

    public String getPhongBan() {
        return phongBan;
    }

    public void setPhongBan(String phongBan) {
        this.phongBan = phongBan;
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
        hash += (giaovuPK != null ? giaovuPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Giaovu)) {
            return false;
        }
        Giaovu other = (Giaovu) object;
        if ((this.giaovuPK == null && other.giaovuPK != null) || (this.giaovuPK != null && !this.giaovuPK.equals(other.giaovuPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.demo.pojo.Giaovu[ giaovuPK=" + giaovuPK + " ]";
    }
    
}
