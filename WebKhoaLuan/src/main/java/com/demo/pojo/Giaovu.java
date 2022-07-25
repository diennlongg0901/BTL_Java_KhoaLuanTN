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
 * @author ADMIN
 */
@Entity
@Table(name = "giaovu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Giaovu.findAll", query = "SELECT g FROM Giaovu g"),
    @NamedQuery(name = "Giaovu.findByMaGVu", query = "SELECT g FROM Giaovu g WHERE g.maGVu = :maGVu"),
    @NamedQuery(name = "Giaovu.findByHoGVu", query = "SELECT g FROM Giaovu g WHERE g.hoGVu = :hoGVu"),
    @NamedQuery(name = "Giaovu.findByTenGVu", query = "SELECT g FROM Giaovu g WHERE g.tenGVu = :tenGVu"),
    @NamedQuery(name = "Giaovu.findByGioiTinhGVu", query = "SELECT g FROM Giaovu g WHERE g.gioiTinhGVu = :gioiTinhGVu"),
    @NamedQuery(name = "Giaovu.findByNgaySinhGVu", query = "SELECT g FROM Giaovu g WHERE g.ngaySinhGVu = :ngaySinhGVu"),
    @NamedQuery(name = "Giaovu.findByDiaChiGVu", query = "SELECT g FROM Giaovu g WHERE g.diaChiGVu = :diaChiGVu"),
    @NamedQuery(name = "Giaovu.findBySoDTGVu", query = "SELECT g FROM Giaovu g WHERE g.soDTGVu = :soDTGVu"),
    @NamedQuery(name = "Giaovu.findByEmailGVu", query = "SELECT g FROM Giaovu g WHERE g.emailGVu = :emailGVu"),
    @NamedQuery(name = "Giaovu.findByUsernameGVu", query = "SELECT g FROM Giaovu g WHERE g.usernameGVu = :usernameGVu"),
    @NamedQuery(name = "Giaovu.findByPasswordGVu", query = "SELECT g FROM Giaovu g WHERE g.passwordGVu = :passwordGVu"),
    @NamedQuery(name = "Giaovu.findByAnhGVu", query = "SELECT g FROM Giaovu g WHERE g.anhGVu = :anhGVu"),
    @NamedQuery(name = "Giaovu.findByVaiTro", query = "SELECT g FROM Giaovu g WHERE g.vaiTro = :vaiTro"),
    @NamedQuery(name = "Giaovu.findByPhongBan", query = "SELECT g FROM Giaovu g WHERE g.phongBan = :phongBan")})
public class Giaovu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "maGVu")
    private String maGVu;
    @Size(max = 50)
    @Column(name = "hoGVu")
    private String hoGVu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "tenGVu")
    private String tenGVu;
    @Size(max = 5)
    @Column(name = "gioiTinhGVu")
    private String gioiTinhGVu;
    @Column(name = "ngaySinhGVu")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngaySinhGVu;
    @Size(max = 100)
    @Column(name = "diaChiGVu")
    private String diaChiGVu;
    @Size(max = 15)
    @Column(name = "soDTGVu")
    private String soDTGVu;
    @Size(max = 50)
    @Column(name = "emailGVu")
    private String emailGVu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "usernameGVu")
    private String usernameGVu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "passwordGVu")
    private String passwordGVu;
    @Size(max = 100)
    @Column(name = "anhGVu")
    private String anhGVu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "vaiTro")
    private String vaiTro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "phongBan")
    private String phongBan;

    public Giaovu() {
    }

    public Giaovu(String maGVu) {
        this.maGVu = maGVu;
    }

    public Giaovu(String maGVu, String tenGVu, String usernameGVu, String passwordGVu, String vaiTro, String phongBan) {
        this.maGVu = maGVu;
        this.tenGVu = tenGVu;
        this.usernameGVu = usernameGVu;
        this.passwordGVu = passwordGVu;
        this.vaiTro = vaiTro;
        this.phongBan = phongBan;
    }

    public String getMaGVu() {
        return maGVu;
    }

    public void setMaGVu(String maGVu) {
        this.maGVu = maGVu;
    }

    public String getHoGVu() {
        return hoGVu;
    }

    public void setHoGVu(String hoGVu) {
        this.hoGVu = hoGVu;
    }

    public String getTenGVu() {
        return tenGVu;
    }

    public void setTenGVu(String tenGVu) {
        this.tenGVu = tenGVu;
    }

    public String getGioiTinhGVu() {
        return gioiTinhGVu;
    }

    public void setGioiTinhGVu(String gioiTinhGVu) {
        this.gioiTinhGVu = gioiTinhGVu;
    }

    public Date getNgaySinhGVu() {
        return ngaySinhGVu;
    }

    public void setNgaySinhGVu(Date ngaySinhGVu) {
        this.ngaySinhGVu = ngaySinhGVu;
    }

    public String getDiaChiGVu() {
        return diaChiGVu;
    }

    public void setDiaChiGVu(String diaChiGVu) {
        this.diaChiGVu = diaChiGVu;
    }

    public String getSoDTGVu() {
        return soDTGVu;
    }

    public void setSoDTGVu(String soDTGVu) {
        this.soDTGVu = soDTGVu;
    }

    public String getEmailGVu() {
        return emailGVu;
    }

    public void setEmailGVu(String emailGVu) {
        this.emailGVu = emailGVu;
    }

    public String getUsernameGVu() {
        return usernameGVu;
    }

    public void setUsernameGVu(String usernameGVu) {
        this.usernameGVu = usernameGVu;
    }

    public String getPasswordGVu() {
        return passwordGVu;
    }

    public void setPasswordGVu(String passwordGVu) {
        this.passwordGVu = passwordGVu;
    }

    public String getAnhGVu() {
        return anhGVu;
    }

    public void setAnhGVu(String anhGVu) {
        this.anhGVu = anhGVu;
    }

    public String getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(String vaiTro) {
        this.vaiTro = vaiTro;
    }

    public String getPhongBan() {
        return phongBan;
    }

    public void setPhongBan(String phongBan) {
        this.phongBan = phongBan;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maGVu != null ? maGVu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Giaovu)) {
            return false;
        }
        Giaovu other = (Giaovu) object;
        if ((this.maGVu == null && other.maGVu != null) || (this.maGVu != null && !this.maGVu.equals(other.maGVu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.demo.pojo.Giaovu[ maGVu=" + maGVu + " ]";
    }
    
}
