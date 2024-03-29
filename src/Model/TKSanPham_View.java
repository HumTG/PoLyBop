/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Windows
 */
public class TKSanPham_View {
           private String maSP;
           private String machitiet;
    private String ten;
    
    private String thuonghieu;
    private String nhasanxuat;
     private String chatlieu;
    private String loaivi;
    private int slBan;

    public TKSanPham_View() {
    }

    public TKSanPham_View(String maSP, String machitiet, String ten, String thuonghieu, String nhasanxuat, String chatlieu, String loaivi, int slBan) {
        this.maSP = maSP;
        this.machitiet = machitiet;
        this.ten = ten;
        this.thuonghieu = thuonghieu;
        this.nhasanxuat = nhasanxuat;
        this.chatlieu = chatlieu;
        this.loaivi = loaivi;
        this.slBan = slBan;
    }

    public String getMachitiet() {
        return machitiet;
    }

    public void setMachitiet(String machitiet) {
        this.machitiet = machitiet;
    }
    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getThuonghieu() {
        return thuonghieu;
    }

    public void setThuonghieu(String thuonghieu) {
        this.thuonghieu = thuonghieu;
    }

    public String getNhasanxuat() {
        return nhasanxuat;
    }

    public void setNhasanxuat(String nhasanxuat) {
        this.nhasanxuat = nhasanxuat;
    }

    public String getChatlieu() {
        return chatlieu;
    }

    public void setChatlieu(String chatlieu) {
        this.chatlieu = chatlieu;
    }

    public String getLoaivi() {
        return loaivi;
    }

    public void setLoaivi(String loaivi) {
        this.loaivi = loaivi;
    }

    public int getSlBan() {
        return slBan;
    }

    public void setSlBan(int slBan) {
        this.slBan = slBan;
    }
    
}
