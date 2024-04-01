/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class NhanVien {

    private int idNhanVien;
    private String maNhanVien;
    private String hoTen;
    private boolean chucVu;
    private Date ngaySinh;
    private String sdt;
    private String email;
    private boolean gioiTinh;
    private String diaChi;
    private String matKhau;
    private boolean trangThai;

    public NhanVien() {
    }

    public NhanVien(int idNhanVien, String maNhanVien, String hoTen, boolean chucVu, Date ngaySinh, String sdt, String email, boolean gioiTinh, String diaChi, String matKhau, boolean trangThai) {
        this.idNhanVien = idNhanVien;
        this.maNhanVien = maNhanVien;
        this.hoTen = hoTen;
        this.chucVu = chucVu;
        this.ngaySinh = ngaySinh;
        this.sdt = sdt;
        this.email = email;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.matKhau = matKhau;
        this.trangThai = trangThai;
    }

    public NhanVien(String maNhanVien, String hoTen, boolean chucVu, Date ngaySinh, String sdt, String email, boolean gioiTinh, String diaChi, String matKhau, boolean trangThai) {
        this.maNhanVien = maNhanVien;
        this.hoTen = hoTen;
        this.chucVu = chucVu;
        this.ngaySinh = ngaySinh;
        this.sdt = sdt;
        this.email = email;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.matKhau = matKhau;
        this.trangThai = trangThai;
    }

    public int getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(int idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public boolean isChucVu() {
        return chucVu;
    }

    public void setChucVu(boolean chucVu) {
        this.chucVu = chucVu;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }


    

    
    public Object[] todata(){
        return new Object[]{maNhanVien, hoTen, isChucVu()? "Admin" : "Nhân viên", ngaySinh, sdt, email, isGioiTinh()? "Nam" : "Nữ",diaChi, matKhau,isTrangThai()? "Đang hoạt động" : "Không hoạt động"};
    }

    
}
