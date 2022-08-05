/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "nguoidung")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nguoidung.findAll", query = "SELECT n FROM Nguoidung n"),
    @NamedQuery(name = "Nguoidung.findByMaND", query = "SELECT n FROM Nguoidung n WHERE n.maND = :maND"),
    @NamedQuery(name = "Nguoidung.findByHo", query = "SELECT n FROM Nguoidung n WHERE n.ho = :ho"),
    @NamedQuery(name = "Nguoidung.findByTen", query = "SELECT n FROM Nguoidung n WHERE n.ten = :ten"),
    @NamedQuery(name = "Nguoidung.findByGioiTinh", query = "SELECT n FROM Nguoidung n WHERE n.gioiTinh = :gioiTinh"),
    @NamedQuery(name = "Nguoidung.findByNgaySinh", query = "SELECT n FROM Nguoidung n WHERE n.ngaySinh = :ngaySinh"),
    @NamedQuery(name = "Nguoidung.findByUsername", query = "SELECT n FROM Nguoidung n WHERE n.username = :username"),
    @NamedQuery(name = "Nguoidung.findByPassword", query = "SELECT n FROM Nguoidung n WHERE n.password = :password"),
    @NamedQuery(name = "Nguoidung.findByAnh", query = "SELECT n FROM Nguoidung n WHERE n.anh = :anh"),
    @NamedQuery(name = "Nguoidung.findByDiaChi", query = "SELECT n FROM Nguoidung n WHERE n.diaChi = :diaChi"),
    @NamedQuery(name = "Nguoidung.findByEmail", query = "SELECT n FROM Nguoidung n WHERE n.email = :email"),
    @NamedQuery(name = "Nguoidung.findBySdt", query = "SELECT n FROM Nguoidung n WHERE n.sdt = :sdt"),
    @NamedQuery(name = "Nguoidung.findByHoatDong", query = "SELECT n FROM Nguoidung n WHERE n.hoatDong = :hoatDong")})
public class Nguoidung implements Serializable {
    private static final String QuanTri = "Quản Trị";
    
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "maND")
    private String maND;
    @Size(max = 50)
    @Column(name = "ho")
    private String ho;
    @Size(max = 30)
    @Column(name = "ten")
    private String ten;
    @Size(max = 5)
    @Column(name = "gioiTinh")
    private String gioiTinh;
    @Column(name = "ngaySinh")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngaySinh;
    @Size(max = 50)
    @Column(name = "username")
    private String username;
    @Size(max = 100)
    @Column(name = "password")
    private String password;
    @Size(max = 100)
    @Column(name = "anh")
    private String anh;
    @Size(max = 100)
    @Column(name = "diaChi")
    private String diaChi;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "email")
    private String email;
    @Size(max = 30)
    @Column(name = "sdt")
    private String sdt;
    @Column(name = "hoatDong")
    private Short hoatDong;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nguoidungmaND")
    private Set<Quantri> quantriSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nguoidungmaND")
    private Set<Giangvien> giangvienSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nguoidung")
    private Set<Chitiethoidong> chitiethoidongSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nguoidungmaND")
    private Set<Giaovu> giaovuSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nguoidungmaND")
    private Set<Sinhvien> sinhvienSet;
    @JoinColumn(name = "chucvu_maChucVu", referencedColumnName = "maChucVu")
    @ManyToOne 
    private Chucvu chucvumaChucVu;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nguoidungmaND")
    private Set<Khoaluan> khoaluanSet;

    public Nguoidung() {
    }

    public Nguoidung(String maND) {
        this.maND = maND;
    }

    public String getMaND() {
        return maND;
    }

    public void setMaND(String maND) {
        this.maND = maND;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public Short getHoatDong() {
        return hoatDong;
    }

    public void setHoatDong(Short hoatDong) {
        this.hoatDong = hoatDong;
    }

    @XmlTransient
    public Set<Quantri> getQuantriSet() {
        return quantriSet;
    }

    public void setQuantriSet(Set<Quantri> quantriSet) {
        this.quantriSet = quantriSet;
    }

    @XmlTransient
    public Set<Giangvien> getGiangvienSet() {
        return giangvienSet;
    }

    public void setGiangvienSet(Set<Giangvien> giangvienSet) {
        this.giangvienSet = giangvienSet;
    }

    @XmlTransient
    public Set<Chitiethoidong> getChitiethoidongSet() {
        return chitiethoidongSet;
    }

    public void setChitiethoidongSet(Set<Chitiethoidong> chitiethoidongSet) {
        this.chitiethoidongSet = chitiethoidongSet;
    }

    @XmlTransient
    public Set<Giaovu> getGiaovuSet() {
        return giaovuSet;
    }

    public void setGiaovuSet(Set<Giaovu> giaovuSet) {
        this.giaovuSet = giaovuSet;
    }

    @XmlTransient
    public Set<Sinhvien> getSinhvienSet() {
        return sinhvienSet;
    }

    public void setSinhvienSet(Set<Sinhvien> sinhvienSet) {
        this.sinhvienSet = sinhvienSet;
    }

    public Chucvu getChucvumaChucVu() {
        return chucvumaChucVu;
    }

    public void setChucvumaChucVu(Chucvu chucvumaChucVu) {
        this.chucvumaChucVu = chucvumaChucVu;
    }

    @XmlTransient
    public Set<Khoaluan> getKhoaluanSet() {
        return khoaluanSet;
    }

    public void setKhoaluanSet(Set<Khoaluan> khoaluanSet) {
        this.khoaluanSet = khoaluanSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maND != null ? maND.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nguoidung)) {
            return false;
        }
        Nguoidung other = (Nguoidung) object;
        if ((this.maND == null && other.maND != null) || (this.maND != null && !this.maND.equals(other.maND))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.demo.pojo.Nguoidung[ maND=" + maND + " ]";
    }
    
}
