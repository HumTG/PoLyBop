/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Admin
 */
public class SanPham {
    private String maVi ; 
    private String tenVi ; 
    private String kieuDang ; 
    private String thuongHieu ; 
    private String mauSac ; 
    private int soLuong ; 
    private double giaBan ; 

    public SanPham(String maVi, String tenVi, String kieuDang, String thuongHieu, String mauSac, int soLuong, double giaBan) {
        this.maVi = maVi;
        this.tenVi = tenVi;
        this.kieuDang = kieuDang;
        this.thuongHieu = thuongHieu;
        this.mauSac = mauSac;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
    }

    public SanPham() {
    }

    
    public String getMaVi() {
        return maVi;
    }

    public void setMaVi(String maVi) {
        this.maVi = maVi;
    }

    public String getTenVi() {
        return tenVi;
    }

    public void setTenVi(String tenVi) {
        this.tenVi = tenVi;
    }

    public String getKieuDang() {
        return kieuDang;
    }

    public void setKieuDang(String kieuDang) {
        this.kieuDang = kieuDang;
    }

    public String getThuongHieu() {
        return thuongHieu;
    }

    public void setThuongHieu(String thuongHieu) {
        this.thuongHieu = thuongHieu;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }
    
}
