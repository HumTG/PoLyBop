/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.TKSanPham_Model;
import Model.TKSanPham_View;
import Repository.DBconnect;
import java.util.ArrayList;
import java.util.List;
import java.sql.*; 
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Windows
 */
public class TKSanPham_Service implements ITKSanPham_Service {

    ITKSanPham_repos repo = new TKSanPham_repos();
    List<TKSanPham_Model> list = new ArrayList<>();

    @Override
    public List<TKSanPham_View> getTKSanPham() {
        list = repo.getTKSanPham();
        List<TKSanPham_View> list_view = new ArrayList<>();

        for (TKSanPham_Model t : list) {
            list_view.add(new TKSanPham_View(t.getMaSP(), t.getMachitiet(), t.getTen(), t.getThuonghieu(), t.getNhasanxuat(), t.getChatlieu(), t.getLoaivi(), t.getSlBan()));

        }
        return list_view;
    }

    @Override
    public List<TKSanPham_View> getTKSanPham(String batDau, String ketThuc) {
        list = repo.getTKSanPhamTheoNgay(batDau, ketThuc);
        List<TKSanPham_View> list_view = new ArrayList<>();
        int stt = 1;
        for (TKSanPham_Model t : list) {
            list_view.add(new TKSanPham_View(t.getMaSP(), t.getMachitiet(), t.getTen(), t.getThuonghieu(), t.getNhasanxuat(), t.getChatlieu(), t.getLoaivi(), t.getSlBan()));
        }
        return list_view;
    }

    @Override
    public int DonHang() {
        String sql = "Select COUNT(IDHoaDon) as N'Tổng hóa đơn' from HoaDon where TrangThai = 1 ";
        int sum = 0;
        try (Connection con = DBconnect.getConnection(); PreparedStatement pr = con.prepareCall(sql)) {
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                sum = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sum;
    }
    @Override
    public int SanPham() {
        String sql ="Select COUNT(IDVi) as N'Tổng sản phẩm' from Vi where TrangThai = 1 ";
        int sum=0;
        try(Connection con = DBconnect.getConnection(); PreparedStatement pr = con.prepareCall(sql)){
            ResultSet rs = pr.executeQuery();
            while (rs.next()){
                sum = rs.getInt(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return sum;
    }

//    @Override
//    public int DoanhThu() {
//        
//    }

    @Override
    public double DoanhThu() {
        String sql ="Select SUM(ThanhTien) as N'Tổng Tiền' from HoaDon where TrangThai = 1";
        double sum=0;
        try(Connection con = DBconnect.getConnection(); PreparedStatement pr = con.prepareCall(sql)){
            ResultSet rs = pr.executeQuery();
            while (rs.next()){
                sum = rs.getDouble(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return sum;
    }
    

}
