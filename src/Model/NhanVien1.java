/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Windows
 */
public class NhanVien1 {
    private int IDNhanVien;
    private String Ma_NhanVien;
    private String HoTen;

    public NhanVien1() {
    }

    public NhanVien1(int IDNhanVien, String Ma_NhanVien, String HoTen) {
        this.IDNhanVien = IDNhanVien;
        this.Ma_NhanVien = Ma_NhanVien;
        this.HoTen = HoTen;
    }

    public int getIDNhanVien() {
        return IDNhanVien;
    }

    public void setIDNhanVien(int IDNhanVien) {
        this.IDNhanVien = IDNhanVien;
    }

    public String getMa_NhanVien() {
        return Ma_NhanVien;
    }

    public void setMa_NhanVien(String Ma_NhanVien) {
        this.Ma_NhanVien = Ma_NhanVien;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }
    
}
