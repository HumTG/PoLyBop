/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.TKSanPham_Model;
import Repository.DBconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Windows
 */
public class TKSanPham_repos implements ITKSanPham_repos{    
    @Override
    public List<TKSanPham_Model> getTKSanPham() {
        List<TKSanPham_Model> list = new ArrayList<>();
        String sql = "Select Ma_Vi,Ma_HoaDonChiTiet,TenVi,TenThuongHieu,TenXuatXu,TenChatLieu,TenLoaiVi,HoaDonChiTiet.SoLuong as N'Số lượng bán'\n" +
"from HoaDon \n" +
"join HoaDonChiTiet on HoaDonChiTiet.ID_HoaDon = HoaDon.IDHoaDon\n" +
"join ChiTietVi on (HoaDonChiTiet.ID_ChiTietVi = ChiTietVi.IDChiTietVi)\n" +
"join Vi on (ChiTietVi.ID_Vi = Vi.IDVi)\n" +
"join ThuongHieu on (Vi.ID_ThuongHieu = ThuongHieu.IDThuongHieu)\n" +
"join XuatXu on (ChiTietVi.ID_XuatXu = XuatXu.IDXuatXu)\n" +
"join ChatLieu on (ChiTietVi.ID_ChatLieu = ChatLieu.IDChatLieu)\n" +
"join LoaiVi on (ChiTietVi.ID_LoaiVi = LoaiVi.IDLoaiVi)\n" +
"where HoaDon.TrangThai = 1";
        
        try(Connection con = DBconnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int slban = 0;
//                if (String.valueOf(rs.getInt(5)).length() > 0) {
//                    slban = rs.getInt(5);
//                }
                list.add(new TKSanPham_Model(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8)));
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<TKSanPham_Model> getTKSanPhamTheoNgay(String batDau, String ketThuc) {
        List<TKSanPham_Model> list = new ArrayList<>();
        String sql = "SELECT thuoctinhsanpham.MaSP, sanpham.Ten,mausac.Ten,thuonghieu.Ten, SUM(ctdonhang.SL) FROM thuoctinhsanpham\n"
                + "                join sanpham on thuoctinhsanpham.MaSP = sanpham.MaSP\n"
                + "                join mausac on mausac.MaMau = SanPham.MaMau\n"
                + "                join thuonghieu on thuonghieu.MaThuongHieu = sanpham.MaThuongHieu\n"
                + "				join ctdonhang on ctdonhang.IdThuocTinh = thuoctinhsanpham.Id\n"
                + "                join donhang on donhang.MaDonHang = ctdonhang.MaDonHang\n"
                + "                                WHERE DATE(donhang.NgayTao) between ?  and ? and donhang.TrangThai != 2\n \n"
                + "                                group by sanpham.MaSP, sanpham.Ten,mausac.Ten,thuonghieu.Ten\n"
                + "UNION\n"
                + "SELECT distinct thuoctinhsanpham.MaSP, sanpham.Ten,mausac.Ten,thuonghieu.Ten, 0 FROM thuoctinhsanpham\n"
                + "                join sanpham on thuoctinhsanpham.MaSP = sanpham.MaSP\n"
                + "                join mausac on mausac.MaMau = SanPham.MaMau\n"
                + "                join thuonghieu on thuonghieu.MaThuongHieu = sanpham.MaThuongHieu\n"
                + "WHERE thuoctinhsanpham.MaSP not in (SELECT distinct thuoctinhsanpham.MaSP from thuoctinhsanpham\n"
                + "				join ctdonhang on ctdonhang.IdThuocTinh = thuoctinhsanpham.Id\n"
                + "                join donhang on donhang.MaDonHang = ctdonhang.MaDonHang\n"
                + "                                WHERE DATE(donhang.NgayTao) between ?   and ? and donhang.TrangThai != 2\n)";
        
        try (Connection con = DBconnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
             ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int slban = 0;
                if (String.valueOf(rs.getInt(5)).length() > 0) {
                    slban = rs.getInt(5);
                }
                 list.add(new TKSanPham_Model(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8)));
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
}
