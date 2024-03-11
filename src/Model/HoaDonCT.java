/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import org.apache.poi.hpsf.Decimal;

/**
 *
 * @author Admin
 */
public class HoaDonCT {
    private String maHD ; 
    private String tenKH ; 
    private String tenNV ; 
    private int IDKM ; 
    private double tienSauGiamGia ; 
    private double thanhTien ; 
    private int phuongThucThanhToan; 
    private String ngayTT ; 
    private int trangThai ; 

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public int getIDKM() {
        return IDKM;
    }

    public void setIDKM(int IDKM) {
        this.IDKM = IDKM;
    }

    public double getTienSauGiamGia() {
        return tienSauGiamGia;
    }

    public void setTienSauGiamGia(double tienSauGiamGia) {
        this.tienSauGiamGia = tienSauGiamGia;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

    public int getPhuongThucThanhToan() {
        return phuongThucThanhToan;
    }
    
    public String getPTTT(){
        if (phuongThucThanhToan == 0) {
            return "Tiền mặt"; 
        }
        else {
            return "Chuyển Khoản"; 
        }
    }

    public void setPhuongThucThanhToan(int phuongThucThanhToan) {
        this.phuongThucThanhToan = phuongThucThanhToan;
    }

    public String getNgayTT() {
        return ngayTT;
    }

    public void setNgayTT(String ngayTT) {
        this.ngayTT = ngayTT;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
    public String getTT(){
        if (getTrangThai() == 1) {
            return "Đã Thanh Toán"; 
        }
        else {
            return "Chưa Thanh Toán"; 
        }
    }

    public HoaDonCT(String maHD, String tenKH, String tenNV, int IDKM, double tienSauGiamGia, double thanhTien, int phuongThucThanhToan, String ngayTT, int trangThai) {
        this.maHD = maHD;
        this.tenKH = tenKH;
        this.tenNV = tenNV;
        this.IDKM = IDKM;
        this.tienSauGiamGia = tienSauGiamGia;
        this.thanhTien = thanhTien;
        this.phuongThucThanhToan = phuongThucThanhToan;
        this.ngayTT = ngayTT;
        this.trangThai = trangThai;
    }

    public HoaDonCT() {
    }
    
}
