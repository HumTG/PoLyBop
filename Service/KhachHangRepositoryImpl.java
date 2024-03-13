/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import Model.KhachHang;
import java.util.List;


/**
 *
 * @author ADMIN
 */
public interface KhachHangRepositoryImpl {
     List<KhachHang> getAllKhachHang();
    KhachHang getById(String SĐT);
    List<KhachHang> FindKhachHang(String keyWord);
    abstract public void insert(KhachHang Entity);
  
    void delKH(String sdt);
    void updateKH(KhachHang kh);  
    List<KhachHang> searchKH(String key);
    List<KhachHang> getKHByPage(int page, int recordsPerPage);
    int getTotalKH();
    
}
