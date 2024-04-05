/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Windows
 */
public class TKNhanVien_View {
    private String maNV;
    private String tenNV;
    private int slSanPham;
    private float tongDoanhThu;

    public TKNhanVien_View() {
    }


    public TKNhanVien_View(String maNV, String tenNV, int slSanPham, float tongDoanhThu) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.slSanPham = slSanPham;
        this.tongDoanhThu = tongDoanhThu;
        
    }

    public int getSlSanPham() {
        return slSanPham;
    }

    public void setSlSanPham(int slSanPham) {
        this.slSanPham = slSanPham;
    }

    public float getTongDoanhThu() {
        return tongDoanhThu;
    }

    public void setTongDoanhThu(float tongDoanhThu) {
        this.tongDoanhThu = tongDoanhThu;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    
}
