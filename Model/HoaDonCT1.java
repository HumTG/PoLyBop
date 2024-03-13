/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;


public class HoaDonCT1 {
    private String maHDCT ; 
    private int idCTVI ; 
    private String maVi ; 
    private String tenVi ; 
    private int soLuong ; 
    private double tongTien; 

    public HoaDonCT1(String maHDCT, int idCTVI, String maVi, String tenVi, int soLuong, double tongTien) {
        this.maHDCT = maHDCT;
        this.idCTVI = idCTVI;
        this.maVi = maVi;
        this.tenVi = tenVi;
        this.soLuong = soLuong;
        this.tongTien = tongTien;
    }

    public HoaDonCT1() {
    }

    public String getMaHDCT() {
        return maHDCT;
    }

    public void setMaHDCT(String maHDCT) {
        this.maHDCT = maHDCT;
    }

    public int getIdCTVI() {
        return idCTVI;
    }

    public void setIdCTVI(int idCTVI) {
        this.idCTVI = idCTVI;
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

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }
    
}
