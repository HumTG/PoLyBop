/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import Model.NhanVien;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface NhanVienRepositoryImpl {
    List<NhanVien> getAllNhanVien();
    List<NhanVien> getAllNhanVienKhongHoatDong();
    
    NhanVien getById(String id);
    NhanVien getByIdKhongHoatDong(String id);
    List<NhanVien> findNhanVien(String keyWord);
    abstract public void insert(NhanVien Entity);
    void delete(String sdt);
    void updateKH(NhanVien nv);
    List<NhanVien> searchNVHD(String key);
    List<NhanVien> searchNVKHD(String key);
    List<NhanVien> getNhanVienByPage(int page, int recordsPerPage);
    int getTotalNhanVien();
}
