/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.SanPham;
import Model.SanPhamCT;
import Model.Vi;
import Repository.DBconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SanPhamDAO implements InterfaceSanPham {

    @Override
    public List<SanPham> getAll() {
        String sql = " SELECT Ma_Vi,\n"
                + "		TenVi,\n"
                + "		KieuDang,\n"
                + "		ThuongHieu.TenThuongHieu,\n"
                + "		MauSac.TenMauSac,\n"
                + "		ChiTietVi.SoLuong,\n"
                + "		ChiTietVi.GiaBan\n"
                + " FROM Vi \n"
                + " JOIN (ChiTietVi JOIN MauSac ON ChiTietVi.ID_MauSac = MauSac.IDMauSac) ON Vi.IDVi = ChiTietVi.ID_Vi \n"
                + " JOIN ThuongHieu ON Vi.ID_ThuongHieu = ThuongHieu.IDThuongHieu ";
        List<SanPham> list = new ArrayList<>();
        try (Connection con = DBconnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getDouble(7));
                list.add(sp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<SanPham> seachSP(String key) {
        String sql = " SELECT Ma_Vi,\n"
                + "		TenVi,\n"
                + "		KieuDang,\n"
                + "		ThuongHieu.TenThuongHieu,\n"
                + "		MauSac.TenMauSac,\n"
                + "		ChiTietVi.SoLuong,\n"
                + "		ChiTietVi.GiaBan\n"
                + " FROM Vi \n"
                + " JOIN (ChiTietVi JOIN MauSac ON ChiTietVi.ID_MauSac = MauSac.IDMauSac) ON Vi.IDVi = ChiTietVi.ID_Vi \n"
                + " JOIN ThuongHieu ON Vi.ID_ThuongHieu = ThuongHieu.IDThuongHieu Where Ma_Vi like '%" + key + "%' or TenVi like N'%" + key + "%' ";
        List<SanPham> list = new ArrayList<>();
        try (Connection con = DBconnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getDouble(7));
                list.add(sp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int getIDCTSP(String maSP) {
        int id = 0;
        String sql = "SELECT IDChiTietVi\n"
                + "FROM ChiTietVi join Vi on ChiTietVi.ID_Vi = Vi.IDVi where Ma_Vi = '" + maSP + "'";
        try (Connection con = DBconnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public void reduceSLSP(int idCTSP, int soLuong) {
        String sql = "update ChiTietVi set SoLuong = SoLuong - " + soLuong + " where IDChiTietVi = " + idCTSP + " ";
        try (Connection con = DBconnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Lấy ra tổng số lượng sản phẩm 
    @Override
    public int sumSLSP(int IDCTSP, String maHDCT) {
        int sunSL = 0;
        String sql = "	Select ChiTietVi.SoLuong + HoaDonChiTiet.SoLuong\n"
                + "	from ChiTietVi join HoaDonChiTiet on ChiTietVi.IDChiTietVi = HoaDonChiTiet.ID_ChiTietVi\n"
                + "	where ID_ChiTietVi =" + IDCTSP + "  and Ma_HoaDonChiTiet = '" + maHDCT + "'";
        try (Connection con = DBconnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                sunSL = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sunSL;
    }

    @Override
    public void updateSLSP(int IDCTSP, int soLuong) {
        String sql = "update ChiTietVi set SoLuong = " + soLuong + " \n"
                + "where IDChiTietVi = " + IDCTSP + " ";
        try (Connection con = DBconnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addSLSP(int idCTSP, int soLuong) {
        String sql = "update ChiTietVi set SoLuong = SoLuong + " + soLuong + " where IDChiTietVi = " + idCTSP + " ";
        try (Connection con = DBconnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // lấy ra thông tin chi tiết của sản phẩm thông qua mã sản phẩm 
    @Override
    public List<SanPhamCT> getDaTaSPCT(String maSP) {
        String sql = "SELECT Ma_ChiTietVi,TenMauSac,TenChatLieu,\n"
                + "TenXuatXu,TenLoaiVi,KhoaVi,SoNganDungThe,\n"
                + "SoLuong,GiaNhap,ChiTietVi.GiaBan,NgayNhap\n"
                + "from ChiTietVi \n"
                + "join Vi on ChiTietVi.ID_Vi = Vi.IDVi\n"
                + "join MauSac on ChiTietVi.ID_MauSac = MauSac.IDMauSac\n"
                + "join ChatLieu on ChiTietVi.ID_ChatLieu = ChatLieu.IDChatLieu\n"
                + "join XuatXu on ChiTietVi.ID_XuatXu = XuatXu.IDXuatXu\n"
                + "join LoaiVi on ChiTietVi.ID_LoaiVi = LoaiVi.IDLoaiVi\n"
                + "where Vi.Ma_Vi like '" + maSP + "'";
        List<SanPhamCT> list = new ArrayList<>();
        try (Connection con = DBconnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPhamCT spct = new SanPhamCT(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getDouble(9),
                        rs.getDouble(10),
                        rs.getString(11));
                list.add(spct);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int getSoLuongSPCT(String maVi) {
        int SL = 0;
        String sql = "Select COUNT(Ma_ChiTietVi) from ChiTietVi where ID_Vi = (Select IDVi from Vi where Ma_Vi = '"+maVi+"' )"; 
        try (Connection con = DBconnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SL = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SL;
    }

    public Boolean delCTV(Vi id) {
        String sql = "UPDATE Vi set TRANGTHAI = 0 WHERE TenVi = ?";
        try (Connection con = DBconnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ps.setObject(1, id.getTenVi());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
