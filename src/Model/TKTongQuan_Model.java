/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Windows
 */
public class TKTongQuan_Model {
        private int donHang;
    private int sanPham;
    private float doanhThu;

    public TKTongQuan_Model() {
    }

    public TKTongQuan_Model(int donHang, int sanPham, float doanhThu) {
        this.donHang = donHang;
        this.sanPham = sanPham;
        this.doanhThu = doanhThu;
    }

    public int getDonHang() {
        return donHang;
    }

    public void setDonHang(int donHang) {
        this.donHang = donHang;
    }

    public int getSanPham() {
        return sanPham;
    }

    public void setSanPham(int sanPham) {
        this.sanPham = sanPham;
    }

    public float getDoanhThu() {
        return doanhThu;
    }

    public void setDoanhThu(float doanhThu) {
        this.doanhThu = doanhThu;
    }
        @Override
    public String toString() {
        return "TKTongQuan_Model{" + "donHang=" + donHang + ", sanPham=" + sanPham + ", doanhThu=" + doanhThu + '}';
    }
}
