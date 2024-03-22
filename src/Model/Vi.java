/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;



/**
 *
 * @author Windows
 */
public class Vi {

    private int IDVi;
    private int ID_ThuongHieu;
    private String Ma_Vi;
    private String KieuDang;
    private String TenVi;
    private String Url_Anh;
    private boolean TrangThai;
    private double giaBan;

    public Vi() {
    }

    public Vi(String TenVi) {
        this.TenVi = TenVi;
    }


    public Vi(int IDVi, int ID_ThuongHieu, String Ma_Vi, String KieuDang, String TenVi, String Url_Anh, boolean TrangThai,double giaBan) {
        this.IDVi = IDVi;
        this.ID_ThuongHieu = ID_ThuongHieu;
        this.Ma_Vi = Ma_Vi;
        this.KieuDang = KieuDang;
        this.TenVi = TenVi;
        this.Url_Anh = Url_Anh;
        this.TrangThai = TrangThai;
        this.giaBan = giaBan;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public int getIDVi() {
        return IDVi;
    }

    public void setIDVi(int IDVi) {
        this.IDVi = IDVi;
    }

    public int getID_ThuongHieu() {
        return ID_ThuongHieu;
    }

    public void setID_ThuongHieu(int ID_ThuongHieu) {
        this.ID_ThuongHieu = ID_ThuongHieu;
    }

    public String getMa_Vi() {
        return Ma_Vi;
    }

    public void setMa_Vi(String Ma_Vi) {
        this.Ma_Vi = Ma_Vi;
    }

    public String getKieuDang() {
        return KieuDang;
    }

    public void setKieuDang(String KieuDang) {
        this.KieuDang = KieuDang;
    }

    public String getTenVi() {
        return TenVi;
    }

    public void setTenVi(String TenVi) {
        this.TenVi = TenVi;
    }

    public String getUrl_Anh() {
        return Url_Anh;
    }

    public void setUrl_Anh(String Url_Anh) {
        this.Url_Anh = Url_Anh;
    }

    public boolean isTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(boolean TrangThai) {
        this.TrangThai = TrangThai;
    }


}
