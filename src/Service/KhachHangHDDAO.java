/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.HoaDonCT1;
import Model.KhachHangHoaDon;
import Repository.DBconnect;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.apache.poi.poifs.crypt.CipherAlgorithm;

/**
 *
 * @author Admin
 */
public class KhachHangHDDAO implements InterfaceKHHoaDon {

    @Override
    public List<KhachHangHoaDon> getAll(int idKH) {
        String sql = "Select Ma_HoaDon,HoTen as N'Nhân viên thanh toán',ThanhTien , NgayThanhToan \n"
                + "from HoaDon \n"
                + "join NhanVien on HoaDon.ID_NhanVien = NhanVien.IDNhanVien\n"
                + "where ID_KhachHang = " + idKH + " and Hoadon.TrangThai = 1";
        List<KhachHangHoaDon> list = new ArrayList<>();
        try (Connection con = DBconnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHangHoaDon kh = new KhachHangHoaDon(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getString(4));
                list.add(kh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<HoaDonCT1> getAllHDCT(String maHD) {
        String sql = "Select Ma_Vi,TenVi,HoaDonChiTiet.SoLuong,DonGia\n"
                + "from HoaDonChiTiet\n"
                + "join ChiTietVi on ChiTietVi.IDChiTietVi = HoaDonChiTiet.ID_ChiTietVi\n"
                + "join Vi on ChiTietVi.ID_Vi = Vi.IDVi \n"
                + "join HoaDon on HoaDonChiTiet.ID_HoaDon = HoaDon.IDHoaDon\n"
                + "where Ma_HoaDon = '"+maHD+"'";
        List<HoaDonCT1> list = new ArrayList<>();
        try (Connection con = DBconnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonCT1 hdct = new HoaDonCT1("", 0,rs.getString(1),rs.getString(2),rs.getInt(3),rs.getDouble(4)); 
                list.add(hdct); 
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
