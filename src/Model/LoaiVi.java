/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Xuan Dat
 */
public class LoaiVi {
    private int idLoaiVi;
    private String Ma_LoaiVi;
    private String tenLoaiVi;
    private boolean trangThai;

    public LoaiVi() {
    }

    public LoaiVi(int idLoaiVi, String Ma_LoaiVi, String tenLoaiVi, boolean trangThai) {
        this.idLoaiVi = idLoaiVi;
        this.Ma_LoaiVi = Ma_LoaiVi;
        this.tenLoaiVi = tenLoaiVi;
        this.trangThai = trangThai;
    }

    public int getIdLoaiVi() {
        return idLoaiVi;
    }

    public void setIdLoaiVi(int idLoaiVi) {
        this.idLoaiVi = idLoaiVi;
    }

    public String getMa_LoaiVi() {
        return Ma_LoaiVi;
    }

    public void setMa_LoaiVi(String Ma_LoaiVi) {
        this.Ma_LoaiVi = Ma_LoaiVi;
    }

    public String getTenLoaiVi() {
        return tenLoaiVi;
    }

    public void setTenLoaiVi(String tenLoaiVi) {
        this.tenLoaiVi = tenLoaiVi;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
    
    
}
