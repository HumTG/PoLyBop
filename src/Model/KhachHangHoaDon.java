/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;


public class KhachHangHoaDon {
    private String maHD ; 
    private String nameNV ; 
    private double tongTien ; 
    private String ngayThanhToan ; 

    public KhachHangHoaDon(String maHD, String nameNV, double tongTien, String ngayThanhToan) {
        this.maHD = maHD;
        this.nameNV = nameNV;
        this.tongTien = tongTien;
        this.ngayThanhToan = ngayThanhToan;
    }

    public KhachHangHoaDon() {
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getNameNV() {
        return nameNV;
    }

    public void setNameNV(String nameNV) {
        this.nameNV = nameNV;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public String getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(String ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }
    
    
}
