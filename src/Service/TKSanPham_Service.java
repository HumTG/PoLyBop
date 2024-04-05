/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.TKNhanVien_Model;
import Model.TKNhanVien_View;
import Model.TKSanPham_Model;
import Model.TKSanPham_View;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Windows
 */
public class TKSanPham_Service implements ITKSanPham_Service{

   ITKSanPham_repos repo = new TKSanPham_repos();
    List<TKSanPham_Model> list = new ArrayList<>();
    List<TKNhanVien_Model> listNV = new ArrayList<>();
    @Override
    public List<TKSanPham_View> getTKSanPham() {
        list =repo.getTKSanPham();
        List<TKSanPham_View> list_view = new ArrayList<>();
        
        for (TKSanPham_Model t : list) {
            list_view.add(new TKSanPham_View( t.getMaSP(),t.getMachitiet(), t.getTen(),t.getThuonghieu(), t.getNhasanxuat(),t.getChatlieu(),t.getLoaivi(),t.getSlBan()));
            
        }
        return list_view;
    }

    @Override
    public List<TKSanPham_View> getTKSanPham(String batDau, String ketThuc) {
       list =repo.getTKSanPhamTheoNgay(batDau, ketThuc);
        List<TKSanPham_View> list_view = new ArrayList<>();
        int stt = 1;
        for (TKSanPham_Model t : list) {
             list_view.add(new TKSanPham_View( t.getMaSP(),t.getMachitiet(), t.getTen(),t.getThuonghieu(), t.getNhasanxuat(),t.getChatlieu(),t.getLoaivi(),t.getSlBan()));
        }
        return list_view; 
    }
    
    @Override
    public List<TKNhanVien_View> getTKNhanVien() {
        listNV = repo.getTKNhanVien();
        List<TKNhanVien_View> list_view = new ArrayList<>();
        
        for (TKNhanVien_Model t : listNV) {
            list_view.add(new TKNhanVien_View(t.getMaNV(),t.getTenNV(), t.getSlSanPham(),t.getTongDoanhThu()));
            
        }
        return list_view;
    }
}
