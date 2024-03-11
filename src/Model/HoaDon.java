/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class HoaDon {
    private int IdHoaDon;
    private int IdKhachHang;
    private int IdNhanVien;
    private int IdKhuyenMai;
    private String MaHoaDon;
   private  double TienSauGiamGia;
   private double ThanhTien;
   private boolean PhuongThucThanhToan;
   private Date NgayThanhToan;
   private boolean TrangThai;
   
   public HoaDon(){}

    public HoaDon(int IdHoaDon, int IdKhachHang, int IdNhanVien, int IdKhuyenMai,String maHoaDon ,double TienSauGiamGia, double ThanhTien, boolean PhuongThucThanhToan, Date NgayThanhToan, boolean TrangThai) {
        this.IdHoaDon = IdHoaDon;
        this.IdKhachHang = IdKhachHang;
        this.IdNhanVien = IdNhanVien;
        this.IdKhuyenMai = IdKhuyenMai;
        this.MaHoaDon = maHoaDon;
        this.TienSauGiamGia = TienSauGiamGia;
        this.ThanhTien = ThanhTien;
        this.PhuongThucThanhToan = PhuongThucThanhToan;
        this.NgayThanhToan = NgayThanhToan;
        this.TrangThai = TrangThai;
    }

    public String getMaHoaDon() {
        return MaHoaDon;
    }

    public void setMaHoaDon(String MaHoaDon) {
        this.MaHoaDon = MaHoaDon;
    }
   
    public int getIdHoaDon() {
        return IdHoaDon;
    }

    public void setIdHoaDon(int IdHoaDon) {
        this.IdHoaDon = IdHoaDon;
    }

    public int getIdKhachHang() {
        return IdKhachHang;
    }

    public void setIdKhachHang(int IdKhachHang) {
        this.IdKhachHang = IdKhachHang;
    }

    public int getIdNhanVien() {
        return IdNhanVien;
    }

    public void setIdNhanVien(int IdNhanVien) {
        this.IdNhanVien = IdNhanVien;
    }

    public int getIdKhuyenMai() {
        return IdKhuyenMai;
    }

    public void setIdKhuyenMai(int IdKhuyenMai) {
        this.IdKhuyenMai = IdKhuyenMai;
    }

    public double getTienSauGiamGia() {
        return TienSauGiamGia;
    }

    public void setTienSauGiamGia(double TienSauGiamGia) {
        this.TienSauGiamGia = TienSauGiamGia;
    }

    public double getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(double ThanhTien) {
        this.ThanhTien = ThanhTien;
    }

    public boolean isPhuongThucThanhToan() {
        return PhuongThucThanhToan;
    }

    public void setPhuongThucThanhToan(boolean PhuongThucThanhToan) {
        this.PhuongThucThanhToan = PhuongThucThanhToan;
    }

    public Date getNgayThanhToan() {
        return NgayThanhToan;
    }

    public void setNgayThanhToan(Date NgayThanhToan) {
        this.NgayThanhToan = NgayThanhToan;
    }

    public boolean isTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(boolean TrangThai) {
        this.TrangThai = TrangThai;
    }

  
   
}
