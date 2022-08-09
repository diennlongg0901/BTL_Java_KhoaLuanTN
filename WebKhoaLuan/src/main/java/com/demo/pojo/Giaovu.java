/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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
@Table(name = "giaovu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Giaovu.findAll", query = "SELECT g FROM Giaovu g"),
    @NamedQuery(name = "Giaovu.findByMaGV", query = "SELECT g FROM Giaovu g WHERE g.giaovuPK.maGV = :maGV"),
    @NamedQuery(name = "Giaovu.findByPhongBan", query = "SELECT g FROM Giaovu g WHERE g.phongBan = :phongBan"),
    @NamedQuery(name = "Giaovu.findByNguoidungmaND", query = "SELECT g FROM Giaovu g WHERE g.giaovuPK.nguoidungmaND = :nguoidungmaND"),
    @NamedQuery(name = "Giaovu.findByNguoidungchucvumaChucVu", query = "SELECT g FROM Giaovu g WHERE g.giaovuPK.nguoidungchucvumaChucVu = :nguoidungchucvumaChucVu")})
public class Giaovu implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GiaovuPK giaovuPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "phongBan")
    private String phongBan;
    @JoinColumns({
        @JoinColumn(name = "nguoidung_maND", referencedColumnName = "maND", insertable = false, updatable = false),
        @JoinColumn(name = "nguoidung_chucvu_maChucVu", referencedColumnName = "chucvu_maChucVu", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Nguoidung nguoidung;

    public Giaovu() {
    }

    public Giaovu(GiaovuPK giaovuPK) {
        this.giaovuPK = giaovuPK;
    }

    public Giaovu(GiaovuPK giaovuPK, String phongBan) {
        this.giaovuPK = giaovuPK;
        this.phongBan = phongBan;
    }

    public Giaovu(String maGV, String nguoidungmaND, String nguoidungchucvumaChucVu) {
        this.giaovuPK = new GiaovuPK(maGV, nguoidungmaND, nguoidungchucvumaChucVu);
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
