/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;


/**
 *
 * @author Windows
 */
public class XuatXu {
    private int idXuatXu;
    private String Ma_XuatXu;
    private String tenXuatXu;
    private boolean trangThai;

    public XuatXu() {
    }

    public XuatXu(int idXuatXu, String Ma_XuatXu, String tenXuatXu, boolean trangThai) {
        this.idXuatXu = idXuatXu;
        this.Ma_XuatXu = Ma_XuatXu;
        this.tenXuatXu = tenXuatXu;
        this.trangThai = trangThai;
    }


    public int getIdXuatXu() {
        return idXuatXu;
    }

    public void setIdXuatXu(int idXuatXu) {
        this.idXuatXu = idXuatXu;
    }

    public String getTenXuatXu() {
        return tenXuatXu;
    }

    public void setTenXuatXu(String tenXuatXu) {
        this.tenXuatXu = tenXuatXu;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public String getMa_XuatXu() {
        return Ma_XuatXu;
    }

    public void setMa_XuatXu(String Ma_XuatXu) {
        this.Ma_XuatXu = Ma_XuatXu;
    }
    
}
