/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Windows
 */
public class TKDoanhThu_Model {
      private int thang;
    private int slSanPham;
    private float tongGiaBan;
    private float tongGiaGia;
    private float tongDoanhThu;

    public TKDoanhThu_Model() {
    }

    public TKDoanhThu_Model(int thang, int slSanPham, float tongGiaBan, float tongGiaGia, float tongDoanhThu) {
        this.thang = thang;
        this.slSanPham = slSanPham;
        this.tongGiaBan = tongGiaBan;
        this.tongGiaGia = tongGiaGia;
        this.tongDoanhThu = tongDoanhThu;
    }

    public int getThang() {
        return thang;
    }

    public void setThang(int thang) {
        this.thang = thang;
    }

    public int getSlSanPham() {
        return slSanPham;
    }

    public void setSlSanPham(int slSanPham) {
        this.slSanPham = slSanPham;
    }

    public float getTongGiaBan() {
        return tongGiaBan;
    }

    public void setTongGiaBan(float tongGiaBan) {
        this.tongGiaBan = tongGiaBan;
    }

    public float getTongGiaGia() {
        return tongGiaGia;
    }

    public void setTongGiaGia(float tongGiaGia) {
        this.tongGiaGia = tongGiaGia;
    }

    public float getTongDoanhThu() {
        return tongDoanhThu;
    }

    public void setTongDoanhThu(float tongDoanhThu) {
        this.tongDoanhThu = tongDoanhThu;
    }
}
