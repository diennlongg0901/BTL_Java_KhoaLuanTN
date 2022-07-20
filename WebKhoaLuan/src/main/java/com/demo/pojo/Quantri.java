/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "quantri")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Quantri.findAll", query = "SELECT q FROM Quantri q"),
    @NamedQuery(name = "Quantri.findByMaQT", query = "SELECT q FROM Quantri q WHERE q.maQT = :maQT"),
    @NamedQuery(name = "Quantri.findByHoQT", query = "SELECT q FROM Quantri q WHERE q.hoQT = :hoQT"),
    @NamedQuery(name = "Quantri.findByTenQT", query = "SELECT q FROM Quantri q WHERE q.tenQT = :tenQT"),
    @NamedQuery(name = "Quantri.findByGioiTinhQT", query = "SELECT q FROM Quantri q WHERE q.gioiTinhQT = :gioiTinhQT"),
    @NamedQuery(name = "Quantri.findByNgaySinhQT", query = "SELECT q FROM Quantri q WHERE q.ngaySinhQT = :ngaySinhQT"),
    @NamedQuery(name = "Quantri.findByDiaChiQT", query = "SELECT q FROM Quantri q WHERE q.diaChiQT = :diaChiQT"),
    @NamedQuery(name = "Quantri.findBySoDTQT", query = "SELECT q FROM Quantri q WHERE q.soDTQT = :soDTQT"),
    @NamedQuery(name = "Quantri.findByEmailQT", query = "SELECT q FROM Quantri q WHERE q.emailQT = :emailQT"),
    @NamedQuery(name = "Quantri.findByUsernamQT", query = "SELECT q FROM Quantri q WHERE q.usernamQT = :usernamQT"),
    @NamedQuery(name = "Quantri.findByPasswordQT", query = "SELECT q FROM Quantri q WHERE q.passwordQT = :passwordQT"),
    @NamedQuery(name = "Quantri.findByAnhQT", query = "SELECT q FROM Quantri q WHERE q.anhQT = :anhQT")})
public class Quantri implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "maQT")
    private String maQT;
    @Size(max = 50)
    @Column(name = "hoQT")
    private String hoQT;
    @Size(max = 20)
    @Column(name = "tenQT")
    private String tenQT;
    @Size(max = 5)
    @Column(name = "gioiTinhQT")
    private String gioiTinhQT;
    @Column(name = "ngaySinhQT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngaySinhQT;
    @Size(max = 100)
    @Column(name = "diaChiQT")
    private String diaChiQT;
    @Size(max = 15)
    @Column(name = "soDTQT")
    private String soDTQT;
    @Size(max = 50)
    @Column(name = "emailQT")
    private String emailQT;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "usernamQT")
    private String usernamQT;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "passwordQT")
    private String passwordQT;
    @Size(max = 100)
    @Column(name = "anhQT")
    private String anhQT;

    public Quantri() {
    }

    public Quantri(String maQT) {
        this.maQT = maQT;
    }

    public Quantri(String maQT, String usernamQT, String passwordQT) {
        this.maQT = maQT;
        this.usernamQT = usernamQT;
        this.passwordQT = passwordQT;
    }

    public String getMaQT() {
        return maQT;
    }

    public void setMaQT(String maQT) {
        this.maQT = maQT;
    }

    public String getHoQT() {
        return hoQT;
    }

    public void setHoQT(String hoQT) {
        this.hoQT = hoQT;
    }

    public String getTenQT() {
        return tenQT;
    }

    public void setTenQT(String tenQT) {
        this.tenQT = tenQT;
    }

    public String getGioiTinhQT() {
        return gioiTinhQT;
    }

    public void setGioiTinhQT(String gioiTinhQT) {
        this.gioiTinhQT = gioiTinhQT;
    }

    public Date getNgaySinhQT() {
        return ngaySinhQT;
    }

    public void setNgaySinhQT(Date ngaySinhQT) {
        this.ngaySinhQT = ngaySinhQT;
    }

    public String getDiaChiQT() {
        return diaChiQT;
    }

    public void setDiaChiQT(String diaChiQT) {
        this.diaChiQT = diaChiQT;
    }

    public String getSoDTQT() {
        return soDTQT;
    }

    public void setSoDTQT(String soDTQT) {
        this.soDTQT = soDTQT;
    }

    public String getEmailQT() {
        return emailQT;
    }

    public void setEmailQT(String emailQT) {
        this.emailQT = emailQT;
    }

    public String getUsernamQT() {
        return usernamQT;
    }

    public void setUsernamQT(String usernamQT) {
        this.usernamQT = usernamQT;
    }

    public String getPasswordQT() {
        return passwordQT;
    }

    public void setPasswordQT(String passwordQT) {
        this.passwordQT = passwordQT;
    }

    public String getAnhQT() {
        return anhQT;
    }

    public void setAnhQT(String anhQT) {
        this.anhQT = anhQT;
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
