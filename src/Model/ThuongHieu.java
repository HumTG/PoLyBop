/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;



/**
 *
 * @author Windows
 */
public class ThuongHieu {
    private int idThuongHieu;
    private String Ma_ThuongHieu;
    private String tenThuongHieu;
    private boolean trangThai;

    public ThuongHieu() {
    }

    public ThuongHieu(int idThuongHieu, String Ma_ThuongHieu, String tenThuongHieu, boolean trangThai) {
        this.idThuongHieu = idThuongHieu;
        this.Ma_ThuongHieu = Ma_ThuongHieu;
        this.tenThuongHieu = tenThuongHieu;
        this.trangThai = trangThai;
    }

    public String getMa_ThuongHieu() {
        return Ma_ThuongHieu;
    }

    public void setMa_ThuongHieu(String Ma_ThuongHieu) {
        this.Ma_ThuongHieu = Ma_ThuongHieu;
    }


    public int getIdThuongHieu() {
        return idThuongHieu;
    }

    public void setIdThuongHieu(int idThuongHieu) {
        this.idThuongHieu = idThuongHieu;
    }

    public String getTenThuongHieu() {
        return tenThuongHieu;
    }

    public void setTenThuongHieu(String tenThuongHieu) {
        this.tenThuongHieu = tenThuongHieu;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    
}
