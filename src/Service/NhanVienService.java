/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.NhanVien;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class NhanVienService {
     List<NhanVien> list;
     NhanVienRepository nhanVienRepository = new NhanVienRepository();
    
    public void insert(NhanVien nv) {
        nhanVienRepository.insert(nv);//thằng này thao tác với SQL
    }
    
     public void update(NhanVien nv) {
        nhanVienRepository.updateKH(nv);
    }

    public void delete(String id) {
        nhanVienRepository.delete(id);
    }
    
    public List<NhanVien> Search(String key){
        List<NhanVien> lst_view = new ArrayList<>();
        list = nhanVienRepository.searchNVHD(key);
        for(NhanVien s : list){
            lst_view.add(new NhanVien(s.getIdNhanVien(), s.getHoTen(), s.getSdt(), s.getNgaySinh(), s.getEmail(), s.getDiaChi(), s.getMatKhau(), s.isGioiTinh(), s.isChucVu(), s.isTrangThai()));
        }
        return lst_view;
    }
    
    public List<NhanVien> SearchNVKHD(String key){
        List<NhanVien> lst_view = new ArrayList<>();
        list = nhanVienRepository.searchNVKHD(key);
        for(NhanVien s : list){
            lst_view.add(new NhanVien(s.getIdNhanVien(), s.getHoTen(), s.getSdt(), s.getNgaySinh(), s.getEmail(), s.getDiaChi(), s.getMatKhau(), s.isGioiTinh(), s.isChucVu(), s.isTrangThai()));
        }
        return lst_view;
    }
}
