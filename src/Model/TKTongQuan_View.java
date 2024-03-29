/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Windows
 */
public class TKTongQuan_View {
        private int donHang;
    private int sanPham;
    private float doanhthu;

    public TKTongQuan_View() {
    }

    public TKTongQuan_View(int donHang, int sanPham, float doanhthu) {
        this.donHang = donHang;
        this.sanPham = sanPham;
        this.doanhthu = doanhthu;
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

    public float getDoanhthu() {
        return doanhthu;
    }

    public void setDoanhthu(float doanhthu) {
        this.doanhthu = doanhthu;
    }
    
}
