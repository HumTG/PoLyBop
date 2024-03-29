/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Admin
 */
public class SanPhamCT {
    private String maCTSP; 
    private String tenMauSac ; 
    private String tenChatLieu ;
    private String tenXuatXu ; 
    private String tenLoaiVi ; 
    private String khoaVi ; 
    private String soNgan ; 
    private int soLuongSP ; 
    private double giaNhapSP ; 
    private double giaBanSP ; 
    private String ngayNhap ; 

    public SanPhamCT() {
    }

    
    public SanPhamCT(String maCTSP, String tenMauSac, String tenChatLieu, String tenXuatXu, String tenLoaiVi, String khoaVi, String soNgan, int soLuongSP, double giaNhapSP, double giaBanSP, String ngayNhap) {
        this.maCTSP = maCTSP;
        this.tenMauSac = tenMauSac;
        this.tenChatLieu = tenChatLieu;
        this.tenXuatXu = tenXuatXu;
        this.tenLoaiVi = tenLoaiVi;
        this.khoaVi = khoaVi;
        this.soNgan = soNgan;
        this.soLuongSP = soLuongSP;
        this.giaNhapSP = giaNhapSP;
        this.giaBanSP = giaBanSP;
        this.ngayNhap = ngayNhap;
    }

    public String getMaCTSP() {
        return maCTSP;
    }

    public void setMaCTSP(String maCTSP) {
        this.maCTSP = maCTSP;
    }

    public String getTenMauSac() {
        return tenMauSac;
    }

    public void setTenMauSac(String tenMauSac) {
        this.tenMauSac = tenMauSac;
    }

    public String getTenChatLieu() {
        return tenChatLieu;
    }

    public void setTenChatLieu(String tenChatLieu) {
        this.tenChatLieu = tenChatLieu;
    }

    public String getTenXuatXu() {
        return tenXuatXu;
    }

    public void setTenXuatXu(String tenXuatXu) {
        this.tenXuatXu = tenXuatXu;
    }

    public String getTenLoaiVi() {
        return tenLoaiVi;
    }

    public void setTenLoaiVi(String tenLoaiVi) {
        this.tenLoaiVi = tenLoaiVi;
    }



    public String getKhoaVi() {
        return khoaVi;
    }

    public void setKhoaVi(String khoaVi) {
        this.khoaVi = khoaVi;
    }

    public String getSoNgan() {
        return soNgan;
    }

    public void setSoNgan(String soNgan) {
        this.soNgan = soNgan;
    }

    public int getSoLuongSP() {
        return soLuongSP;
    }

    public void setSoLuongSP(int soLuongSP) {
        this.soLuongSP = soLuongSP;
    }

    public double getGiaNhapSP() {
        return giaNhapSP;
    }

    public void setGiaNhapSP(double giaNhapSP) {
        this.giaNhapSP = giaNhapSP;
    }

    public double getGiaBanSP() {
        return giaBanSP;
    }

    public void setGiaBanSP(double giaBanSP) {
        this.giaBanSP = giaBanSP;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    
    
}
