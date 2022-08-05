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
@Table(name = "giaovu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Giaovu.findAll", query = "SELECT g FROM Giaovu g"),
    @NamedQuery(name = "Giaovu.findByMaGV", query = "SELECT g FROM Giaovu g WHERE g.maGV = :maGV"),
    @NamedQuery(name = "Giaovu.findByPhongBan", query = "SELECT g FROM Giaovu g WHERE g.phongBan = :phongBan")})
public class Giaovu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "maGV")
    private String maGV;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "phongBan")
    private String phongBan;
    @JoinColumn(name = "nguoidung_maND", referencedColumnName = "maND")
    @ManyToOne(optional = false)
    private Nguoidung nguoidungmaND;

    public Giaovu() {
    }

    public Giaovu(String maGV) {
        this.maGV = maGV;
    }

    public Giaovu(String maGV, String phongBan) {
        this.maGV = maGV;
        this.phongBan = phongBan;
    }

    public String getMaGV() {
        return maGV;
    }

    public void setMaGV(String maGV) {
        this.maGV = maGV;
    }

    public String getPhongBan() {
        return phongBan;
    }

    public void setPhongBan(String phongBan) {
        this.phongBan = phongBan;
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
        hash += (maGV != null ? maGV.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Giaovu)) {
            return false;
        }
        Giaovu other = (Giaovu) object;
        if ((this.maGV == null && other.maGV != null) || (this.maGV != null && !this.maGV.equals(other.maGV))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.demo.pojo.Giaovu[ maGV=" + maGV + " ]";
    }
    
}
