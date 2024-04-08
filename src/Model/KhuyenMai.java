/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class KhuyenMai {
    private int id;
    private String ma;
    private int giaTri;
    private Date ngayBatDau;
    private Date ngayKetThuc;
    private boolean trangThai;

    public KhuyenMai() {
    }

    public KhuyenMai(String ma, int giaTri, Date ngayBatDau, Date ngayKetThuc, boolean trangThai) {
        this.ma = ma;
        this.giaTri = giaTri;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.trangThai = trangThai;
    }

    public KhuyenMai(int id, String ma, int giaTri, Date ngayBatDau, Date ngayKetThuc, boolean trangThai) {
        this.id = id;
        this.ma = ma;
        this.giaTri = giaTri;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.trangThai = trangThai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public int getGiaTri() {
        return giaTri;
    }

    public void setGiaTri(int giaTri) {
        this.giaTri = giaTri;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

   
    
    

   public Object[] toDataRow(){
    String trangThaiStr = (trangThai) ? "Còn hoạt động" : "Không hoạt động";
    return new Object[]{
        id, ma, giaTri, ngayBatDau, ngayKetThuc, trangThaiStr
    };
   }   
}
